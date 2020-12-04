package za.org.cair.logic_app.tests;

import za.org.cair.logic_app.logicLang.Model;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.emf.common.util.EList;

/**
 * Helper class for testing logic lang.
 */
class TestingHelper {
	
	// I know the default xtext libs have a similar assertion, but
	// this is much simpler
	public static void assertWarning(Model model, String code){
		EList<Diagnostic> warns = model.eResource().getWarnings();
		System.out.println("warns: " + warns.size());
		boolean warningFound = false;
		for (Diagnostic warn : warns) {
			System.out.println(warn.getMessage());
			if (warn.getMessage().contains(code)) {
				warningFound = true;
				break;
			}
		}
		
		assertTrue(warningFound, "Did not observe expected warning "+code);
	}
	
}
