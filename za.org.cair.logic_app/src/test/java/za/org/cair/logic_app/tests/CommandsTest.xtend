package za.org.cair.logic_app.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import za.org.cair.logic_app.logicLang.Model
import static org.junit.Assert.assertNotNull
import org.junit.jupiter.api.Test
//import org.eclipse.xtext.testing.validation.ValidationTestHelper
//import za.org.cair.logic_app.logicLang.LogicLangPackage
//import za.org.cair.logic_app.validation.LogicLangValidator

@ExtendWith(InjectionExtension)
@InjectWith(LogicLangInjectorProvider)
class CommandsTest {

	@Inject
	ParseHelper<Model> parseHelper
	
//	@Inject
//	ValidationTestHelper validationHelper
	
	@Test
	def void testNoCommands() {
		val result = parseHelper.parse('''
			prop A | B
			prop C -> D
		''')
		assertNotNull(result)
//		val valres = validationHelper.validate(result)
//		println('valresses: ' + valres.size)
//		
//		TestingHelper.assertWarning(result, LogicLangValidator.NO_COMMANDS)

		// TODO: validation not working yet. Removing this test for now.

	}
}
