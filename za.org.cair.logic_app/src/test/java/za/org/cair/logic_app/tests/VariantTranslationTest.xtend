package za.org.cair.logic_app.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import javax.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import za.org.cair.logic_app.logicLang.Model
import static org.junit.Assert.assertNotNull
import org.junit.jupiter.api.Test
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import za.org.cair.logic_app.logicLang.LogicLangPackage
import za.org.cair.logic_app.validation.LogicLangValidator
import org.eclipse.xtext.xbase.testing.CompilationTestHelper

@ExtendWith(InjectionExtension)
@InjectWith(LogicLangInjectorProvider)
class VariantTranslationTest {
	
	@Inject extension CompilationTestHelper
	
	@Test
	def testResWordVar(){
		'''
		prop (A & B) -> (C | D)
		prop ~(A <-> B)
		cmd translate to reserved word variant 
		'''.assertCompilesTo('''
		prop
		prop
		''')
		
		
	}
	
	
}
