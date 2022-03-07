package co.com.poem.generator.PoemGeneratorRandom.infraestructura.process.persistence.adapter;

import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.model.RuleModel;
import co.com.poem.generator.PoemGeneratorRandom.dominio.process.persistence.port.RepositoryRandomGenerator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryRandomGeneratorImpl implements RepositoryRandomGenerator {

    @Override
    public Optional<String> generatePoem(Optional<GrammarModel> grammarModel) {
        return Optional.of("OK");
    }
}
