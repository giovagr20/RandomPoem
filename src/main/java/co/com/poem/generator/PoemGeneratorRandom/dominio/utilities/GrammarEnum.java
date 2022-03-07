package co.com.poem.generator.PoemGeneratorRandom.dominio.utilities;

public enum GrammarEnum {
    POEM("POEM: <LINE> <LINE> <LINE> <LINE> <LINE>"),
    LINE("LINE: <NOUN>|<PREPOSITION>|<PRONOUN> $LINEBREAK"),
    ADJECTIVE("ADJECTIVE: black|white|dark|light|bright|murky|muddy|clear <NOUN>|<ADJECTIVE>|$END"),
    NOUN("NOUN: heart|sun|moon|thunder|fire|time|wind|sea|river|flavor|wave|willow|rain|tree|flowe\n" +
            "r|field|meadow|pasture|harvest|water|father|mother|brother|sister\n" +
            "<VERB>|<PREPOSITION>|$END"),
    PRONOUN("PRONOUN: my|your|his|her <NOUN>|<ADJECTIVE>"),
    VERB("VERB: runs|walks|stands|climbs|crawls|flows|flies|transcends|ascends|descends|sinks <PREPOSITION>|<PRONOUN>|$END"),
    PREPOSITION("PREPOSITION: above|across|against|along|among|around|before|behind|beneath|beside|between|beyon\n" +
            "d|during|inside|onto|outside|under|underneath|upon|with|without|through\n" +
            "<NOUN>|<PRONOUN>|<ADJECTIVE>");

    private String value;

    GrammarEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
