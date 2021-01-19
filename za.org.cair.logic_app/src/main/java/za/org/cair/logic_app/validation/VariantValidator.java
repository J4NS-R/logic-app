package za.org.cair.logic_app.validation;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import za.org.cair.logic_app.LogicLangHelper;
import za.org.cair.logic_app.generator.VariantTranslator;
import za.org.cair.logic_app.logicLang.BooleanLiteral;
import za.org.cair.logic_app.logicLang.Conjunction;
import za.org.cair.logic_app.logicLang.Disjunction;
import za.org.cair.logic_app.logicLang.Equivalence;
import za.org.cair.logic_app.logicLang.Implication;
import za.org.cair.logic_app.logicLang.LogicLangPackage;
import za.org.cair.logic_app.logicLang.Model;
import za.org.cair.logic_app.logicLang.Negation;
import za.org.cair.logic_app.logicLang.Proposition;
import za.org.cair.logic_app.logicLang.Sentence;

public class VariantValidator extends AbstractDeclarativeValidator{

	@Override
	public void register(EValidatorRegistrar registrar) {
		// do nothing
	}
	
	@Check(CheckType.FAST)
	public void checkConsistentVariant(Model model) {
		
		// These are atomic because I need final variables that can change
		// No parallelism here, don't worry :)
		final AtomicBoolean checkingStarted = new AtomicBoolean(false);
		final AtomicBoolean runningSymbolVariant = new AtomicBoolean();
		
		for (Proposition prop : model.getPropositions()) {
			// check the prop's outer sentence
			Sentence sent = prop.getSentence();
			checkSentenceSymbolConsistency(sent, checkingStarted, runningSymbolVariant);
			
			// iterate through the AST
			sent.eAllContents().forEachRemaining(eob -> {
				if (eob instanceof Sentence) {
					Sentence innerSent = (Sentence) eob;
					checkSentenceSymbolConsistency(innerSent, checkingStarted, runningSymbolVariant);
				}
				// else ignore and continue search
			});
		}
	}
	//TODO: Add quick fixes to automatically convert to consistent variants
	
	/**
	 * Checks and warns for symbol inconsistency.
	 * Ignores sentences that are not symbology-relevant (e.g. BooleanVariables)
	 * @param sent
	 * @param checkingStarted Whether an initial running variant has been determined. Will be overwritten if not.
	 * @param runningVariant The running variant, if already determined. Will be overwritten if not yet determined.
	 */
	private void checkSentenceSymbolConsistency(Sentence sent, AtomicBoolean checkingStarted, AtomicBoolean runningVariant) {
		if (LogicLangHelper.hasOperator(sent)) {
			// check that operator is of the symbol variant
			boolean opSymVar = isOperatorSymbolVariant(LogicLangHelper.getOperator(sent));
			// warn if necessary
			checkSymbolInconsistency(checkingStarted, runningVariant, opSymVar, sent);
			
		}else if (sent instanceof BooleanLiteral) {
			// check that boolean literal is of the symbol variant ('T'/'F')
			boolean boolSymVar = isBoolSymbolVariant(((BooleanLiteral) sent).getTruth().getLiteral());
			// warn if necessary
			checkSymbolInconsistency(checkingStarted, runningVariant, boolSymVar, sent);
		}
		// else ignore
	}
	
	/**
	 * Being loop-aware, check whether a variant is consistent with the running variant
	 * and warn if not 
	 * @param checkingStarted Whether an initial running variant has been determined. Will be overwritten if not.
	 * @param runningVariant The running variant, if already determined. Will be overwritten if not yet determined.
	 * @param thisVariant The variant found in this case
	 * @param where Where said variant has been determined
	 */
	private void checkSymbolInconsistency(AtomicBoolean checkingStarted, AtomicBoolean runningVariant, boolean thisVariant, Sentence where) {
		if (checkingStarted.get()) {
			// do check
			if (thisVariant != runningVariant.get())
				warning("Inconsistent logic symbology", where, 
						appropriateRef(where), 
						LogicLangValidator.INCONSISTENT_SYMBOLOGY);
			// either case do nothing (continue checking)
			
		}else { // this is the first ever check: set this variant to the running variant
			runningVariant.set(thisVariant);
			checkingStarted.set(true);
		}
	}
	
	// Convoluted check for literally 'T' or 'F'
	private boolean isBoolSymbolVariant(String boolLiteralStr) {
		for (String bool : VariantTranslator.VAR_SYMBOL_BOOLS.values()) {
			if (bool.equals(boolLiteralStr))
				return true;
		}
		return false;
	}
	
	// checks for <->, &, |, etc
	private boolean isOperatorSymbolVariant(String operatorStr) {
		for (String op : VariantTranslator.VAR_SYMBOL_MAPPING.values()) {
			if (op.equals(operatorStr))
				return true;
		}
		return false;
	}
	
	/**
	 * Gets apt EReference for a symbol inconsistency warning of some sentence
	 * @param sent The sentence
	 * @return An apt EReference
	 */
	private EStructuralFeature appropriateRef(Sentence sent) {
		if (sent instanceof Equivalence)
			return LogicLangPackage.Literals.EQUIVALENCE__OPERATOR;
		else if (sent instanceof Conjunction)
			return LogicLangPackage.Literals.CONJUNCTION__OPERATOR;
		else if (sent instanceof Disjunction)
			return LogicLangPackage.Literals.DISJUNCTION__OPERATOR;
		else if (sent instanceof Implication)
			return LogicLangPackage.Literals.IMPLICATION__OPERATOR;
		else if (sent instanceof Negation)
			return LogicLangPackage.Literals.NEGATION__OPERATOR;
		else if (sent instanceof BooleanLiteral)
			return LogicLangPackage.Literals.BOOLEAN_LITERAL__TRUTH;
		else
			throw new IllegalArgumentException("Attempt to get warning reference to symbol-irrelevant sentence");
	}
	
}
