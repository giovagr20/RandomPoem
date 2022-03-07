package co.com.poem.generator.PoemGeneratorRandom.application.process.handlers;

import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.services.GrammarRulesService;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.services.RandomPoemService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class HandlerRandomGenerator {

    private final GrammarRulesService grammarRulesService;
    private final RandomPoemService poemRandomService;

    public HandlerRandomGenerator(GrammarRulesService grammarRulesService, RandomPoemService poemRandomService) {
        this.grammarRulesService = grammarRulesService;
        this.poemRandomService = poemRandomService;
    }

    public Optional<List<String>> execute() {

        Optional<GrammarModel> grammar = grammarRulesService.parse();

        if (grammar.isEmpty()) {
            return Optional.empty();
        }

        return poemRandomService.generatePoem(grammar);
    }
}