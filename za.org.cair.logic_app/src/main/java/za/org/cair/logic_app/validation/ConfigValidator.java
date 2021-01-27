package za.org.cair.logic_app.validation;

import java.util.HashSet;

import org.eclipse.xtext.util.Arrays;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import za.org.cair.logic_app.logicLang.Command;
import za.org.cair.logic_app.logicLang.Config;
import za.org.cair.logic_app.logicLang.ConfigKey;
import za.org.cair.logic_app.logicLang.LogicLangPackage;
import za.org.cair.logic_app.logicLang.Model;
import za.org.cair.logic_app.logicLang.SolutionRequest;
import za.org.cair.logic_app.logicLang.SolveCommand;

public class ConfigValidator extends AbstractDeclarativeValidator {
	
	private static String[] SOLVERS = new String[] {"sat4j"};

	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
	
	@Check(CheckType.NORMAL)
	public void checkConfigUnique(Model model) {
		HashSet<ConfigKey> configs = new HashSet<>();
		for (Config cfg : model.getConfig()) {
			if (configs.contains(cfg.getKey())) { // duplicate key
				error("Duplicate config item for key: "+cfg.getKey().getName(),
						cfg, LogicLangPackage.Literals.CONFIG__KEY,
						LogicLangValidator.CONFIG_ISSUE);
			} else {
				configs.add(cfg.getKey());
			}
		}
	}
	
	@Check(CheckType.NORMAL) 
	public void checkConfig(Config cfg) {
		if (cfg.getKey() == ConfigKey.SOLVER) {
			if (!Arrays.contains(SOLVERS, cfg.getValue())) {
				error("Solver '"+cfg.getValue()+"' not supported.",
						cfg, LogicLangPackage.Literals.CONFIG__VALUE,
						LogicLangValidator.CONFIG_ISSUE);
			}
		}// more cfg checks here
	}
	
	@Check(CheckType.NORMAL)
	public void checkSolverSpecified(Model model) {
		boolean solveReq = false;
		Command commandInQuestion = null;
		for (Command cmd : model.getCommands()) {
			if (cmd instanceof SolveCommand && 
					((SolveCommand) cmd).getWhat() == SolutionRequest.SATISFIABILITY) {
				solveReq = true;
				commandInQuestion = cmd;
				break;
			}
		}
		if (solveReq) {
			boolean aptConfig = false;
			for (Config cfg : model.getConfig()) {
				if (cfg.getKey() == ConfigKey.SOLVER) {
					aptConfig = true;
					break;
				}
			}
			if (!aptConfig) {
				error("No solver specified in config.",
						commandInQuestion, LogicLangPackage.Literals.SOLVE_COMMAND__WHAT,
						LogicLangValidator.SOLVER_ISSUE);
			}
		}
	}
	
}
