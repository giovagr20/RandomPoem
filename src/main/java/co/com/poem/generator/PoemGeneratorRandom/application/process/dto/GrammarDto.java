package co.com.poem.generator.PoemGeneratorRandom.application.process.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class GrammarDto {
    private String mainRule;
    private HashMap<String, RulesDto> rules;
}