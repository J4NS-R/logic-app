package za.org.cair.logic_app.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import za.org.cair.logic_app.services.LogicLangGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalLogicLangParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'T'", "'F'", "'prop'", "'<->'", "'->'", "'|'", "'&'", "'~'", "'('", "')'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;

    // delegates
    // delegators


        public InternalLogicLangParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalLogicLangParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalLogicLangParser.tokenNames; }
    public String getGrammarFileName() { return "InternalLogicLang.g"; }


    	private LogicLangGrammarAccess grammarAccess;

    	public void setGrammarAccess(LogicLangGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalLogicLang.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalLogicLang.g:54:1: ( ruleModel EOF )
            // InternalLogicLang.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalLogicLang.g:62:1: ruleModel : ( ( rule__Model__PropositionsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:66:2: ( ( ( rule__Model__PropositionsAssignment )* ) )
            // InternalLogicLang.g:67:2: ( ( rule__Model__PropositionsAssignment )* )
            {
            // InternalLogicLang.g:67:2: ( ( rule__Model__PropositionsAssignment )* )
            // InternalLogicLang.g:68:3: ( rule__Model__PropositionsAssignment )*
            {
             before(grammarAccess.getModelAccess().getPropositionsAssignment()); 
            // InternalLogicLang.g:69:3: ( rule__Model__PropositionsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalLogicLang.g:69:4: rule__Model__PropositionsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__Model__PropositionsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getPropositionsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleProposition"
    // InternalLogicLang.g:78:1: entryRuleProposition : ruleProposition EOF ;
    public final void entryRuleProposition() throws RecognitionException {
        try {
            // InternalLogicLang.g:79:1: ( ruleProposition EOF )
            // InternalLogicLang.g:80:1: ruleProposition EOF
            {
             before(grammarAccess.getPropositionRule()); 
            pushFollow(FOLLOW_1);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getPropositionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleProposition"


    // $ANTLR start "ruleProposition"
    // InternalLogicLang.g:87:1: ruleProposition : ( ( rule__Proposition__Group__0 ) ) ;
    public final void ruleProposition() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:91:2: ( ( ( rule__Proposition__Group__0 ) ) )
            // InternalLogicLang.g:92:2: ( ( rule__Proposition__Group__0 ) )
            {
            // InternalLogicLang.g:92:2: ( ( rule__Proposition__Group__0 ) )
            // InternalLogicLang.g:93:3: ( rule__Proposition__Group__0 )
            {
             before(grammarAccess.getPropositionAccess().getGroup()); 
            // InternalLogicLang.g:94:3: ( rule__Proposition__Group__0 )
            // InternalLogicLang.g:94:4: rule__Proposition__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPropositionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProposition"


    // $ANTLR start "entryRuleSentence"
    // InternalLogicLang.g:103:1: entryRuleSentence : ruleSentence EOF ;
    public final void entryRuleSentence() throws RecognitionException {
        try {
            // InternalLogicLang.g:104:1: ( ruleSentence EOF )
            // InternalLogicLang.g:105:1: ruleSentence EOF
            {
             before(grammarAccess.getSentenceRule()); 
            pushFollow(FOLLOW_1);
            ruleSentence();

            state._fsp--;

             after(grammarAccess.getSentenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSentence"


    // $ANTLR start "ruleSentence"
    // InternalLogicLang.g:112:1: ruleSentence : ( ruleEquivalence ) ;
    public final void ruleSentence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:116:2: ( ( ruleEquivalence ) )
            // InternalLogicLang.g:117:2: ( ruleEquivalence )
            {
            // InternalLogicLang.g:117:2: ( ruleEquivalence )
            // InternalLogicLang.g:118:3: ruleEquivalence
            {
             before(grammarAccess.getSentenceAccess().getEquivalenceParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleEquivalence();

            state._fsp--;

             after(grammarAccess.getSentenceAccess().getEquivalenceParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSentence"


    // $ANTLR start "entryRuleEquivalence"
    // InternalLogicLang.g:128:1: entryRuleEquivalence : ruleEquivalence EOF ;
    public final void entryRuleEquivalence() throws RecognitionException {
        try {
            // InternalLogicLang.g:129:1: ( ruleEquivalence EOF )
            // InternalLogicLang.g:130:1: ruleEquivalence EOF
            {
             before(grammarAccess.getEquivalenceRule()); 
            pushFollow(FOLLOW_1);
            ruleEquivalence();

            state._fsp--;

             after(grammarAccess.getEquivalenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEquivalence"


    // $ANTLR start "ruleEquivalence"
    // InternalLogicLang.g:137:1: ruleEquivalence : ( ( rule__Equivalence__Group__0 ) ) ;
    public final void ruleEquivalence() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:141:2: ( ( ( rule__Equivalence__Group__0 ) ) )
            // InternalLogicLang.g:142:2: ( ( rule__Equivalence__Group__0 ) )
            {
            // InternalLogicLang.g:142:2: ( ( rule__Equivalence__Group__0 ) )
            // InternalLogicLang.g:143:3: ( rule__Equivalence__Group__0 )
            {
             before(grammarAccess.getEquivalenceAccess().getGroup()); 
            // InternalLogicLang.g:144:3: ( rule__Equivalence__Group__0 )
            // InternalLogicLang.g:144:4: rule__Equivalence__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Equivalence__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEquivalenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEquivalence"


    // $ANTLR start "entryRuleImplication"
    // InternalLogicLang.g:153:1: entryRuleImplication : ruleImplication EOF ;
    public final void entryRuleImplication() throws RecognitionException {
        try {
            // InternalLogicLang.g:154:1: ( ruleImplication EOF )
            // InternalLogicLang.g:155:1: ruleImplication EOF
            {
             before(grammarAccess.getImplicationRule()); 
            pushFollow(FOLLOW_1);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getImplicationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImplication"


    // $ANTLR start "ruleImplication"
    // InternalLogicLang.g:162:1: ruleImplication : ( ( rule__Implication__Group__0 ) ) ;
    public final void ruleImplication() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:166:2: ( ( ( rule__Implication__Group__0 ) ) )
            // InternalLogicLang.g:167:2: ( ( rule__Implication__Group__0 ) )
            {
            // InternalLogicLang.g:167:2: ( ( rule__Implication__Group__0 ) )
            // InternalLogicLang.g:168:3: ( rule__Implication__Group__0 )
            {
             before(grammarAccess.getImplicationAccess().getGroup()); 
            // InternalLogicLang.g:169:3: ( rule__Implication__Group__0 )
            // InternalLogicLang.g:169:4: rule__Implication__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Implication__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImplication"


    // $ANTLR start "entryRuleDisjunction"
    // InternalLogicLang.g:178:1: entryRuleDisjunction : ruleDisjunction EOF ;
    public final void entryRuleDisjunction() throws RecognitionException {
        try {
            // InternalLogicLang.g:179:1: ( ruleDisjunction EOF )
            // InternalLogicLang.g:180:1: ruleDisjunction EOF
            {
             before(grammarAccess.getDisjunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDisjunction"


    // $ANTLR start "ruleDisjunction"
    // InternalLogicLang.g:187:1: ruleDisjunction : ( ( rule__Disjunction__Group__0 ) ) ;
    public final void ruleDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:191:2: ( ( ( rule__Disjunction__Group__0 ) ) )
            // InternalLogicLang.g:192:2: ( ( rule__Disjunction__Group__0 ) )
            {
            // InternalLogicLang.g:192:2: ( ( rule__Disjunction__Group__0 ) )
            // InternalLogicLang.g:193:3: ( rule__Disjunction__Group__0 )
            {
             before(grammarAccess.getDisjunctionAccess().getGroup()); 
            // InternalLogicLang.g:194:3: ( rule__Disjunction__Group__0 )
            // InternalLogicLang.g:194:4: rule__Disjunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDisjunction"


    // $ANTLR start "entryRuleConjunction"
    // InternalLogicLang.g:203:1: entryRuleConjunction : ruleConjunction EOF ;
    public final void entryRuleConjunction() throws RecognitionException {
        try {
            // InternalLogicLang.g:204:1: ( ruleConjunction EOF )
            // InternalLogicLang.g:205:1: ruleConjunction EOF
            {
             before(grammarAccess.getConjunctionRule()); 
            pushFollow(FOLLOW_1);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getConjunctionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConjunction"


    // $ANTLR start "ruleConjunction"
    // InternalLogicLang.g:212:1: ruleConjunction : ( ( rule__Conjunction__Group__0 ) ) ;
    public final void ruleConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:216:2: ( ( ( rule__Conjunction__Group__0 ) ) )
            // InternalLogicLang.g:217:2: ( ( rule__Conjunction__Group__0 ) )
            {
            // InternalLogicLang.g:217:2: ( ( rule__Conjunction__Group__0 ) )
            // InternalLogicLang.g:218:3: ( rule__Conjunction__Group__0 )
            {
             before(grammarAccess.getConjunctionAccess().getGroup()); 
            // InternalLogicLang.g:219:3: ( rule__Conjunction__Group__0 )
            // InternalLogicLang.g:219:4: rule__Conjunction__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Conjunction__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConjunction"


    // $ANTLR start "entryRulePrimary"
    // InternalLogicLang.g:228:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalLogicLang.g:229:1: ( rulePrimary EOF )
            // InternalLogicLang.g:230:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalLogicLang.g:237:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:241:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalLogicLang.g:242:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalLogicLang.g:242:2: ( ( rule__Primary__Alternatives ) )
            // InternalLogicLang.g:243:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalLogicLang.g:244:3: ( rule__Primary__Alternatives )
            // InternalLogicLang.g:244:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleBoolean"
    // InternalLogicLang.g:253:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalLogicLang.g:254:1: ( ruleBoolean EOF )
            // InternalLogicLang.g:255:1: ruleBoolean EOF
            {
             before(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalLogicLang.g:262:1: ruleBoolean : ( ( rule__Boolean__Alternatives ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:266:2: ( ( ( rule__Boolean__Alternatives ) ) )
            // InternalLogicLang.g:267:2: ( ( rule__Boolean__Alternatives ) )
            {
            // InternalLogicLang.g:267:2: ( ( rule__Boolean__Alternatives ) )
            // InternalLogicLang.g:268:3: ( rule__Boolean__Alternatives )
            {
             before(grammarAccess.getBooleanAccess().getAlternatives()); 
            // InternalLogicLang.g:269:3: ( rule__Boolean__Alternatives )
            // InternalLogicLang.g:269:4: rule__Boolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleBooleanVariable"
    // InternalLogicLang.g:278:1: entryRuleBooleanVariable : ruleBooleanVariable EOF ;
    public final void entryRuleBooleanVariable() throws RecognitionException {
        try {
            // InternalLogicLang.g:279:1: ( ruleBooleanVariable EOF )
            // InternalLogicLang.g:280:1: ruleBooleanVariable EOF
            {
             before(grammarAccess.getBooleanVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanVariable();

            state._fsp--;

             after(grammarAccess.getBooleanVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanVariable"


    // $ANTLR start "ruleBooleanVariable"
    // InternalLogicLang.g:287:1: ruleBooleanVariable : ( ( rule__BooleanVariable__NameAssignment ) ) ;
    public final void ruleBooleanVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:291:2: ( ( ( rule__BooleanVariable__NameAssignment ) ) )
            // InternalLogicLang.g:292:2: ( ( rule__BooleanVariable__NameAssignment ) )
            {
            // InternalLogicLang.g:292:2: ( ( rule__BooleanVariable__NameAssignment ) )
            // InternalLogicLang.g:293:3: ( rule__BooleanVariable__NameAssignment )
            {
             before(grammarAccess.getBooleanVariableAccess().getNameAssignment()); 
            // InternalLogicLang.g:294:3: ( rule__BooleanVariable__NameAssignment )
            // InternalLogicLang.g:294:4: rule__BooleanVariable__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BooleanVariable__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanVariableAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanVariable"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalLogicLang.g:303:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // InternalLogicLang.g:304:1: ( ruleBooleanLiteral EOF )
            // InternalLogicLang.g:305:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanLiteral();

            state._fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalLogicLang.g:312:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__TruthAssignment ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:316:2: ( ( ( rule__BooleanLiteral__TruthAssignment ) ) )
            // InternalLogicLang.g:317:2: ( ( rule__BooleanLiteral__TruthAssignment ) )
            {
            // InternalLogicLang.g:317:2: ( ( rule__BooleanLiteral__TruthAssignment ) )
            // InternalLogicLang.g:318:3: ( rule__BooleanLiteral__TruthAssignment )
            {
             before(grammarAccess.getBooleanLiteralAccess().getTruthAssignment()); 
            // InternalLogicLang.g:319:3: ( rule__BooleanLiteral__TruthAssignment )
            // InternalLogicLang.g:319:4: rule__BooleanLiteral__TruthAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__TruthAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getTruthAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalLogicLang.g:327:1: rule__Primary__Alternatives : ( ( ruleBoolean ) | ( ( rule__Primary__Group_1__0 ) ) | ( ( rule__Primary__Group_2__0 ) ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:331:1: ( ( ruleBoolean ) | ( ( rule__Primary__Group_1__0 ) ) | ( ( rule__Primary__Group_2__0 ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 11:
            case 12:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 19:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalLogicLang.g:332:2: ( ruleBoolean )
                    {
                    // InternalLogicLang.g:332:2: ( ruleBoolean )
                    // InternalLogicLang.g:333:3: ruleBoolean
                    {
                     before(grammarAccess.getPrimaryAccess().getBooleanParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolean();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getBooleanParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLogicLang.g:338:2: ( ( rule__Primary__Group_1__0 ) )
                    {
                    // InternalLogicLang.g:338:2: ( ( rule__Primary__Group_1__0 ) )
                    // InternalLogicLang.g:339:3: ( rule__Primary__Group_1__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_1()); 
                    // InternalLogicLang.g:340:3: ( rule__Primary__Group_1__0 )
                    // InternalLogicLang.g:340:4: rule__Primary__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalLogicLang.g:344:2: ( ( rule__Primary__Group_2__0 ) )
                    {
                    // InternalLogicLang.g:344:2: ( ( rule__Primary__Group_2__0 ) )
                    // InternalLogicLang.g:345:3: ( rule__Primary__Group_2__0 )
                    {
                     before(grammarAccess.getPrimaryAccess().getGroup_2()); 
                    // InternalLogicLang.g:346:3: ( rule__Primary__Group_2__0 )
                    // InternalLogicLang.g:346:4: rule__Primary__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Primary__Group_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getPrimaryAccess().getGroup_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__Boolean__Alternatives"
    // InternalLogicLang.g:354:1: rule__Boolean__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleBooleanVariable ) );
    public final void rule__Boolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:358:1: ( ( ruleBooleanLiteral ) | ( ruleBooleanVariable ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=11 && LA3_0<=12)) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalLogicLang.g:359:2: ( ruleBooleanLiteral )
                    {
                    // InternalLogicLang.g:359:2: ( ruleBooleanLiteral )
                    // InternalLogicLang.g:360:3: ruleBooleanLiteral
                    {
                     before(grammarAccess.getBooleanAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanLiteral();

                    state._fsp--;

                     after(grammarAccess.getBooleanAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLogicLang.g:365:2: ( ruleBooleanVariable )
                    {
                    // InternalLogicLang.g:365:2: ( ruleBooleanVariable )
                    // InternalLogicLang.g:366:3: ruleBooleanVariable
                    {
                     before(grammarAccess.getBooleanAccess().getBooleanVariableParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanVariable();

                    state._fsp--;

                     after(grammarAccess.getBooleanAccess().getBooleanVariableParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Alternatives"


    // $ANTLR start "rule__BooleanLiteral__TruthAlternatives_0"
    // InternalLogicLang.g:375:1: rule__BooleanLiteral__TruthAlternatives_0 : ( ( 'T' ) | ( 'F' ) );
    public final void rule__BooleanLiteral__TruthAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:379:1: ( ( 'T' ) | ( 'F' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalLogicLang.g:380:2: ( 'T' )
                    {
                    // InternalLogicLang.g:380:2: ( 'T' )
                    // InternalLogicLang.g:381:3: 'T'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getTruthTKeyword_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralAccess().getTruthTKeyword_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalLogicLang.g:386:2: ( 'F' )
                    {
                    // InternalLogicLang.g:386:2: ( 'F' )
                    // InternalLogicLang.g:387:3: 'F'
                    {
                     before(grammarAccess.getBooleanLiteralAccess().getTruthFKeyword_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getBooleanLiteralAccess().getTruthFKeyword_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__TruthAlternatives_0"


    // $ANTLR start "rule__Proposition__Group__0"
    // InternalLogicLang.g:396:1: rule__Proposition__Group__0 : rule__Proposition__Group__0__Impl rule__Proposition__Group__1 ;
    public final void rule__Proposition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:400:1: ( rule__Proposition__Group__0__Impl rule__Proposition__Group__1 )
            // InternalLogicLang.g:401:2: rule__Proposition__Group__0__Impl rule__Proposition__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Proposition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Proposition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0"


    // $ANTLR start "rule__Proposition__Group__0__Impl"
    // InternalLogicLang.g:408:1: rule__Proposition__Group__0__Impl : ( 'prop' ) ;
    public final void rule__Proposition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:412:1: ( ( 'prop' ) )
            // InternalLogicLang.g:413:1: ( 'prop' )
            {
            // InternalLogicLang.g:413:1: ( 'prop' )
            // InternalLogicLang.g:414:2: 'prop'
            {
             before(grammarAccess.getPropositionAccess().getPropKeyword_0()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getPropositionAccess().getPropKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__0__Impl"


    // $ANTLR start "rule__Proposition__Group__1"
    // InternalLogicLang.g:423:1: rule__Proposition__Group__1 : rule__Proposition__Group__1__Impl ;
    public final void rule__Proposition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:427:1: ( rule__Proposition__Group__1__Impl )
            // InternalLogicLang.g:428:2: rule__Proposition__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Proposition__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1"


    // $ANTLR start "rule__Proposition__Group__1__Impl"
    // InternalLogicLang.g:434:1: rule__Proposition__Group__1__Impl : ( ruleSentence ) ;
    public final void rule__Proposition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:438:1: ( ( ruleSentence ) )
            // InternalLogicLang.g:439:1: ( ruleSentence )
            {
            // InternalLogicLang.g:439:1: ( ruleSentence )
            // InternalLogicLang.g:440:2: ruleSentence
            {
             before(grammarAccess.getPropositionAccess().getSentenceParserRuleCall_1()); 
            pushFollow(FOLLOW_2);
            ruleSentence();

            state._fsp--;

             after(grammarAccess.getPropositionAccess().getSentenceParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Proposition__Group__1__Impl"


    // $ANTLR start "rule__Equivalence__Group__0"
    // InternalLogicLang.g:450:1: rule__Equivalence__Group__0 : rule__Equivalence__Group__0__Impl rule__Equivalence__Group__1 ;
    public final void rule__Equivalence__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:454:1: ( rule__Equivalence__Group__0__Impl rule__Equivalence__Group__1 )
            // InternalLogicLang.g:455:2: rule__Equivalence__Group__0__Impl rule__Equivalence__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Equivalence__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equivalence__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group__0"


    // $ANTLR start "rule__Equivalence__Group__0__Impl"
    // InternalLogicLang.g:462:1: rule__Equivalence__Group__0__Impl : ( ruleImplication ) ;
    public final void rule__Equivalence__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:466:1: ( ( ruleImplication ) )
            // InternalLogicLang.g:467:1: ( ruleImplication )
            {
            // InternalLogicLang.g:467:1: ( ruleImplication )
            // InternalLogicLang.g:468:2: ruleImplication
            {
             before(grammarAccess.getEquivalenceAccess().getImplicationParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getEquivalenceAccess().getImplicationParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group__0__Impl"


    // $ANTLR start "rule__Equivalence__Group__1"
    // InternalLogicLang.g:477:1: rule__Equivalence__Group__1 : rule__Equivalence__Group__1__Impl ;
    public final void rule__Equivalence__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:481:1: ( rule__Equivalence__Group__1__Impl )
            // InternalLogicLang.g:482:2: rule__Equivalence__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equivalence__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group__1"


    // $ANTLR start "rule__Equivalence__Group__1__Impl"
    // InternalLogicLang.g:488:1: rule__Equivalence__Group__1__Impl : ( ( rule__Equivalence__Group_1__0 )* ) ;
    public final void rule__Equivalence__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:492:1: ( ( ( rule__Equivalence__Group_1__0 )* ) )
            // InternalLogicLang.g:493:1: ( ( rule__Equivalence__Group_1__0 )* )
            {
            // InternalLogicLang.g:493:1: ( ( rule__Equivalence__Group_1__0 )* )
            // InternalLogicLang.g:494:2: ( rule__Equivalence__Group_1__0 )*
            {
             before(grammarAccess.getEquivalenceAccess().getGroup_1()); 
            // InternalLogicLang.g:495:2: ( rule__Equivalence__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalLogicLang.g:495:3: rule__Equivalence__Group_1__0
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Equivalence__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getEquivalenceAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group__1__Impl"


    // $ANTLR start "rule__Equivalence__Group_1__0"
    // InternalLogicLang.g:504:1: rule__Equivalence__Group_1__0 : rule__Equivalence__Group_1__0__Impl rule__Equivalence__Group_1__1 ;
    public final void rule__Equivalence__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:508:1: ( rule__Equivalence__Group_1__0__Impl rule__Equivalence__Group_1__1 )
            // InternalLogicLang.g:509:2: rule__Equivalence__Group_1__0__Impl rule__Equivalence__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Equivalence__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equivalence__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__0"


    // $ANTLR start "rule__Equivalence__Group_1__0__Impl"
    // InternalLogicLang.g:516:1: rule__Equivalence__Group_1__0__Impl : ( () ) ;
    public final void rule__Equivalence__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:520:1: ( ( () ) )
            // InternalLogicLang.g:521:1: ( () )
            {
            // InternalLogicLang.g:521:1: ( () )
            // InternalLogicLang.g:522:2: ()
            {
             before(grammarAccess.getEquivalenceAccess().getEquivalenceLeftAction_1_0()); 
            // InternalLogicLang.g:523:2: ()
            // InternalLogicLang.g:523:3: 
            {
            }

             after(grammarAccess.getEquivalenceAccess().getEquivalenceLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__0__Impl"


    // $ANTLR start "rule__Equivalence__Group_1__1"
    // InternalLogicLang.g:531:1: rule__Equivalence__Group_1__1 : rule__Equivalence__Group_1__1__Impl rule__Equivalence__Group_1__2 ;
    public final void rule__Equivalence__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:535:1: ( rule__Equivalence__Group_1__1__Impl rule__Equivalence__Group_1__2 )
            // InternalLogicLang.g:536:2: rule__Equivalence__Group_1__1__Impl rule__Equivalence__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__Equivalence__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Equivalence__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__1"


    // $ANTLR start "rule__Equivalence__Group_1__1__Impl"
    // InternalLogicLang.g:543:1: rule__Equivalence__Group_1__1__Impl : ( '<->' ) ;
    public final void rule__Equivalence__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:547:1: ( ( '<->' ) )
            // InternalLogicLang.g:548:1: ( '<->' )
            {
            // InternalLogicLang.g:548:1: ( '<->' )
            // InternalLogicLang.g:549:2: '<->'
            {
             before(grammarAccess.getEquivalenceAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getEquivalenceAccess().getLessThanSignHyphenMinusGreaterThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__1__Impl"


    // $ANTLR start "rule__Equivalence__Group_1__2"
    // InternalLogicLang.g:558:1: rule__Equivalence__Group_1__2 : rule__Equivalence__Group_1__2__Impl ;
    public final void rule__Equivalence__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:562:1: ( rule__Equivalence__Group_1__2__Impl )
            // InternalLogicLang.g:563:2: rule__Equivalence__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Equivalence__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__2"


    // $ANTLR start "rule__Equivalence__Group_1__2__Impl"
    // InternalLogicLang.g:569:1: rule__Equivalence__Group_1__2__Impl : ( ( rule__Equivalence__RightAssignment_1_2 ) ) ;
    public final void rule__Equivalence__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:573:1: ( ( ( rule__Equivalence__RightAssignment_1_2 ) ) )
            // InternalLogicLang.g:574:1: ( ( rule__Equivalence__RightAssignment_1_2 ) )
            {
            // InternalLogicLang.g:574:1: ( ( rule__Equivalence__RightAssignment_1_2 ) )
            // InternalLogicLang.g:575:2: ( rule__Equivalence__RightAssignment_1_2 )
            {
             before(grammarAccess.getEquivalenceAccess().getRightAssignment_1_2()); 
            // InternalLogicLang.g:576:2: ( rule__Equivalence__RightAssignment_1_2 )
            // InternalLogicLang.g:576:3: rule__Equivalence__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Equivalence__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEquivalenceAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__Group_1__2__Impl"


    // $ANTLR start "rule__Implication__Group__0"
    // InternalLogicLang.g:585:1: rule__Implication__Group__0 : rule__Implication__Group__0__Impl rule__Implication__Group__1 ;
    public final void rule__Implication__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:589:1: ( rule__Implication__Group__0__Impl rule__Implication__Group__1 )
            // InternalLogicLang.g:590:2: rule__Implication__Group__0__Impl rule__Implication__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__Implication__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Implication__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0"


    // $ANTLR start "rule__Implication__Group__0__Impl"
    // InternalLogicLang.g:597:1: rule__Implication__Group__0__Impl : ( ruleDisjunction ) ;
    public final void rule__Implication__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:601:1: ( ( ruleDisjunction ) )
            // InternalLogicLang.g:602:1: ( ruleDisjunction )
            {
            // InternalLogicLang.g:602:1: ( ruleDisjunction )
            // InternalLogicLang.g:603:2: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getDisjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__0__Impl"


    // $ANTLR start "rule__Implication__Group__1"
    // InternalLogicLang.g:612:1: rule__Implication__Group__1 : rule__Implication__Group__1__Impl ;
    public final void rule__Implication__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:616:1: ( rule__Implication__Group__1__Impl )
            // InternalLogicLang.g:617:2: rule__Implication__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Implication__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1"


    // $ANTLR start "rule__Implication__Group__1__Impl"
    // InternalLogicLang.g:623:1: rule__Implication__Group__1__Impl : ( ( rule__Implication__Group_1__0 )* ) ;
    public final void rule__Implication__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:627:1: ( ( ( rule__Implication__Group_1__0 )* ) )
            // InternalLogicLang.g:628:1: ( ( rule__Implication__Group_1__0 )* )
            {
            // InternalLogicLang.g:628:1: ( ( rule__Implication__Group_1__0 )* )
            // InternalLogicLang.g:629:2: ( rule__Implication__Group_1__0 )*
            {
             before(grammarAccess.getImplicationAccess().getGroup_1()); 
            // InternalLogicLang.g:630:2: ( rule__Implication__Group_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalLogicLang.g:630:3: rule__Implication__Group_1__0
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__Implication__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getImplicationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__0"
    // InternalLogicLang.g:639:1: rule__Implication__Group_1__0 : rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 ;
    public final void rule__Implication__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:643:1: ( rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1 )
            // InternalLogicLang.g:644:2: rule__Implication__Group_1__0__Impl rule__Implication__Group_1__1
            {
            pushFollow(FOLLOW_7);
            rule__Implication__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Implication__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0"


    // $ANTLR start "rule__Implication__Group_1__0__Impl"
    // InternalLogicLang.g:651:1: rule__Implication__Group_1__0__Impl : ( () ) ;
    public final void rule__Implication__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:655:1: ( ( () ) )
            // InternalLogicLang.g:656:1: ( () )
            {
            // InternalLogicLang.g:656:1: ( () )
            // InternalLogicLang.g:657:2: ()
            {
             before(grammarAccess.getImplicationAccess().getImplicationLeftAction_1_0()); 
            // InternalLogicLang.g:658:2: ()
            // InternalLogicLang.g:658:3: 
            {
            }

             after(grammarAccess.getImplicationAccess().getImplicationLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__0__Impl"


    // $ANTLR start "rule__Implication__Group_1__1"
    // InternalLogicLang.g:666:1: rule__Implication__Group_1__1 : rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 ;
    public final void rule__Implication__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:670:1: ( rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2 )
            // InternalLogicLang.g:671:2: rule__Implication__Group_1__1__Impl rule__Implication__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__Implication__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Implication__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1"


    // $ANTLR start "rule__Implication__Group_1__1__Impl"
    // InternalLogicLang.g:678:1: rule__Implication__Group_1__1__Impl : ( '->' ) ;
    public final void rule__Implication__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:682:1: ( ( '->' ) )
            // InternalLogicLang.g:683:1: ( '->' )
            {
            // InternalLogicLang.g:683:1: ( '->' )
            // InternalLogicLang.g:684:2: '->'
            {
             before(grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getImplicationAccess().getHyphenMinusGreaterThanSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__1__Impl"


    // $ANTLR start "rule__Implication__Group_1__2"
    // InternalLogicLang.g:693:1: rule__Implication__Group_1__2 : rule__Implication__Group_1__2__Impl ;
    public final void rule__Implication__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:697:1: ( rule__Implication__Group_1__2__Impl )
            // InternalLogicLang.g:698:2: rule__Implication__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Implication__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2"


    // $ANTLR start "rule__Implication__Group_1__2__Impl"
    // InternalLogicLang.g:704:1: rule__Implication__Group_1__2__Impl : ( ( rule__Implication__RightAssignment_1_2 ) ) ;
    public final void rule__Implication__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:708:1: ( ( ( rule__Implication__RightAssignment_1_2 ) ) )
            // InternalLogicLang.g:709:1: ( ( rule__Implication__RightAssignment_1_2 ) )
            {
            // InternalLogicLang.g:709:1: ( ( rule__Implication__RightAssignment_1_2 ) )
            // InternalLogicLang.g:710:2: ( rule__Implication__RightAssignment_1_2 )
            {
             before(grammarAccess.getImplicationAccess().getRightAssignment_1_2()); 
            // InternalLogicLang.g:711:2: ( rule__Implication__RightAssignment_1_2 )
            // InternalLogicLang.g:711:3: rule__Implication__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Implication__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getImplicationAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__Group_1__2__Impl"


    // $ANTLR start "rule__Disjunction__Group__0"
    // InternalLogicLang.g:720:1: rule__Disjunction__Group__0 : rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 ;
    public final void rule__Disjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:724:1: ( rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1 )
            // InternalLogicLang.g:725:2: rule__Disjunction__Group__0__Impl rule__Disjunction__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Disjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Disjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0"


    // $ANTLR start "rule__Disjunction__Group__0__Impl"
    // InternalLogicLang.g:732:1: rule__Disjunction__Group__0__Impl : ( ruleConjunction ) ;
    public final void rule__Disjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:736:1: ( ( ruleConjunction ) )
            // InternalLogicLang.g:737:1: ( ruleConjunction )
            {
            // InternalLogicLang.g:737:1: ( ruleConjunction )
            // InternalLogicLang.g:738:2: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getConjunctionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__0__Impl"


    // $ANTLR start "rule__Disjunction__Group__1"
    // InternalLogicLang.g:747:1: rule__Disjunction__Group__1 : rule__Disjunction__Group__1__Impl ;
    public final void rule__Disjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:751:1: ( rule__Disjunction__Group__1__Impl )
            // InternalLogicLang.g:752:2: rule__Disjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1"


    // $ANTLR start "rule__Disjunction__Group__1__Impl"
    // InternalLogicLang.g:758:1: rule__Disjunction__Group__1__Impl : ( ( rule__Disjunction__Group_1__0 )* ) ;
    public final void rule__Disjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:762:1: ( ( ( rule__Disjunction__Group_1__0 )* ) )
            // InternalLogicLang.g:763:1: ( ( rule__Disjunction__Group_1__0 )* )
            {
            // InternalLogicLang.g:763:1: ( ( rule__Disjunction__Group_1__0 )* )
            // InternalLogicLang.g:764:2: ( rule__Disjunction__Group_1__0 )*
            {
             before(grammarAccess.getDisjunctionAccess().getGroup_1()); 
            // InternalLogicLang.g:765:2: ( rule__Disjunction__Group_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalLogicLang.g:765:3: rule__Disjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Disjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getDisjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__0"
    // InternalLogicLang.g:774:1: rule__Disjunction__Group_1__0 : rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 ;
    public final void rule__Disjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:778:1: ( rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1 )
            // InternalLogicLang.g:779:2: rule__Disjunction__Group_1__0__Impl rule__Disjunction__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__Disjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0"


    // $ANTLR start "rule__Disjunction__Group_1__0__Impl"
    // InternalLogicLang.g:786:1: rule__Disjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Disjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:790:1: ( ( () ) )
            // InternalLogicLang.g:791:1: ( () )
            {
            // InternalLogicLang.g:791:1: ( () )
            // InternalLogicLang.g:792:2: ()
            {
             before(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 
            // InternalLogicLang.g:793:2: ()
            // InternalLogicLang.g:793:3: 
            {
            }

             after(grammarAccess.getDisjunctionAccess().getDisjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__1"
    // InternalLogicLang.g:801:1: rule__Disjunction__Group_1__1 : rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 ;
    public final void rule__Disjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:805:1: ( rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2 )
            // InternalLogicLang.g:806:2: rule__Disjunction__Group_1__1__Impl rule__Disjunction__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__Disjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1"


    // $ANTLR start "rule__Disjunction__Group_1__1__Impl"
    // InternalLogicLang.g:813:1: rule__Disjunction__Group_1__1__Impl : ( '|' ) ;
    public final void rule__Disjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:817:1: ( ( '|' ) )
            // InternalLogicLang.g:818:1: ( '|' )
            {
            // InternalLogicLang.g:818:1: ( '|' )
            // InternalLogicLang.g:819:2: '|'
            {
             before(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getDisjunctionAccess().getVerticalLineKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Disjunction__Group_1__2"
    // InternalLogicLang.g:828:1: rule__Disjunction__Group_1__2 : rule__Disjunction__Group_1__2__Impl ;
    public final void rule__Disjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:832:1: ( rule__Disjunction__Group_1__2__Impl )
            // InternalLogicLang.g:833:2: rule__Disjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2"


    // $ANTLR start "rule__Disjunction__Group_1__2__Impl"
    // InternalLogicLang.g:839:1: rule__Disjunction__Group_1__2__Impl : ( ( rule__Disjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Disjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:843:1: ( ( ( rule__Disjunction__RightAssignment_1_2 ) ) )
            // InternalLogicLang.g:844:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            {
            // InternalLogicLang.g:844:1: ( ( rule__Disjunction__RightAssignment_1_2 ) )
            // InternalLogicLang.g:845:2: ( rule__Disjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 
            // InternalLogicLang.g:846:2: ( rule__Disjunction__RightAssignment_1_2 )
            // InternalLogicLang.g:846:3: rule__Disjunction__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Disjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getDisjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Conjunction__Group__0"
    // InternalLogicLang.g:855:1: rule__Conjunction__Group__0 : rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 ;
    public final void rule__Conjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:859:1: ( rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1 )
            // InternalLogicLang.g:860:2: rule__Conjunction__Group__0__Impl rule__Conjunction__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Conjunction__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conjunction__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0"


    // $ANTLR start "rule__Conjunction__Group__0__Impl"
    // InternalLogicLang.g:867:1: rule__Conjunction__Group__0__Impl : ( rulePrimary ) ;
    public final void rule__Conjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:871:1: ( ( rulePrimary ) )
            // InternalLogicLang.g:872:1: ( rulePrimary )
            {
            // InternalLogicLang.g:872:1: ( rulePrimary )
            // InternalLogicLang.g:873:2: rulePrimary
            {
             before(grammarAccess.getConjunctionAccess().getPrimaryParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getPrimaryParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__0__Impl"


    // $ANTLR start "rule__Conjunction__Group__1"
    // InternalLogicLang.g:882:1: rule__Conjunction__Group__1 : rule__Conjunction__Group__1__Impl ;
    public final void rule__Conjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:886:1: ( rule__Conjunction__Group__1__Impl )
            // InternalLogicLang.g:887:2: rule__Conjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Conjunction__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1"


    // $ANTLR start "rule__Conjunction__Group__1__Impl"
    // InternalLogicLang.g:893:1: rule__Conjunction__Group__1__Impl : ( ( rule__Conjunction__Group_1__0 )* ) ;
    public final void rule__Conjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:897:1: ( ( ( rule__Conjunction__Group_1__0 )* ) )
            // InternalLogicLang.g:898:1: ( ( rule__Conjunction__Group_1__0 )* )
            {
            // InternalLogicLang.g:898:1: ( ( rule__Conjunction__Group_1__0 )* )
            // InternalLogicLang.g:899:2: ( rule__Conjunction__Group_1__0 )*
            {
             before(grammarAccess.getConjunctionAccess().getGroup_1()); 
            // InternalLogicLang.g:900:2: ( rule__Conjunction__Group_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalLogicLang.g:900:3: rule__Conjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Conjunction__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getConjunctionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__0"
    // InternalLogicLang.g:909:1: rule__Conjunction__Group_1__0 : rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 ;
    public final void rule__Conjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:913:1: ( rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1 )
            // InternalLogicLang.g:914:2: rule__Conjunction__Group_1__0__Impl rule__Conjunction__Group_1__1
            {
            pushFollow(FOLLOW_11);
            rule__Conjunction__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conjunction__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0"


    // $ANTLR start "rule__Conjunction__Group_1__0__Impl"
    // InternalLogicLang.g:921:1: rule__Conjunction__Group_1__0__Impl : ( () ) ;
    public final void rule__Conjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:925:1: ( ( () ) )
            // InternalLogicLang.g:926:1: ( () )
            {
            // InternalLogicLang.g:926:1: ( () )
            // InternalLogicLang.g:927:2: ()
            {
             before(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 
            // InternalLogicLang.g:928:2: ()
            // InternalLogicLang.g:928:3: 
            {
            }

             after(grammarAccess.getConjunctionAccess().getConjunctionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__0__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__1"
    // InternalLogicLang.g:936:1: rule__Conjunction__Group_1__1 : rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 ;
    public final void rule__Conjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:940:1: ( rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2 )
            // InternalLogicLang.g:941:2: rule__Conjunction__Group_1__1__Impl rule__Conjunction__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__Conjunction__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conjunction__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1"


    // $ANTLR start "rule__Conjunction__Group_1__1__Impl"
    // InternalLogicLang.g:948:1: rule__Conjunction__Group_1__1__Impl : ( '&' ) ;
    public final void rule__Conjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:952:1: ( ( '&' ) )
            // InternalLogicLang.g:953:1: ( '&' )
            {
            // InternalLogicLang.g:953:1: ( '&' )
            // InternalLogicLang.g:954:2: '&'
            {
             before(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getConjunctionAccess().getAmpersandKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__1__Impl"


    // $ANTLR start "rule__Conjunction__Group_1__2"
    // InternalLogicLang.g:963:1: rule__Conjunction__Group_1__2 : rule__Conjunction__Group_1__2__Impl ;
    public final void rule__Conjunction__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:967:1: ( rule__Conjunction__Group_1__2__Impl )
            // InternalLogicLang.g:968:2: rule__Conjunction__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Conjunction__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2"


    // $ANTLR start "rule__Conjunction__Group_1__2__Impl"
    // InternalLogicLang.g:974:1: rule__Conjunction__Group_1__2__Impl : ( ( rule__Conjunction__RightAssignment_1_2 ) ) ;
    public final void rule__Conjunction__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:978:1: ( ( ( rule__Conjunction__RightAssignment_1_2 ) ) )
            // InternalLogicLang.g:979:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            {
            // InternalLogicLang.g:979:1: ( ( rule__Conjunction__RightAssignment_1_2 ) )
            // InternalLogicLang.g:980:2: ( rule__Conjunction__RightAssignment_1_2 )
            {
             before(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 
            // InternalLogicLang.g:981:2: ( rule__Conjunction__RightAssignment_1_2 )
            // InternalLogicLang.g:981:3: rule__Conjunction__RightAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Conjunction__RightAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getConjunctionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_1__0"
    // InternalLogicLang.g:990:1: rule__Primary__Group_1__0 : rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 ;
    public final void rule__Primary__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:994:1: ( rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1 )
            // InternalLogicLang.g:995:2: rule__Primary__Group_1__0__Impl rule__Primary__Group_1__1
            {
            pushFollow(FOLLOW_13);
            rule__Primary__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0"


    // $ANTLR start "rule__Primary__Group_1__0__Impl"
    // InternalLogicLang.g:1002:1: rule__Primary__Group_1__0__Impl : ( () ) ;
    public final void rule__Primary__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1006:1: ( ( () ) )
            // InternalLogicLang.g:1007:1: ( () )
            {
            // InternalLogicLang.g:1007:1: ( () )
            // InternalLogicLang.g:1008:2: ()
            {
             before(grammarAccess.getPrimaryAccess().getNegationAction_1_0()); 
            // InternalLogicLang.g:1009:2: ()
            // InternalLogicLang.g:1009:3: 
            {
            }

             after(grammarAccess.getPrimaryAccess().getNegationAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__0__Impl"


    // $ANTLR start "rule__Primary__Group_1__1"
    // InternalLogicLang.g:1017:1: rule__Primary__Group_1__1 : rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 ;
    public final void rule__Primary__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1021:1: ( rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2 )
            // InternalLogicLang.g:1022:2: rule__Primary__Group_1__1__Impl rule__Primary__Group_1__2
            {
            pushFollow(FOLLOW_4);
            rule__Primary__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1"


    // $ANTLR start "rule__Primary__Group_1__1__Impl"
    // InternalLogicLang.g:1029:1: rule__Primary__Group_1__1__Impl : ( '~' ) ;
    public final void rule__Primary__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1033:1: ( ( '~' ) )
            // InternalLogicLang.g:1034:1: ( '~' )
            {
            // InternalLogicLang.g:1034:1: ( '~' )
            // InternalLogicLang.g:1035:2: '~'
            {
             before(grammarAccess.getPrimaryAccess().getTildeKeyword_1_1()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getTildeKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__1__Impl"


    // $ANTLR start "rule__Primary__Group_1__2"
    // InternalLogicLang.g:1044:1: rule__Primary__Group_1__2 : rule__Primary__Group_1__2__Impl ;
    public final void rule__Primary__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1048:1: ( rule__Primary__Group_1__2__Impl )
            // InternalLogicLang.g:1049:2: rule__Primary__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2"


    // $ANTLR start "rule__Primary__Group_1__2__Impl"
    // InternalLogicLang.g:1055:1: rule__Primary__Group_1__2__Impl : ( ( rule__Primary__ExpressionAssignment_1_2 ) ) ;
    public final void rule__Primary__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1059:1: ( ( ( rule__Primary__ExpressionAssignment_1_2 ) ) )
            // InternalLogicLang.g:1060:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            {
            // InternalLogicLang.g:1060:1: ( ( rule__Primary__ExpressionAssignment_1_2 ) )
            // InternalLogicLang.g:1061:2: ( rule__Primary__ExpressionAssignment_1_2 )
            {
             before(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 
            // InternalLogicLang.g:1062:2: ( rule__Primary__ExpressionAssignment_1_2 )
            // InternalLogicLang.g:1062:3: rule__Primary__ExpressionAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Primary__ExpressionAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getExpressionAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_1__2__Impl"


    // $ANTLR start "rule__Primary__Group_2__0"
    // InternalLogicLang.g:1071:1: rule__Primary__Group_2__0 : rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1 ;
    public final void rule__Primary__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1075:1: ( rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1 )
            // InternalLogicLang.g:1076:2: rule__Primary__Group_2__0__Impl rule__Primary__Group_2__1
            {
            pushFollow(FOLLOW_4);
            rule__Primary__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__0"


    // $ANTLR start "rule__Primary__Group_2__0__Impl"
    // InternalLogicLang.g:1083:1: rule__Primary__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Primary__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1087:1: ( ( '(' ) )
            // InternalLogicLang.g:1088:1: ( '(' )
            {
            // InternalLogicLang.g:1088:1: ( '(' )
            // InternalLogicLang.g:1089:2: '('
            {
             before(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__0__Impl"


    // $ANTLR start "rule__Primary__Group_2__1"
    // InternalLogicLang.g:1098:1: rule__Primary__Group_2__1 : rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2 ;
    public final void rule__Primary__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1102:1: ( rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2 )
            // InternalLogicLang.g:1103:2: rule__Primary__Group_2__1__Impl rule__Primary__Group_2__2
            {
            pushFollow(FOLLOW_14);
            rule__Primary__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__1"


    // $ANTLR start "rule__Primary__Group_2__1__Impl"
    // InternalLogicLang.g:1110:1: rule__Primary__Group_2__1__Impl : ( ruleEquivalence ) ;
    public final void rule__Primary__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1114:1: ( ( ruleEquivalence ) )
            // InternalLogicLang.g:1115:1: ( ruleEquivalence )
            {
            // InternalLogicLang.g:1115:1: ( ruleEquivalence )
            // InternalLogicLang.g:1116:2: ruleEquivalence
            {
             before(grammarAccess.getPrimaryAccess().getEquivalenceParserRuleCall_2_1()); 
            pushFollow(FOLLOW_2);
            ruleEquivalence();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getEquivalenceParserRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__1__Impl"


    // $ANTLR start "rule__Primary__Group_2__2"
    // InternalLogicLang.g:1125:1: rule__Primary__Group_2__2 : rule__Primary__Group_2__2__Impl ;
    public final void rule__Primary__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1129:1: ( rule__Primary__Group_2__2__Impl )
            // InternalLogicLang.g:1130:2: rule__Primary__Group_2__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__2"


    // $ANTLR start "rule__Primary__Group_2__2__Impl"
    // InternalLogicLang.g:1136:1: rule__Primary__Group_2__2__Impl : ( ')' ) ;
    public final void rule__Primary__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1140:1: ( ( ')' ) )
            // InternalLogicLang.g:1141:1: ( ')' )
            {
            // InternalLogicLang.g:1141:1: ( ')' )
            // InternalLogicLang.g:1142:2: ')'
            {
             before(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_2_2()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__Group_2__2__Impl"


    // $ANTLR start "rule__Model__PropositionsAssignment"
    // InternalLogicLang.g:1152:1: rule__Model__PropositionsAssignment : ( ruleProposition ) ;
    public final void rule__Model__PropositionsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1156:1: ( ( ruleProposition ) )
            // InternalLogicLang.g:1157:2: ( ruleProposition )
            {
            // InternalLogicLang.g:1157:2: ( ruleProposition )
            // InternalLogicLang.g:1158:3: ruleProposition
            {
             before(grammarAccess.getModelAccess().getPropositionsPropositionParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleProposition();

            state._fsp--;

             after(grammarAccess.getModelAccess().getPropositionsPropositionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__PropositionsAssignment"


    // $ANTLR start "rule__Equivalence__RightAssignment_1_2"
    // InternalLogicLang.g:1167:1: rule__Equivalence__RightAssignment_1_2 : ( ruleImplication ) ;
    public final void rule__Equivalence__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1171:1: ( ( ruleImplication ) )
            // InternalLogicLang.g:1172:2: ( ruleImplication )
            {
            // InternalLogicLang.g:1172:2: ( ruleImplication )
            // InternalLogicLang.g:1173:3: ruleImplication
            {
             before(grammarAccess.getEquivalenceAccess().getRightImplicationParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleImplication();

            state._fsp--;

             after(grammarAccess.getEquivalenceAccess().getRightImplicationParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Equivalence__RightAssignment_1_2"


    // $ANTLR start "rule__Implication__RightAssignment_1_2"
    // InternalLogicLang.g:1182:1: rule__Implication__RightAssignment_1_2 : ( ruleDisjunction ) ;
    public final void rule__Implication__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1186:1: ( ( ruleDisjunction ) )
            // InternalLogicLang.g:1187:2: ( ruleDisjunction )
            {
            // InternalLogicLang.g:1187:2: ( ruleDisjunction )
            // InternalLogicLang.g:1188:3: ruleDisjunction
            {
             before(grammarAccess.getImplicationAccess().getRightDisjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDisjunction();

            state._fsp--;

             after(grammarAccess.getImplicationAccess().getRightDisjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Implication__RightAssignment_1_2"


    // $ANTLR start "rule__Disjunction__RightAssignment_1_2"
    // InternalLogicLang.g:1197:1: rule__Disjunction__RightAssignment_1_2 : ( ruleConjunction ) ;
    public final void rule__Disjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1201:1: ( ( ruleConjunction ) )
            // InternalLogicLang.g:1202:2: ( ruleConjunction )
            {
            // InternalLogicLang.g:1202:2: ( ruleConjunction )
            // InternalLogicLang.g:1203:3: ruleConjunction
            {
             before(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleConjunction();

            state._fsp--;

             after(grammarAccess.getDisjunctionAccess().getRightConjunctionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Disjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Conjunction__RightAssignment_1_2"
    // InternalLogicLang.g:1212:1: rule__Conjunction__RightAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Conjunction__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1216:1: ( ( rulePrimary ) )
            // InternalLogicLang.g:1217:2: ( rulePrimary )
            {
            // InternalLogicLang.g:1217:2: ( rulePrimary )
            // InternalLogicLang.g:1218:3: rulePrimary
            {
             before(grammarAccess.getConjunctionAccess().getRightPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getConjunctionAccess().getRightPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conjunction__RightAssignment_1_2"


    // $ANTLR start "rule__Primary__ExpressionAssignment_1_2"
    // InternalLogicLang.g:1227:1: rule__Primary__ExpressionAssignment_1_2 : ( rulePrimary ) ;
    public final void rule__Primary__ExpressionAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1231:1: ( ( rulePrimary ) )
            // InternalLogicLang.g:1232:2: ( rulePrimary )
            {
            // InternalLogicLang.g:1232:2: ( rulePrimary )
            // InternalLogicLang.g:1233:3: rulePrimary
            {
             before(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Primary__ExpressionAssignment_1_2"


    // $ANTLR start "rule__BooleanVariable__NameAssignment"
    // InternalLogicLang.g:1242:1: rule__BooleanVariable__NameAssignment : ( RULE_ID ) ;
    public final void rule__BooleanVariable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1246:1: ( ( RULE_ID ) )
            // InternalLogicLang.g:1247:2: ( RULE_ID )
            {
            // InternalLogicLang.g:1247:2: ( RULE_ID )
            // InternalLogicLang.g:1248:3: RULE_ID
            {
             before(grammarAccess.getBooleanVariableAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getBooleanVariableAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanVariable__NameAssignment"


    // $ANTLR start "rule__BooleanLiteral__TruthAssignment"
    // InternalLogicLang.g:1257:1: rule__BooleanLiteral__TruthAssignment : ( ( rule__BooleanLiteral__TruthAlternatives_0 ) ) ;
    public final void rule__BooleanLiteral__TruthAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalLogicLang.g:1261:1: ( ( ( rule__BooleanLiteral__TruthAlternatives_0 ) ) )
            // InternalLogicLang.g:1262:2: ( ( rule__BooleanLiteral__TruthAlternatives_0 ) )
            {
            // InternalLogicLang.g:1262:2: ( ( rule__BooleanLiteral__TruthAlternatives_0 ) )
            // InternalLogicLang.g:1263:3: ( rule__BooleanLiteral__TruthAlternatives_0 )
            {
             before(grammarAccess.getBooleanLiteralAccess().getTruthAlternatives_0()); 
            // InternalLogicLang.g:1264:3: ( rule__BooleanLiteral__TruthAlternatives_0 )
            // InternalLogicLang.g:1264:4: rule__BooleanLiteral__TruthAlternatives_0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanLiteral__TruthAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getTruthAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanLiteral__TruthAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000000C1810L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000100000L});

}