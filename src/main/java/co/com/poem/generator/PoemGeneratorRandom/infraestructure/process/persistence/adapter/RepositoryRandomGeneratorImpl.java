package co.com.poem.generator.PoemGeneratorRandom.infraestructure.process.persistence.adapter;

import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.persistence.port.RepositoryRandomGenerator;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RepositoryRandomGeneratorImpl implements RepositoryRandomGenerator {

    @Override
    public Optional<String> generatePoem(Optional<GrammarModel> grammarModel) {
        return Optional.of("OK");
    }
}
