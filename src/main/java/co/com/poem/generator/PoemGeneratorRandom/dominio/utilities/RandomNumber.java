package co.com.poem.generator.PoemGeneratorRandom.dominio.utilities;

import java.util.Optional;
import java.util.Random;

public class RandomNumber {

    public Optional<Integer> getRandomNumber(int min, int max) {
        Random r = new Random();
        return Optional.of(r.nextInt(max - min) + min);
    }

}
