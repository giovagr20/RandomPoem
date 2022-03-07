package co.com.poem.generator.PoemGeneratorRandom.domain.utilities;

import java.util.Optional;
import java.util.Random;

public class RandomNumber {

    public static Optional<Integer> getRandomNumber(int min, int max) {
        Random r = new Random();
        return Optional.of(r.nextInt(max - min) + min);
    }

}
