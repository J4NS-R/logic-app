package za.org.cair.logic_app.web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Random;

public class ExternalCompiler {
	
	private static final String COMPILER_JAR = "logic-compiler.jar";

	/**
	 * Takes source code and compiles it via an external compiler jar and returns the output
	 * as string (taken directly from the compiler's stdout).
	 * Note: requires logic-compiler.jar and all its cronies (e.g. SAT solver binaries).
	 * Do NOT call this method with bad input.
	 * @param sourceCode the source code
	 * @return the compiled text output
	 */
	static String compileToString(String sourceCode) throws Exception {
		System.out.println("source code is the following: \n" + sourceCode);
		// check for compiler
		if (!new File(COMPILER_JAR).exists())
			throw new IllegalStateException(COMPILER_JAR+" not found. Please generate/download it and place it in this program's working dir.");

		// create a random file name so that this method can run concurrently.
		String logicFile = Integer.toHexString(sourceCode.hashCode() * (new Random().nextInt()+1)) + ".logic";
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(logicFile));
		writer.write(sourceCode);
		writer.close();
		
		Process proc = Runtime.getRuntime().exec("java -jar "+COMPILER_JAR+" "+logicFile);
		
		// read from stdout (ignore stderr, because of those reflection warnings)
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		StringBuilder compiled = new StringBuilder();
		String line = reader.readLine();
		while (line != null){
			compiled.append(line).append("\n");
			line = reader.readLine();
		}
		
		// clean up
		new File(logicFile).delete();
		System.out.println("Returning String");
		return compiled.toString();
	}
	
}
