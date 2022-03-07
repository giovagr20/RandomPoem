package co.com.poem.generator.PoemGeneratorRandom.aplicacion.process.handlers;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.services.GrammarRulesService;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.services.RandomPoemService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HandlerRandomGenerator {

    private final GrammarRulesService grammarRulesService;
    private final RandomPoemService poemRandomService;

    public HandlerRandomGenerator(GrammarRulesService grammarRulesService, RandomPoemService poemRandomService) {
        this.grammarRulesService = grammarRulesService;
        this.poemRandomService = poemRandomService;
    }

    public Optional<String> execute() {

        if (grammarRulesService.parse().isEmpty()) {
            return Optional.empty();
        }
        Optional<GrammarModel> grammar = grammarRulesService.parse();

        poemRandomService.generatePoem(grammar);

        return Optional.of("OK");
    }
}