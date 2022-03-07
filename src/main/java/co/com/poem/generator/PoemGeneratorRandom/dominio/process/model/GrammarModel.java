package co.com.poem.generator.PoemGeneratorRandom.dominio.process.model;


import java.util.HashMap;
import java.util.Map;

public class GrammarModel {
    private String mainRule;
    private Map<String, RuleModel> rules;

    public GrammarModel() {
    }

    public GrammarModel(String mainRule, Map<String, RuleModel> rules) {
        this.mainRule = mainRule;
        this.rules = rules;
    }

    public String getMainRule() {
        return mainRule;
    }

    public void setMainRule(String mainRule) {
        this.mainRule = mainRule;
    }

    public Map<String, RuleModel> getRules() {
        if (this.rules==null){
            rules = new HashMap<>();
        }

        return rules;
    }

    public void setRules(Map<String, RuleModel> rules) {
        this.rules = rules;
    }
}
