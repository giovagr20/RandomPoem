package co.com.poem.generator.PoemGeneratorRandom.application.process.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RulesDto {
    private String ruleName;
    private List<String> words;
    private List<String> keywords;
}
