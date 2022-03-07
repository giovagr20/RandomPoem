package co.com.poem.generator.PoemGeneratorRandom.aplicacion.process.handlers;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.services.GrammarRulesService;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.services.PoemRandomService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HandlerRandomGenerator {

    private final GrammarRulesService grammarRulesService;
    private final PoemRandomService poemRandomService;

    public HandlerRandomGenerator(GrammarRulesService grammarRulesService, PoemRandomService poemRandomService) {
        this.grammarRulesService = grammarRulesService;
        this.poemRandomService = poemRandomService;
    }

    public Optional<String> execute() {
        grammarRulesService.parse().get();
        return Optional.of("ok");
    }
}