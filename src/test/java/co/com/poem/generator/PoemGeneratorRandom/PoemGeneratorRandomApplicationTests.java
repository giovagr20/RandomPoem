package co.com.poem.generator.PoemGeneratorRandom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@ComponentScan("co.com.poem.generator")
@Profile("test")
@SpringBootTest
public class PoemGeneratorRandomApplicationTests {
}
