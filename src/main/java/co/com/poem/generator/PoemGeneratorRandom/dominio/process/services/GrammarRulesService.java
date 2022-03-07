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
        try {
            GrammarEnum[] grammarValues = GrammarEnum.values();
            for (int position = 0; position < grammarValues.length; position++) {
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

                    int indexReferenceKeyword = 0;

                    List<String> ruleWordreferences = Arrays.asList(ruleDefinition.split(" "));

                    if (isMatch(ruleWordreferences.get(0)).get()) {
                        List<String> words = Arrays.asList(ruleWordreferences.get(0).trim().split("\\|"));
                        rule.setWords(words);
                        indexReferenceKeyword = 1;
                    }

                    List<String> ruleReferenceKeyword = Arrays.asList(ruleWordreferences.get(indexReferenceKeyword).split("\\|"));
                    rule.setKeywords(ruleReferenceKeyword);
                    grammar.getRules().put(ruleName, rule);
                }
            }
            return Optional.of(grammar);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    private Optional<Boolean> isMatch(String regEx) {
        return Optional.of(regEx.matches("[a-z].*"));
    }
}
