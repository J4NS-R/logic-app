package za.org.cair.logic_app.generator

import za.org.cair.logic_app.logicLang.VariantTranslationCommand
import org.eclipse.emf.ecore.resource.Resource
import za.org.cair.logic_app.logicLang.Proposition
import za.org.cair.logic_app.logicLang.Sentence
import za.org.cair.logic_app.logicLang.BooleanLiteral
import za.org.cair.logic_app.logicLang.BooleanValuesEnum
import za.org.cair.logic_app.logicLang.LogicLangVariant
import za.org.cair.logic_app.logicLang.BooleanVariable
import za.org.cair.logic_app.logicLang.Negation
import za.org.cair.logic_app.logicLang.Equivalence
import za.org.cair.logic_app.logicLang.Implication
import za.org.cair.logic_app.logicLang.Disjunction
import za.org.cair.logic_app.logicLang.Conjunction
import za.org.cair.logic_app.services.LogicLangGrammarAccess.PrimaryElements

class VariantTranslator {
	
	// logic operators
	enum OP {
		NOT, AND, OR, IMPLIES, IFF
	}
	// logic lang variation mapping
	// these maps are also used in validation
	public static val VAR_SYMBOL_MAPPING = #{
		OP.NOT -> '~',
		OP.AND -> '&',
		OP.OR -> '|',
		OP.IMPLIES -> '->',
		OP.IFF -> '<->'
	}
	public static val VAR_RESWORD_MAPPING = #{
		OP.NOT -> 'not ', // adding space here as NOT is a special case
		OP.AND -> 'and',
		OP.OR -> 'or',
		OP.IMPLIES -> 'implies',
		OP.IFF -> 'iff'
	}
	public static val VAR_SYMBOL_BOOLS = #{
		true -> 'T',
		false -> 'F'
	}
	public static val VAR_RESWORD_BOOLS = #{
		true -> 'True',
		false -> 'False'
	}
	
	
	VariantTranslationCommand cmd
	
	/**
	 * Init with command to be processed 
	 */
	new(VariantTranslationCommand cmd){
		this.cmd = cmd
	}
	
	/**
	 * Translate a given resource (EMF parse model) into
	 * the variant specified by the earlier-specified command.
	 */
	def String translate(Resource res){
		
		val outStr = new StringBuilder
		
		res.allContents.filter(Proposition).forEach [ prop |
			outStr.append('prop ')
				.append(expressionToString(prop.sentence))
				.append('\n')
		]
		
		return outStr.toString
	}
	
	// TODO: don't add brackets if top level sentence
	def String expressionToString(Sentence sent){
		val outStr = new StringBuilder

		if (sent instanceof za.org.cair.logic_app.logicLang.Boolean){ // terminal
			if (sent instanceof BooleanLiteral){
				outStr.append(strTruth((sent as BooleanLiteral).truth))
			} else { // variable
				outStr.append((sent as BooleanVariable).name)
			}
		}else if (sent instanceof Negation){
			outStr.append(strOp(OP.NOT)).append(expressionToString(sent.expression))
		}else if (sent instanceof Equivalence){
			outStr.append(strBracketedSentence(sent.left, OP.IFF, sent.right))
		}else if (sent instanceof Implication){
			outStr.append(strBracketedSentence(sent.left, OP.IMPLIES, sent.right))
		}else if (sent instanceof Disjunction){
			outStr.append(strBracketedSentence(sent.left, OP.OR, sent.right))
		}else if (sent instanceof Conjunction){
			outStr.append(strBracketedSentence(sent.left, OP.AND, sent.right))
		}else{
			// shouldn't happen
			System.err.println("Unknown element encountered during translation")
		}
		
		return outStr.toString
	}
	
	/**
	 * Produces something like (A & B) where the lhs and rhs elements and operation
	 * are variable
	 */
	def private String strBracketedSentence(Sentence left, OP middleOp, Sentence right){
		return '(' + expressionToString(left) +
			' ' + strOp(middleOp) + ' ' +
			expressionToString(right) + ')'
	}
	
	/**
	 * Convert OP enum to appropriate string
	 */
	def private String strOp(OP op){
		if (cmd.variant == LogicLangVariant.SYMBOL_OP){
			return VAR_SYMBOL_MAPPING.get(op)
		}else{
			return VAR_RESWORD_MAPPING.get(op)
		}
	}
	
	/**
	 * Converts a bool enum
	 * to the appropriate bool string representation
	 */
	def private String strTruth(BooleanValuesEnum bool){
		if (cmd.variant == LogicLangVariant.SYMBOL_OP){
			return VAR_SYMBOL_BOOLS.get(bool == BooleanValuesEnum.TRUE)
		}else{
			return VAR_RESWORD_BOOLS.get(bool == BooleanValuesEnum.TRUE)
		}
	}
	
}
