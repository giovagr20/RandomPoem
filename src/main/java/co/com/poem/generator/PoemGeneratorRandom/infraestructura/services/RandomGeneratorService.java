package co.com.poem.generator.PoemGeneratorRandom.infraestructura.services;

import co.com.poem.generator.PoemGeneratorRandom.aplicacion.process.handlers.HandlerRandomGenerator;
import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorService {
    private final HandlerRandomGenerator handlerGenerator;

    public RandomGeneratorService(HandlerRandomGenerator handlerGenerator) {
        this.handlerGenerator = handlerGenerator;
    }

    public String execute() {
        return handlerGenerator.execute().orElse(null);
    }
}
