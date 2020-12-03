package za.org.cair.logic_app.validation;

import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import za.org.cair.logic_app.logicLang.LogicLangPackage;
import za.org.cair.logic_app.logicLang.Model;

public class CommandValidator extends AbstractDeclarativeValidator {

	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
	
	@Check(CheckType.NORMAL) // only check at build-time
	public void checkForCommands(Model model) {
		if(model.getCommands().size() == 0) {
			warning("No commands specified. Nothing to do.", 
					LogicLangPackage.Literals.MODEL__COMMANDS, 
					LogicLangValidator.NO_COMMANDS);
		}
	}
	
}
