package co.com.poem.generator.PoemGeneratorRandom.domain.utilities;

public enum KeywordsEnum {
    $END("\r"),
    $LINEBREAK("\n");

    private String value;

    KeywordsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
