package za.org.cair.logic_app.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import javax.inject.Inject
import org.junit.jupiter.api.Test
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.testing.util.ParseHelper
import za.org.cair.logic_app.logicLang.Model
import org.eclipse.xtext.testing.validation.ValidationTestHelper

@ExtendWith(InjectionExtension)
@InjectWith(LogicLangInjectorProvider)
class VariantTranslationTest {
	
	@Inject extension CompilationTestHelper
	@Inject ParseHelper<Model> parseHelper
	@Inject ValidationTestHelper validationHelper
	
	@Test
	def testResWordVar(){
		// convert symbol variant to reserved word variant
		'''
		prop (A & B) -> (C | D)
		prop ~(A <-> B)
		cmd translate to reserved word variant 
		'''.assertCompilesTo('''
		prop ((A and B) implies (C or D))
		prop not (A iff B)
		''')
		
	}
	
	@Test
	def testSymbolVar(){
		// convert reserved word variant to symbol variant
		'''
		prop (A) iff not (B or C)
		prop (A implies B) and C
		cmd translate to symbol variant
		'''.assertCompilesTo('''
		prop (A <-> ~(B | C))
		prop ((A -> B) & C)
		''')
	}
	
	@Test
	def void testSymbolConsistency() {
//		val res = parseHelper.parse('''
//		prop A -> B
//		prop B and C
//		cmd just parse
//		''')
//		val iss = validationHelper.validate(res)
//		println(iss)
	}
}
