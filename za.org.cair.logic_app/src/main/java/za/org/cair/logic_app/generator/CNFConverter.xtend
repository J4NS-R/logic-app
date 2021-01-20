package za.org.cair.logic_app.generator

import org.eclipse.emf.ecore.resource.Resource
import za.org.cair.logic_app.logicLang.Proposition
import za.org.cair.logic_app.logicLang.Sentence
import za.org.cair.logic_app.logicLang.BooleanLiteral
import za.org.cair.logic_app.logicLang.BooleanVariable
import za.org.cair.logic_app.logicLang.Conjunction
import za.org.cair.logic_app.logicLang.Disjunction
import za.org.cair.logic_app.logicLang.Negation
import za.org.cair.logic_app.logicLang.Implication
import za.org.cair.logic_app.logicLang.Equivalence
import za.org.cair.logic_app.logicLang.impl.NegationImpl
import za.org.cair.logic_app.logicLang.impl.DisjunctionImpl
import za.org.cair.logic_app.logicLang.impl.ConjunctionImpl
import za.org.cair.logic_app.LogicLangHelper
import za.org.cair.logic_app.logicLang.Command
import za.org.cair.logic_app.logicLang.impl.CommandImpl
import za.org.cair.logic_app.logicLang.impl.VariantTranslationCommandImpl
import za.org.cair.logic_app.logicLang.LogicLangVariant

class CNFConverter {
	
	// String outputter, thanks to VariantTranslator
	VariantTranslator stringifier 
	
	/**
	 * Constructor. Sets up necessary internal components for conversion
	 */
	new(){
		stringifier = new VariantTranslator(new VariantTranslationCommandImpl(){
			override getVariant() {
				return LogicLangVariant.SYMBOL_OP
			}
		})
	}
	
	/**
	 * Converts a set of propositions to Conunctive Normal Form,
	 * in the same format accepted by this program. 
	 * Note that this is a simple per-proposition conversion.
	 * Also note that T and F literals will be treated as variables and not be simplified
	 * TODO: This is a flaw.
	 */
	def String convertToCNF(Resource res){
		val outStr = new StringBuilder();
		// A set of props is basically a bunch of conjuctions.
		// So converting each to CNF is equivalent to converting the entire thing to CNF.
		res.allContents.filter(Proposition).forEach [ prop |
			val sent = convertSentenceToCNF(prop.sentence)
			outStr.append("prop ")
				.append(stringifier.expressionToString(sent))
				.append("\n")
		]
		
		return outStr.toString()
	}
	
	/**
	 * Converts input to logical Negation Normal Form and returns in the same
	 * format accepted by this app.
	 */
	def String convertToNNF(Resource res){
		val outStr = new StringBuilder();
		// A set of props is basically a bunch of conjuctions.
		// So converting each to CNF is equivalent to converting the entire thing to CNF.
		res.allContents.filter(Proposition).forEach [ prop |
			val sent = convertSentenceToNNF(prop.sentence)
			outStr.append("prop ")
				.append(stringifier.expressionToString(sent))
				.append("\n")
		]
		
		return outStr.toString()
	}
	
	/**
	 * Converts a sentence to CNF. I.e. makes it a bunch of conjunctions of disjunctions
	 * Works by recursively  
	 */
	def private Sentence convertSentenceToCNF(Sentence sent){
		if (LogicLangHelper.isAtomic(sent)){
			// nothing to do
			return sent
		}else if (sent instanceof Conjunction){
			//todo
		}else if (sent instanceof Disjunction){
			val leftSide = sent.left
			val rightSide = sent.right
			// cases:
			if (rightSide instanceof Conjunction){ // ls | (Q & R)
				val Q = rightSide.left
				val R = rightSide.right
				// return (ls | Q) & (ls | R) - distributive law
				return convertSentenceToCNF(newConjunction(
					newDisjunction(leftSide, Q),
					newDisjunction(leftSide, R)
				))
			}else if (leftSide instanceof Conjunction){ // (P & R) | rs
				val P = leftSide.left
				val R = leftSide.right
				// return (P | rs) & (R | rs) - distributive law
				return convertSentenceToCNF(newConjunction(
					newDisjunction(P, rightSide),
					newDisjunction(R, rightSide)
				))
			}else if (LogicLangHelper.isAtomic(leftSide)){
				// todo
				
			}else{ // something else
				// convert insides and runs again
				sent.left = convertSentenceToCNF(sent.left)
				sent.right = convertSentenceToCNF(sent.right)
				return convertSentenceToCNF(sent)
			}
			
		}else{ // shouldn't happen
			throw new IllegalArgumentException("Could not convert sentence: " + sent);
		}
	}
	
