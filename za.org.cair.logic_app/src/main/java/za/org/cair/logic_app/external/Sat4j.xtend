package za.org.cair.logic_app.external

import java.util.List
import za.org.cair.logic_app.logicLang.Proposition
import java.util.Map
import za.org.cair.logic_app.generator.CNFConverter
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter
import java.util.HashMap
import java.io.BufferedReader
import java.io.InputStreamReader
import za.org.cair.logic_app.LogicLangHelper

class Sat4j {
	
	val SAT4J_JAR = "sat4j.jar"
	
	List<Proposition> inputProps
	
	/**
	 * Instantiates the class and does dependency checking
	 */
	new(List<Proposition> props){
		this.inputProps = props
		
		if (!new File(SAT4J_JAR).exists()){
			throw new IllegalStateException(SAT4J_JAR + " not found. Please place the jar in this program's working dir.")
		}
	}
	
	/**
	 * Solves for satisfiability.
	 * @returns bool whether satisfiable and optionally a solution
	 */
	def Pair<Boolean, Map<String, Boolean>> solve(){
		
		val dimacsFile = LogicLangHelper.randomHash(inputProps.hashCode())+".cnf";
		
		// create dimacs file
		val dimacsContent = new CNFConverter().convertToDIMACS(inputProps)
		val writer = new BufferedWriter(new FileWriter(dimacsFile))
		writer.write(dimacsContent)
		writer.close()
		
		// build termID lookup map
		val termLookup = new HashMap<String, String>();
		val iter = dimacsContent.split("\n").iterator
		iter.next; iter.next  // skip over first two comments
		var line = iter.next
		while (line.startsWith("c ")){
			val splat = line.substring(2).split("=")
			termLookup.put(splat.get(0), splat.get(1))
			line = iter.next
		}
		
		// run sat4j
		val proc = Runtime.runtime.exec("java -jar "+SAT4J_JAR+" "+dimacsFile)
		if (proc.errorStream.read != -1){
			throw new RuntimeException("Sat4j failed to solve.")
		}
		
		// read in solution
		val reader = new BufferedReader(new InputStreamReader(proc.inputStream))
		line = reader.readLine
		while (!line.startsWith("s ")){
			line = reader.readLine
		}
		val satis = line.substring(2).startsWith("SAT")
		var Map<String, Boolean> solution = null
		
		if (satis){ // satisfiable!
			// get solution
			while (!line.startsWith("v ")) line = reader.readLine // skip over comments
			
			val termIDS = line.substring(2).split(" ") // split up var-line
			solution = new HashMap<String, Boolean>()
			for (var i = 0; i < termIDS.length-1; i++){ // iterate, skipping last 0
				var termID = termIDS.get(i)
				var positivity = true
				if (termID.startsWith("-")){ // check if negated
					positivity = false
					termID = termID.substring(1)
				}
				val termName = termLookup.get(termID) // look up termName by ID (from DIMACS)
				solution.put(termName, positivity)
			}
		}
		
		// clean up
		new File(dimacsFile).delete()
		
		// finish
		return Pair.of(satis, solution)
	}
	
}