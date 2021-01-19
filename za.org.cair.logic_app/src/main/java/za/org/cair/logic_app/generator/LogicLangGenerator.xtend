package za.org.cair.logic_app.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import za.org.cair.logic_app.logicLang.Command
import za.org.cair.logic_app.logicLang.JustParseCommand
import za.org.cair.logic_app.logicLang.VariantTranslationCommand
import za.org.cair.logic_app.logicLang.ConversionCommand
import za.org.cair.logic_app.logicLang.ConversionDestination

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class LogicLangGenerator extends AbstractGenerator { 

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		// run through all specified commands and do things for each
		resource.allContents.filter(Command).forEach [ cmd |
			if (cmd instanceof JustParseCommand){
				// do nothing
			}else if (cmd instanceof VariantTranslationCommand){
				val transText = new VariantTranslator(cmd).translate(resource)
				fsa.generateFile("translation.logic", transText)
				
			}else if (cmd instanceof ConversionCommand){
				// switch statement in xtend is for expressions, not statements
				val dest = (cmd as ConversionCommand).destination
				if (dest == ConversionDestination.CNF) {
					val converted = CNFConverter.convertToCNF(resource)
					fsa.generateFile("converted.txt", converted)
					
				}else if (dest == ConversionDestination.DIMACS_CNF) {
					// todo
				}else{
					System.err.println("Error in compilation: unsupported conversion destination")
				}
				
			}else{
				// Unknown commands should be rejected by the grammar
				// or picked up during validation. Just in case though:
				System.err.println("Error in compilation: unsupported command")
			}
		]
		
	}
}
