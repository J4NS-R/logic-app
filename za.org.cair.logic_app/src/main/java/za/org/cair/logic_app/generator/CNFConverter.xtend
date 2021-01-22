package za.org.cair.logic_app.generator

import java.util.LinkedList
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import za.org.cair.logic_app.LogicLangHelper
import za.org.cair.logic_app.logicLang.Conjunction
import za.org.cair.logic_app.logicLang.Disjunction
import za.org.cair.logic_app.logicLang.Equivalence
import za.org.cair.logic_app.logicLang.Implication
import za.org.cair.logic_app.logicLang.LogicLangVariant
import za.org.cair.logic_app.logicLang.Model
import za.org.cair.logic_app.logicLang.Negation
import za.org.cair.logic_app.logicLang.Proposition
import za.org.cair.logic_app.logicLang.Sentence
import za.org.cair.logic_app.logicLang.impl.ConjunctionImpl
import za.org.cair.logic_app.logicLang.impl.DisjunctionImpl
import za.org.cair.logic_app.logicLang.impl.NegationImpl
import za.org.cair.logic_app.logicLang.impl.VariantTranslationCommandImpl
import za.org.cair.logic_app.logicLang.BooleanVariable
import za.org.cair.logic_app.logicLang.BooleanLiteral
import za.org.cair.logic_app.logicLang.BooleanValuesEnum
import java.util.HashMap

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
	 * Converts a set of propositions to Conjunctive Normal Form,
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
			var sent = convertSentenceToNNF(prop.sentence) // convert to NNF
			sent = convertSentenceToCNF(sent) // then convert to CNF
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
	 * Converts model to DIMACS-compliant SAT input format.
	 * https://jix.github.io/varisat/manual/0.2.0/formats/dimacs.html
	 */
	def String convertToDIMACS(Resource res){
		val outStr = new StringBuilder();
		// DIMACS comment
		outStr.append("c Generated from .logic input file\n")
		
		// General strategy: convert all props to one big conjunctive sentence
		// convert it to CNF, split by Conjunction, and build DIMACS clauses
		
		// get props-iterator from props from model from EMF resource
		val iter = res.allContents.filter(Model).next.propositions.iterator
		var bigSentence = iter.next.sentence // first prop
		while (iter.hasNext){ // conjoin all props
			bigSentence = newConjunction(
				bigSentence,
				iter.next.sentence
			)
		}
		
		// convert everything to CNF prop
		bigSentence = convertSentenceToNNF(bigSentence)
		bigSentence = convertSentenceToCNF(bigSentence)
		
		// get clauses from tree by splitting on conj's
		val clauses = splitByConjunction(bigSentence)
		
		// create body and term-ID mapping
		val termMapping = new HashMap<String, Integer>
		val body = new StringBuilder();
		clauses.forEach[ clause |
			// for each terminal in the clause:
			getTerminals(clause).forEach[ term |
				// get or create ID
				val termID = termMapping.computeIfAbsent(term.key, [k |
					return termMapping.size + 1 // so first entry starts at ID 1
				])
				// push to body
				if (!term.value){ // the pair "value" indicates whether negated
					body.append("-")
				}
				body.append(termID).append(" ")
			]
			// end clause (and line)
			body.append("0\n")
		]
		
		// print out term-ID mapping
		outStr.append("c Terminals by ID:\n")
		termMapping.entrySet.sortBy[entry | entry.value].forEach[ entry |
			outStr.append(String.format("c %d=%s\n", entry.value, entry.key))
		]
		
		// DIMACS header
		outStr.append(String.format("p cnf %d %d\n", termMapping.size, clauses.length))
		
		// add generated body
		outStr.append(body)
		
		return outStr.toString()
	}
	
	/**
	 * Splits a sentence into a list of sub-sentences with delimiter being conjunctions.
	 * Like String.split(), but on a logic tree instead.
	 * Note: expects CNF.
	 */
	def private List<Sentence> splitByConjunction(Sentence sent){
		
		// General strategy: DFS-left, making a list of non-conj children on Conjunctions
		
		if (sent instanceof Conjunction){
			val leftList = splitByConjunction(sent.left)
			val rightList = splitByConjunction(sent.right)
			
			return joinLists(leftList, rightList)
			
		}else{
			// because of CNF, hitting a non-Conjunction means there are no further
			// conjunctions down this path.
			return List.of(sent) // return itself
		}
		
	}
	
	/**
	 * From a CNF sentence, gets an ordered list of terminals.
	 * List will contain duplicates if a variable/booleanLiteral appears more than once.
	 * @returns The list of terminal names and a boolean each, indicating whether negated (false=negated)
	 */
	def private List<Pair<String, Boolean>> getTerminals(Sentence sent){
		if (LogicLangHelper.isComplexSentence(sent)){
			val leftList = getTerminals(LogicLangHelper.getLeftSide(sent))
			val rightList = getTerminals(LogicLangHelper.getRightSide(sent))
			
			return joinLists(leftList, rightList)
			
		}else if (sent instanceof Negation){
			// because of CNF, negation is guaranteed to be attached to a terminal
			val innerTermName = getTerminals(sent.expression).get(0).key
			return List.of(Pair.of(innerTermName, false))
			
		}else if (sent instanceof BooleanVariable){
			return List.of(Pair.of(sent.name, true))
			
		}else if (sent instanceof BooleanLiteral){
			// "T" or "F"
			val boolStr = VariantTranslator.VAR_SYMBOL_BOOLS.get(sent.truth == BooleanValuesEnum.TRUE)
			// We're going with distinct T and F instead of T and ~T because the former
			// maps better to user input.
			return List.of(Pair.of(boolStr, true))
		}
	}
	
	/**
	 * Converts a sentence to CNF. I.e. makes it a bunch of conjunctions of disjunctions
	 * Note: sent must already be in NNF for this to work. 
	 * Works recursively
	 */
	def private Sentence convertSentenceToCNF(Sentence sent){
		if (LogicLangHelper.isTerminal(sent) || sent instanceof Negation){
			// nothing to do. Negation is guaranteed to be attached to terminal
			return sent
		}else if (sent instanceof Conjunction){
			// convert insides and returns
			sent.left = convertSentenceToCNF(sent.left)
			sent.right = convertSentenceToCNF(sent.right)
			return sent
			
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
				
			}else{ // disjuncts are either terminals or disjunctions themselves
				// convert insides and returns
				sent.left = convertSentenceToCNF(sent.left)
				sent.right = convertSentenceToCNF(sent.right)
				return sent
			}
			
		}else{ // shouldn't happen if sent is NNF
			throw new IllegalArgumentException("Sentence not in NNF: " + sent);
		}
	}
	
	/**
	 * Converts a sentence to Negation Normal Form. I.e. only &'s, |'s, and ~'s (on terminals). 
	 * Requirement for CNF conversion.
	 */
	def private Sentence convertSentenceToNNF(Sentence sent){
		if (sent instanceof Negation){
			val expr = sent.expression
			// 4 cases:
			if (LogicLangHelper.isTerminal(expr)){ // ~P
				return sent // nothing to change
				
			}else if (expr instanceof Negation){ // ~(~P)
				// return inner P only
				return convertSentenceToNNF(expr.expression) 
				
			}else if (expr instanceof Conjunction){ // ~(P & Q)
				// return (~P | ~Q) - de Morgan's Law
				return convertSentenceToNNF(newDisjunction(
					newNegation(expr.left), 
					newNegation(expr.right)
				))
				
			}else if (expr instanceof Disjunction){ // ~(P | Q)
				// return (~P & ~Q) - de Morgan's Law
				return convertSentenceToNNF(newConjunction(
					newNegation(expr.left), 
					newNegation(expr.right)
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
	
	// Creates a new list containing the elements of the two arguments, in order.
	def private static <E> List<E> joinLists(List<E> listLeft, List<E> listRight){
		val list = new LinkedList<E>(listLeft);
		list.addAll(listRight)
		return list
	}
	
}
