package co.com.poem.generator.PoemGeneratorRandom.domain.process.services;

import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.RuleModel;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.persistence.port.RepositoryRandomGenerator;
import co.com.poem.generator.PoemGeneratorRandom.domain.utilities.KeywordsEnum;
import co.com.poem.generator.PoemGeneratorRandom.domain.utilities.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RandomPoemService {

    private final RepositoryRandomGenerator repositoryRandomGenerator;

    public RandomPoemService(RepositoryRandomGenerator repositoryRandomGenerator) {
        this.repositoryRandomGenerator = repositoryRandomGenerator;
    }

    public Optional<List<String>> generatePoem(Optional<GrammarModel> grammarModel) {

        if (grammarModel.isEmpty()) {
            return Optional.empty();
        }

        RuleModel ruleModel = grammarModel.get().getRules().get(grammarModel.get().getMainRule());
        List<RuleModel> ruleQueues = new ArrayList<>();

        for (String ruleName : ruleModel.getKeywords()) {
            ruleQueues.add(grammarModel.get().getRules().get(ruleName.substring(1, ruleName.length() - 1)));
        }

        List<String> index = new ArrayList<>();
        for (RuleModel rule : ruleQueues) {
            index.add(random(rule, grammarModel.get()));
        }

        return Optional.of(index);
    }

    private static String random(RuleModel ruleModel, GrammarModel grammarModel) {
        String infoPoem = "";
        if (ruleModel.getWords() != null) {
            List<String> words = ruleModel.getWords();
            Optional<Integer> randomNumber = RandomNumber.getRandomNumber(0, words.size());

            if (randomNumber.isEmpty()) {
                return "";
            }

            return words.get(randomNumber.get()).concat(" ");
        }

        List<String> referencesAndKeywords = ruleModel.getKeywords();
        Optional<Integer> random = RandomNumber.getRandomNumber(0, referencesAndKeywords.size());

        if (random.isEmpty()) {
            return "";
        }
        String refKeyString = referencesAndKeywords.get(random.get());

        if (refKeyString.matches("<[A-Za-z]+>")) {
            RuleModel nextRule = grammarModel.getRules().get(refKeyString.substring(1, refKeyString.length() - 1));
            infoPoem = random(nextRule, grammarModel);
        } else {
            KeywordsEnum valueOf = KeywordsEnum.valueOf(refKeyString);
            infoPoem = valueOf.getValue();
        }

        return infoPoem;
    }
}
