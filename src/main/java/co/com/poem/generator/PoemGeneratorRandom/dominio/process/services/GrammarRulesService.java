package co.com.poem.generator.PoemGeneratorRandom.dominio.process.services;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.RuleModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.utilities.GrammarEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GrammarRulesService {

    public Optional<GrammarModel> parse() {

        GrammarModel grammar = new GrammarModel();
        int position = 0;
        try {
            GrammarEnum[] grammarValues = GrammarEnum.values();
            while (grammarValues.length != 0) {
                RuleModel rule = new RuleModel();

                String[] rules = grammarValues[position].getValue().split(":");
                String ruleName = rules[0].trim();
                String ruleDefinition = rules[1].trim();

                rule.setRuleName(ruleName);

                if (grammar.getMainRule() == null) {
                    grammar.setMainRule(ruleName);
                    List<String> references = Arrays.asList(ruleDefinition.split(" "));

                    rule.setKeywords(references);

                    grammar.getRules().put(ruleName, rule);
                } else {
                    List<String> ruleWordreferences = Arrays.asList(ruleDefinition.split(" "));

                    List<String> words = Arrays.asList(ruleWordreferences.get(0).trim().split("\\|"));
                }
            }
            return Optional.of(grammar);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
