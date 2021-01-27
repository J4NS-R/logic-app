package za.org.cair.logic_app.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.^extension.ExtendWith
import za.org.cair.logic_app.validation.LogicLangValidator

@ExtendWith(InjectionExtension)
@InjectWith(LogicLangInjectorProvider)
class CommandsTest {
	
	@Test
	def void testNoCommands() {
		
		val src = '''
			prop A | B
			prop C -> D
		'''
		
		TestingHelper.assertIssue(src, LogicLangValidator.ISSUE_NO_COMMANDS);

	}
	
	@Test
	def void satNoSolver(){
		TestingHelper.assertIssue('''
			prop Ayy | Bee
			cmd solve satisfiability
		''',
			LogicLangValidator.ISSUE_NO_SOLVER
		)
	}
	
	@Test
	def void satBool(){
		TestingHelper.assertIssue('''
			prop var1 & True
			cmd solve satisfiability
			config solver='sat4j'
		''',
			LogicLangValidator.ISSUE_SAT_BOOL
		)
	}
	
}
