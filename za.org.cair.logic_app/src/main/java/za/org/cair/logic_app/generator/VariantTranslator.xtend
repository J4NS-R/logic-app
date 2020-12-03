package za.org.cair.logic_app.generator

import za.org.cair.logic_app.logicLang.VariantTranslationCommand
import org.eclipse.emf.ecore.resource.Resource
import za.org.cair.logic_app.logicLang.Proposition

class VariantTranslator {
	
	// logic operators
	static final String OP_SYMBOL_NOT = '~'
	static final String OP_SYMBOL_AND = '&'
	static final String OP_SYMBOL_OR = '|'
	static final String OP_SYMBOL_IMPLIES = '->'
	static final String OP_SYMBOL_IFF = '<->'
	
	static final String OP_RESWORD_NOT = 'not'
	static final String OP_RESWORD_AND = 'and'
	static final String OP_RESWORD_OR = 'or'
	static final String OP_RESWORD_IMPLIES = 'implies'
	static final String OP_RESWORD_IFF = 'iff'
	
	
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
			// prop.sentence.expression
			outStr.append('prop').append('\n')

		]
		
		return outStr.toString
		
	}
	
}
