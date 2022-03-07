package co.com.poem.generator.PoemGeneratorRandom.infraestructure.rest;

import co.com.poem.generator.PoemGeneratorRandom.infraestructure.services.RandomGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/generate")
@Tag(name = "Controlador para solicitar la generaci\u00F3n de poema")
public class RandomGeneratorRest {

    private final RandomGeneratorService randomGeneratorService;

    public RandomGeneratorRest(RandomGeneratorService randomGeneratorService) {
        this.randomGeneratorService = randomGeneratorService;
    }

    @GetMapping
    @Operation(summary = "Genera poema aleatorio")
    public ResponseEntity<List<String>> generatePoem() {
        try {
            return ResponseEntity.ok().body(randomGeneratorService.execute());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.emptyList());
        }
    }
}
