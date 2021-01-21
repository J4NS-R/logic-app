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
	
	@Test
	def testDIMACS(){
		// convert to DIMACS CNF
		'''
		prop ~(P & ~Q) -> R
		prop (varA <-> varB) -> (varC & varA)
		cmd convert to DIMACS CNF
		'''.assertCompilesTo('''
		c Generated from .logic input file
		c Terminals by ID:
		c 1=P
		c 2=R
		c 3=Q
		c 4=varA
		c 5=varB
		c 6=varC
		p cnf 6 6
		1 2 0
		-3 2 0
		-4 -5 6 0
		4 5 6 0
		-4 -5 4 0
		4 5 4 0
		''')
	}
}
