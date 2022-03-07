package co.com.poem.generator.PoemGeneratorRandom.domain;

import co.com.poem.generator.PoemGeneratorRandom.PoemGeneratorRandomApplicationTests;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.model.GrammarModel;
import co.com.poem.generator.PoemGeneratorRandom.domain.process.services.GrammarRulesService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = {PoemGeneratorRandomApplicationTests.class})
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class GrammarRulesServiceTest {

    @Autowired
    GrammarRulesService grammarRulesService;

    @Test
    @DisplayName("Must have a new rule")
    void mustHaveNewRule() {
        GrammarModel grammarModel = grammarRulesService.parse().get();

        Assertions.assertTrue(!grammarModel.getRules().isEmpty());
    }
}