	/**
	 * Converts a sentence to Negation Normal Form. I.e. only &'s, |'s, and ~'s (on atoms). 
	 * Requirement for CNF conversion.
	 */
	def private Sentence convertSentenceToNNF(Sentence sent){
		if (sent instanceof Negation){
			val expr = (sent as Negation).expression
			// 4 cases:
			if (LogicLangHelper.isAtomic(expr)){ // ~P
				return sent // nothing to change
				
			}else if (expr instanceof Negation){ // ~(~P)
				// return inner P only
				return convertSentenceToNNF((expr as Negation).expression) 
				
			}else if (expr instanceof Conjunction){ // ~(P & Q)
				val conjSent = expr as Conjunction
				// return (~P | ~Q) - de Morgan's Law
				return convertSentenceToNNF(newDisjunction(
					newNegation(conjSent.left), 
					newNegation(conjSent.right)
				))
				
			}else if (expr instanceof Disjunction){ // ~(P | Q)
				val disjSent = expr as Disjunction
				// return (~P & ~Q) - de Morgan's Law
				return convertSentenceToNNF(newConjunction(
					newNegation(disjSent.left), 
					newNegation(disjSent.right)
				))
				
			}else{ // equivalence or implication
				// convert inside, and run outer conversion again
				sent.expression = convertSentenceToNNF(expr)
				return convertSentenceToNNF(sent)
			}
			
		}else if (sent instanceof Implication){
			// P -> Q is equiv to ~P | Q
			val notP = newNegation(sent.left)
			val Q = sent.right
			return convertSentenceToNNF(newDisjunction(notP, Q))
			
		}else if (sent instanceof Equivalence){
			// P <-> Q is equiv to ((P & Q) | (~P & ~Q))
			val P = sent.left
			val Q = sent.right
			return convertSentenceToNNF(newDisjunction(
				newConjunction(P, Q),
				newConjunction(newNegation(P), newNegation(Q))
			))
			
		}else if (sent instanceof Disjunction){
			// convert insides only
			sent.left = convertSentenceToNNF(sent.left)
			sent.right = convertSentenceToNNF(sent.right)
			return sent

		}else if (sent instanceof Conjunction){
			// convert insides only
			sent.left = convertSentenceToNNF(sent.left)
			sent.right = convertSentenceToNNF(sent.right)
			return sent
			
		}else{ // atomic
			return sent
		}
	}
	
	// =====
	// These 3 Methods create new logical operators that are compatible with EMF and xtext.
	// To be used for expanding/converting logical expressions.
	// It is crucial that each internal arg be a distinct copy so as to protect copies from being
	// modified by xtext's internals. Now that was a bug from hell. 
	def private static Negation newNegation(Sentence expr){
		val neg = new NegationImpl(){}
		neg.expression = LogicLangHelper.copyOf(expr)
		return neg
	}
	def private static Disjunction newDisjunction(Sentence leftArg, Sentence rightArg){
		val disj = new DisjunctionImpl(){}
		disj.left = LogicLangHelper.copyOf(leftArg)
		disj.right = LogicLangHelper.copyOf(rightArg)
		return disj
	}
	def private static Conjunction newConjunction(Sentence leftArg, Sentence rightArg){
		val conj = new ConjunctionImpl(){}
		conj.left = LogicLangHelper.copyOf(leftArg)
		conj.right = LogicLangHelper.copyOf(rightArg)
		return conj
	}
	// =====
	
}
