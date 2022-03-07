package co.com.poem.generator.PoemGeneratorRandom.dominio.process.services;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.RuleModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.persistence.port.RepositoryRandomGenerator;

import java.util.ArrayList;
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

        return repositoryRandomGenerator.generatePoem(grammarModel);
    }
}
