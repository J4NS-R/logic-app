/*
 * generated by Xtext 2.24.0
 */
package za.org.cair.logic_app;


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
public class LogicLangStandaloneSetup extends LogicLangStandaloneSetupGenerated {

	public static void doSetup() {
		new LogicLangStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}