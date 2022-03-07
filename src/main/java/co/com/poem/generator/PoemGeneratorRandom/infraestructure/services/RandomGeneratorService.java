package co.com.poem.generator.PoemGeneratorRandom.infraestructure.services;

import co.com.poem.generator.PoemGeneratorRandom.application.process.handlers.HandlerRandomGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomGeneratorService {
    private final HandlerRandomGenerator handlerGenerator;

    public RandomGeneratorService(HandlerRandomGenerator handlerGenerator) {
        this.handlerGenerator = handlerGenerator;
    }

    public List<String> execute() {
        return handlerGenerator.execute().orElse(null);
    }
}
