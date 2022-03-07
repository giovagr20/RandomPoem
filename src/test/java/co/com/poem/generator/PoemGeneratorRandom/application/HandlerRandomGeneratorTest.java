package co.com.poem.generator.PoemGeneratorRandom.application;

import co.com.poem.generator.PoemGeneratorRandom.PoemGeneratorRandomApplicationTests;
import co.com.poem.generator.PoemGeneratorRandom.application.process.handlers.HandlerRandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest(classes = {PoemGeneratorRandomApplicationTests.class})
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class HandlerRandomGeneratorTest {

    @Autowired
    HandlerRandomGenerator handlerRandomGenerator;

    @Test
    @DisplayName("Must generate a new poem")
    void mustGenerateANewPoem() {
        List<String> info = handlerRandomGenerator.execute().get();

        Assertions.assertTrue(info.size() > 0);
    }
}
