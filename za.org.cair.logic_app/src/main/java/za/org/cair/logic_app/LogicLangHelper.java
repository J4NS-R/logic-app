package za.org.cair.logic_app;

import org.eclipse.emf.mwe2.language.mwe2.impl.BooleanLiteralImplCustom;

import za.org.cair.logic_app.logicLang.BooleanLiteral;
import za.org.cair.logic_app.logicLang.BooleanVariable;
import za.org.cair.logic_app.logicLang.Conjunction;
import za.org.cair.logic_app.logicLang.Disjunction;
import za.org.cair.logic_app.logicLang.Equivalence;
import za.org.cair.logic_app.logicLang.Implication;
import za.org.cair.logic_app.logicLang.Negation;
import za.org.cair.logic_app.logicLang.Sentence;
import za.org.cair.logic_app.logicLang.impl.BooleanLiteralImpl;
import za.org.cair.logic_app.logicLang.impl.BooleanVariableImpl;
import za.org.cair.logic_app.logicLang.impl.ConjunctionImpl;
import za.org.cair.logic_app.logicLang.impl.DisjunctionImpl;
import za.org.cair.logic_app.logicLang.impl.EquivalenceImpl;
import za.org.cair.logic_app.logicLang.impl.ImplicationImpl;
import za.org.cair.logic_app.logicLang.impl.NegationImpl;

public class LogicLangHelper {

	/**
	 * Checks if the sentence is complex (i.e. has a left and right side)
	 * Note will return false for Negation and Booleans.
	 * 
	 * This implementation is necessary because declaring grammar-level interfaces with
	 * proper attributes is really complicated in xtext.
	 * @param sent The sentence
	 * @return whether complex
	 */
	public static boolean isComplexSentence(Sentence sent) {
		return sent instanceof Conjunction ||
				sent instanceof Disjunction ||
				sent instanceof Equivalence ||
				sent instanceof Implication;
	}
	
	/**
	 * Checks if sentence is an atomic unit (i.e. either a boolean literal or a variable)
	 * @param sent The sentence
	 * @return whether atomic
	 */
	public static boolean isTerminal(Sentence sent) {
		return sent instanceof BooleanLiteral ||
				sent instanceof BooleanVariable;
	}
	
	/**
	 * Check whether a sentence has an operator
	 * @param sent The sentence
	 * @return
	 */
	public static boolean hasOperator(Sentence sent) {
		return isComplexSentence(sent) ||
				sent instanceof Negation;
	}
	
	/**
	 * Provided a complex sentence, get its left side
	 * @param sent The sentence
	 * @return its lhs
	 */
	public static Sentence getLeftSide(Sentence sent) {
		if (sent instanceof Conjunction)
			return ((Conjunction) sent).getLeft();
		else if (sent instanceof Disjunction)
			return ((Disjunction) sent).getLeft();
		else if (sent instanceof Equivalence)
			return ((Equivalence) sent).getLeft();
		else if (sent instanceof Implication)
			return ((Implication) sent).getLeft();
		else
			throw new IllegalArgumentException("Attempt to get LHS of non-complex sentence");
	}
	
	/**
	 * Provided a complex sentence, get its right side
	 * @param sent The sentence
	 * @return its rhs
	 */
	public static Sentence getRightSide(Sentence sent) {
		if (sent instanceof Conjunction)
			return ((Conjunction) sent).getRight();
		else if (sent instanceof Disjunction)
			return ((Disjunction) sent).getRight();
		else if (sent instanceof Equivalence)
			return ((Equivalence) sent).getRight();
		else if (sent instanceof Implication)
			return ((Implication) sent).getRight();
		else
			throw new IllegalArgumentException("Attempt to get RHS of non-complex sentence");
	}
	
	/**
	 * Provided a complex sentence or negation, get its operator
	 * @param sent The sentence
	 * @return its literal operator
	 */
	public static String getOperator(Sentence sent) {
		if (sent instanceof Conjunction)
			return ((Conjunction) sent).getOperator();
		else if (sent instanceof Disjunction)
			return ((Disjunction) sent).getOperator();
		else if (sent instanceof Equivalence)
			return ((Equivalence) sent).getOperator();
		else if (sent instanceof Implication)
			return ((Implication) sent).getOperator();
		else if (sent instanceof Negation)
			return ((Negation) sent).getOperator();
		else
			throw new IllegalArgumentException("Attempt to get operator of non-complex sentence");
	}
	
	/**
	 * Create a copy of a Sentence. I cannot guarantee the copy will play nice with EMF.
	 * @param sent The sentence
	 * @return A copy thereof
	 */
	public static Sentence copyOf(Sentence sent) {
		if (sent instanceof BooleanLiteral) {
			BooleanLiteral copy = new BooleanLiteralImpl() {};
			copy.setTruth(((BooleanLiteral) sent).getTruth());
			return copy;
		}else if (sent instanceof BooleanVariable) {
			BooleanVariable copy = new BooleanVariableImpl() {};
			copy.setName(((BooleanVariable) sent).getName());
			return copy;
		}else if (sent instanceof Conjunction) {
			Conjunction copy = new ConjunctionImpl() {};
			Conjunction orig = (Conjunction) sent;
			copy.setLeft(copyOf(orig.getLeft()));
			copy.setRight(copyOf(orig.getRight()));
			copy.setOperator(orig.getOperator());
			return copy;
		}else if (sent instanceof Disjunction) {
			Disjunction copy = new DisjunctionImpl() {};
			Disjunction orig = (Disjunction) sent;
			copy.setLeft(copyOf(orig.getLeft()));
			copy.setRight(copyOf(orig.getRight()));
			copy.setOperator(orig.getOperator());
			return copy;
		}else if (sent instanceof Equivalence) {
			Equivalence copy = new EquivalenceImpl() {};
			Equivalence orig = (Equivalence) sent;
			copy.setLeft(copyOf(orig.getLeft()));
			copy.setRight(copyOf(orig.getRight()));
			copy.setOperator(orig.getOperator());
			return copy;
		}else if (sent instanceof Implication) {
			Implication copy = new ImplicationImpl() {};
			Implication orig = (Implication) sent;
			copy.setLeft(copyOf(orig.getLeft()));
			copy.setRight(copyOf(orig.getRight()));
			copy.setOperator(orig.getOperator());
			return copy;
		}else if (sent instanceof Negation) {
			Negation copy = new NegationImpl() {};
			Negation orig = (Negation) sent;
			copy.setExpression(copyOf(orig.getExpression()));
			copy.setOperator(orig.getOperator());
			return copy;
		}else {
			throw new IllegalArgumentException("Cannot copy sentence: "+sent);
		}
	}
	
}
