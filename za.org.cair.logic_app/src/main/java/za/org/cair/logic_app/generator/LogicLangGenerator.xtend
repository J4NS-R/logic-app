package za.org.cair.logic_app.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import za.org.cair.logic_app.logicLang.Command
import za.org.cair.logic_app.logicLang.JustParseCommand
import za.org.cair.logic_app.logicLang.VariantTranslationCommand
import za.org.cair.logic_app.logicLang.ConversionCommand
import za.org.cair.logic_app.logicLang.ConversionDestination
import za.org.cair.logic_app.logicLang.SolveCommand
import za.org.cair.logic_app.logicLang.SolutionRequest
import za.org.cair.logic_app.external.SATSolver
import za.org.cair.logic_app.logicLang.ConfigKey
import za.org.cair.logic_app.logicLang.Config
import za.org.cair.logic_app.logicLang.Model

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class LogicLangGenerator extends AbstractGenerator { 

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		// run through all specified commands and do things for each
		// each cmd will output a unique file to help with multi-command runs.
		resource.allContents.filter(Command).forEach [ cmd |
			if (cmd instanceof JustParseCommand){
				// do nothing
			}else if (cmd instanceof VariantTranslationCommand){
				val transText = new VariantTranslator(cmd).translate(resource)
				fsa.generateFile("translation.logic", transText)
				
			}else if (cmd instanceof ConversionCommand){
				// switch statement in xtend is for expressions, not statements
				val dest = cmd.destination
				if (dest == ConversionDestination.CNF) {
					val converted = new CNFConverter().convertToCNF(resource)
					fsa.generateFile("convertedf-cnf.logic", converted)
					
				}else if (dest == ConversionDestination.NNF){
					val converted = new CNFConverter().convertToNNF(resource)
					fsa.generateFile("converted-nnf.logic", converted)
					
				}else if (dest == ConversionDestination.DIMACS_CNF) {
					val dimacs = new CNFConverter().convertToDIMACS(resource)
					fsa.generateFile("dimacs.cnf", dimacs)
					
				}else{
					System.err.println("Error in compilation: unsupported conversion destination")
				}
				
			}else if (cmd instanceof SolveCommand){
				val what = cmd.what
				if (what == SolutionRequest.SATISFIABILITY){
					val solver = new SATSolver(getConfig(ConfigKey.SOLVER, resource))
					solver.solve(resource.allContents.filter(Model).next.propositions)
					fsa.generateFile("result.txt", solver.prettyPrint)
					
				}else{
					System.err.println("Error in compilation: unsupported solution request")
				}
				
			}else{
				// Unknown commands should be rejected by the grammar
				// or picked up during validation. Just in case though:
				System.err.println("Error in compilation: unsupported command")
			}
		]
		
	}
	
	/**
	 * Gets the a configuration from the model.
	 * Returns null if not found
	 */
	def private String getConfig(ConfigKey key, Resource res){
		val iter = res.allContents.filter(Config)
		while (iter.hasNext){
			val cfg = iter.next
			if (cfg.key == key){
				return cfg.value
			}
		}	
		
		return null
	}
}
