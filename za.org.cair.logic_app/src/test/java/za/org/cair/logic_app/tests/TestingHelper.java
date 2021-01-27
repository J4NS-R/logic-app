package za.org.cair.logic_app.tests;

import za.org.cair.logic_app.generator.Main;
import za.org.cair.logic_app.logicLang.Model;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.validation.Issue;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * Helper class for testing logic lang.
 */
class TestingHelper {
	
	// I know the default xtext libs have a similar assertion, but
	// this is much simpler and also it works, which is bizarrely more
	// than can be said for the xtext analog. 
	public static void assertIssue(String source, String code) throws IOException{
		List<Issue> issues = Main.justValidate(source);
		boolean warningFound = false;
		for (Issue issue : issues) {
			if (issue.getCode().equals(code)) {
				warningFound = true;
				break;
			}
		}
		
		assertTrue(warningFound, "Did not observe expected issue: "+code);
	}
	
}
