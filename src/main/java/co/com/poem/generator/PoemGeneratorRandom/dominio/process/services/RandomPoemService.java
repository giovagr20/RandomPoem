package co.com.poem.generator.PoemGeneratorRandom.dominio.process.services;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.RuleModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.persistence.port.RepositoryRandomGenerator;
import co.com.poem.generator.PoemGeneratorRandom.dominio.utilities.KeywordsEnum;
import co.com.poem.generator.PoemGeneratorRandom.dominio.utilities.RandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RandomPoemService {

    private final RepositoryRandomGenerator repositoryRandomGenerator;

    public RandomPoemService(RepositoryRandomGenerator repositoryRandomGenerator) {
        this.repositoryRandomGenerator = repositoryRandomGenerator;
    }

    public Optional<String> generatePoem(Optional<GrammarModel> grammarModel) {

        if (grammarModel.isEmpty()) {
            return Optional.empty();
        }

        RuleModel ruleModel = grammarModel.get().getRules().get(grammarModel.get().getMainRule());
        List<RuleModel> ruleQueues= new ArrayList<>();

        for (String ruleName: ruleModel.getKeywords()) {
            ruleQueues.add(grammarModel.get().getRules().get(ruleName.substring(1, ruleName.length() - 1)));
        }

        ruleQueues.stream().map(poem -> random(poem, grammarModel.get()));

        return repositoryRandomGenerator.generatePoem(grammarModel);
    }

    private List<String> random(RuleModel ruleModel, GrammarModel grammarModel) {
        List<String> infoPoem = new ArrayList<>();
        if (ruleModel.getWords() != null) {
            List<String> words = ruleModel.getWords();
            Optional<Integer> randomNumber = RandomNumber.getRandomNumber(0, words.size());

            if (randomNumber.isEmpty()) {
                return Collections.emptyList();
            }

            infoPoem.add(words.get(randomNumber.get()).concat(" "));

        }

        List<String> referencesAndKeywords = ruleModel.getKeywords();
        Optional<Integer> random = RandomNumber.getRandomNumber(0, referencesAndKeywords.size());

        if (random.isEmpty()) {
            return Collections.emptyList();
        }
        String refKeyString = referencesAndKeywords.get(random.get());

        if (refKeyString.matches("<[A-Z]+>")) {
            // The random selection is a Rule
            // Execute the rule
            RuleModel nextRule = grammarModel.getRules().get(refKeyString.substring(1, refKeyString.length() - 1));
            random(nextRule, grammarModel);
        }
        else {
            // The random selection is a Keyword
            // Print it
            KeywordsEnum valueOf = KeywordsEnum.valueOf(refKeyString);
            infoPoem.add(valueOf.getValue());
        }

        return infoPoem;
    }
}
