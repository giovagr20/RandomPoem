package co.com.poem.generator.PoemGeneratorRandom.domain.process.persistence.port;

import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.GrammarModel;

import java.util.Optional;

public interface RepositoryRandomGenerator {

    Optional<String> generatePoem(Optional<GrammarModel> grammarModel);
}
