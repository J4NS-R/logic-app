package za.org.cair.logic_app.external

import za.org.cair.logic_app.logicLang.Proposition
import java.util.List
import java.util.Map
import za.org.cair.logic_app.generator.VariantTranslator

class SATSolver {
	
	String solver
	Boolean satisfiable = null
	Map<String, Boolean> solution = null
	
	new (String solver){
		this.solver = solver
	}
	
	/**
	 * Checks whether the set of propositions are consistent.
	 * Results available from other methods
	 */
	def solve(List<Proposition> props){
		if (solver == "sat4j"){
			val res = new Sat4j(props).solve()
			satisfiable = res.key // key and value are just the two parts of the Pair
			solution = res.value
		}else{
			throw new IllegalArgumentException("Unsupported solver: "+solver)
		}
	}
	
	/**
	 * After solving, this method returns whether the passed-in props are satisfiable.
	 * Will throw if solve() has not been called.
	 */
	def boolean isSatisfiable(){
		if (satisfiable === null)
			throw new IllegalStateException("Call to access solution before solving complete!")
		return satisfiable
	}
	
	/**
	 * After solving, this method returns a solution to the passed-in props.
	 * Will be null if they are unsatisfiable.
	 * Will throw if solve() has not been called.
	 */
	def Map<String, Boolean> getSolution(){
		if (satisfiable === null)
			throw new IllegalStateException("Call to access solution before solving complete!")
		return solution
	}
	
	/**
	 * Gives the result printed for human consumption
	 */
	def String prettyPrint(){
		val outStr = new StringBuilder()
		if (isSatisfiable()){
			outStr.append("Satisfiable\n")
			getSolution.entrySet.forEach[entry |
				outStr.append(String.format("%s=%s\n", entry.key, 
					VariantTranslator.VAR_RESWORD_BOOLS.get(entry.value) // "True" or "False"
				))
			]
		}else
			outStr.append("Unsatisfiable\n")
			
		return outStr.toString()
	}
	
}