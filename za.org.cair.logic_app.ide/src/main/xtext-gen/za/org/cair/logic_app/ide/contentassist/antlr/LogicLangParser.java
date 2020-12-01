/*
 * generated by Xtext 2.24.0
 */
package za.org.cair.logic_app.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import za.org.cair.logic_app.ide.contentassist.antlr.internal.InternalLogicLangParser;
import za.org.cair.logic_app.services.LogicLangGrammarAccess;

public class LogicLangParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(LogicLangGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, LogicLangGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
			builder.put(grammarAccess.getBooleanAccess().getAlternatives(), "rule__Boolean__Alternatives");
			builder.put(grammarAccess.getBooleanLiteralAccess().getTruthAlternatives_0(), "rule__BooleanLiteral__TruthAlternatives_0");
			builder.put(grammarAccess.getPropositionAccess().getGroup(), "rule__Proposition__Group__0");
			builder.put(grammarAccess.getEquivalenceAccess().getGroup(), "rule__Equivalence__Group__0");
			builder.put(grammarAccess.getEquivalenceAccess().getGroup_1(), "rule__Equivalence__Group_1__0");
			builder.put(grammarAccess.getImplicationAccess().getGroup(), "rule__Implication__Group__0");
			builder.put(grammarAccess.getImplicationAccess().getGroup_1(), "rule__Implication__Group_1__0");
			builder.put(grammarAccess.getDisjunctionAccess().getGroup(), "rule__Disjunction__Group__0");
			builder.put(grammarAccess.getDisjunctionAccess().getGroup_1(), "rule__Disjunction__Group_1__0");
			builder.put(grammarAccess.getConjunctionAccess().getGroup(), "rule__Conjunction__Group__0");
			builder.put(grammarAccess.getConjunctionAccess().getGroup_1(), "rule__Conjunction__Group_1__0");
			builder.put(grammarAccess.getPrimaryAccess().getGroup_1(), "rule__Primary__Group_1__0");
			builder.put(grammarAccess.getPrimaryAccess().getGroup_2(), "rule__Primary__Group_2__0");
			builder.put(grammarAccess.getModelAccess().getPropositionsAssignment(), "rule__Model__PropositionsAssignment");
			builder.put(grammarAccess.getEquivalenceAccess().getRightAssignment_1_2(), "rule__Equivalence__RightAssignment_1_2");
			builder.put(grammarAccess.getImplicationAccess().getRightAssignment_1_2(), "rule__Implication__RightAssignment_1_2");
			builder.put(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2(), "rule__Disjunction__RightAssignment_1_2");
			builder.put(grammarAccess.getConjunctionAccess().getRightAssignment_1_2(), "rule__Conjunction__RightAssignment_1_2");
			builder.put(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2(), "rule__Primary__ExpressionAssignment_1_2");
			builder.put(grammarAccess.getBooleanVariableAccess().getNameAssignment(), "rule__BooleanVariable__NameAssignment");
			builder.put(grammarAccess.getBooleanLiteralAccess().getTruthAssignment(), "rule__BooleanLiteral__TruthAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private LogicLangGrammarAccess grammarAccess;

	@Override
	protected InternalLogicLangParser createParser() {
		InternalLogicLangParser result = new InternalLogicLangParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public LogicLangGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(LogicLangGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}