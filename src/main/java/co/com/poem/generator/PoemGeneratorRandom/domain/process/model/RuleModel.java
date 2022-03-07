package co.com.poem.generator.PoemGeneratorRandom.domain.process.model;

import java.util.List;

public class RuleModel {
    private String ruleName;
    private List<String> words;
    private List<String> keywords;

    public RuleModel() {
    }

    public RuleModel(String ruleName, List<String> words, List<String> keywords) {
        this.ruleName = ruleName;
        this.words = words;
        this.keywords = keywords;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
