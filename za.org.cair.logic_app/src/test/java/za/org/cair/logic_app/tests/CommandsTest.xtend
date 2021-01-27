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
			cmd just parse
		'''
		
		TestingHelper.assertIssue(src, LogicLangValidator.NO_COMMANDS);

	}
}
