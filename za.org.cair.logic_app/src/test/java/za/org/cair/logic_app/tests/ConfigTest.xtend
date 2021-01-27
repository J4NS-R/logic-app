package za.org.cair.logic_app.tests

import org.junit.jupiter.api.Test
import za.org.cair.logic_app.validation.LogicLangValidator

// Because of the validation workaround, xtext injections aren't necessary in pure validation tests
class ConfigTest {
	
	@Test
	def void dupes(){
		TestingHelper.assertIssue('''
			config solver="sat4j"
			config solver="sat5j"
			cmd just parse
		''',
			LogicLangValidator.ISSUE_CONFIG_DUPE
		)
	}
	
	@Test
	def void satBadSolver(){
		TestingHelper.assertIssue('''
			config solver="fictional-solver"
			cmd just parse
		''',
			LogicLangValidator.ISSUE_UNSUPPORTED_SOLVER
		)
	}
	
}
