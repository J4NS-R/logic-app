package za.org.cair.logic_app.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

import za.org.cair.logic_app.LogicLangHelper;
import za.org.cair.logic_app.LogicLangStandaloneSetup;

public class Main {

	/**
	 * Do compilation
	 * @param args First arg is the input file. Further args are output files (one per cmd).
	 *        For each cmd for which no output file is specified, output goes to STDOUT.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Aborting: no input file specified!");
			System.exit(1);
		}
		Injector injector = new LogicLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		main.runGenerator(args);
	}

	@Inject
	private Provider<ResourceSet> resourceSetProvider;

	@Inject
	private IResourceValidator validator;

	@Inject
	private GeneratorDelegate generator;
	
	@Inject
	private JavaIoFileSystemAccess fileAccess;
	
	@Inject

	private InMemoryFileSystemAccess inMemFS;

	protected void runGenerator(String[] args) {
		// Load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createFileURI(args[0]), true);

		// Validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			System.exit(1);
		}

		// Configure and start the generator
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		generator.generate(resource, inMemFS, context);

		int outputFileIndex = 1;
		fileAccess.setOutputPath("./");
			
		Iterator<Entry<String, CharSequence>> iterator = inMemFS.getTextFiles().entrySet().iterator();
		while(iterator.hasNext()) {
			
			CharSequence generatedText = iterator.next().getValue();
			
			if (outputFileIndex < args.length) { // write to file
				fileAccess.generateFile(args[outputFileIndex], generatedText);
				outputFileIndex++;
				
			} else { // stdout
				System.out.println(generatedText);
				if (iterator.hasNext()) {
					// file separator
					System.out.println("======");
				}
			}
			
		}
	}
	
	/**
	 * These methods are used to run validation on some source code.
	 * They are needed, because for some bizarre reason validation doesn't
	 * work in JUnit 5 test context. 
	 * @param src source code
	 * @return A set of warnings and errors produced by the validator. 
	 * @throws IOException If there was an error creating or deleting temporary files.
	 */
	public static List<Issue> justValidate(String src) throws IOException{
		Injector injector = new LogicLangStandaloneSetup().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
		return main.internalJustValidate(src);
	}
	
	private List<Issue> internalJustValidate(String src) throws IOException{
		String tmpFile = LogicLangHelper.randomHash(src.hashCode())+".logic";
		BufferedWriter writer = new BufferedWriter(new FileWriter(tmpFile));
		writer.write(src);
		writer.close();
		
		Resource resource = resourceSetProvider.get().getResource(URI.createFileURI(tmpFile), true);
		List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		new File(tmpFile).delete();
		return issues;
	}
}
