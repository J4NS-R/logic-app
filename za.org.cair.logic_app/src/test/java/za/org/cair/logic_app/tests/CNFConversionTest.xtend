package za.org.cair.logic_app.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.InjectWith
import javax.inject.Inject
import org.junit.jupiter.api.Test
import org.eclipse.xtext.xbase.testing.CompilationTestHelper

@ExtendWith(InjectionExtension)
@InjectWith(LogicLangInjectorProvider)
class CNFConversionTest {
	
	@Inject extension CompilationTestHelper
	
	@Test
	def testNNF(){
		// convert a logical expression to Negation Normal Form
		'''
		prop (A & B) -> (C | D)
		prop ~(A <-> B)
		cmd convert to NNF 
		'''.assertCompilesTo('''
		prop ((~A | ~B) | (C | D))
		prop ((~A | ~B) & (A | B))
		''')
		
	}
	
	@Test
	def testCNF(){
		// convert to Conjunctive Normal Form
		'''
		prop ~(P & ~Q) -> R
		prop A & (B | (D & E))
		cmd convert to CNF
		'''.assertCompilesTo('''
		prop ((P | R) & (~Q | R))
		prop (A & ((B | D) & (B | E)))
		''')
		
	}
}
