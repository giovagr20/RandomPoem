package co.com.poem.generator.PoemGeneratorRandom.dominio.process.persistence.port;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;

import java.util.Optional;

public interface RepositoryRandomGenerator {

    Optional<String> generatePoem(Optional<GrammarModel> grammarModel);
}
