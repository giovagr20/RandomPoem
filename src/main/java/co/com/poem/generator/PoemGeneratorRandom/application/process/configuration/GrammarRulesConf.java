package co.com.poem.generator.PoemGeneratorRandom.application.process.configuration;

import co.com.poem.generator.PoemGeneratorRandom.domain.process.persistence.port.RepositoryRandomGenerator;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.services.GrammarRulesService;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.services.RandomPoemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrammarRulesConf {

    @Bean
    public GrammarRulesService grammarRulesService() {
        return new GrammarRulesService();
    }

    @Bean
    public RandomPoemService randomPoemService(RepositoryRandomGenerator repositoryRandomGenerator) {
        return new RandomPoemService(repositoryRandomGenerator);
    }
}
