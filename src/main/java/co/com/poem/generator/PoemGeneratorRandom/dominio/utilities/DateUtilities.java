package co.com.poem.generator.PoemGeneratorRandom.dominio.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtilities {

    private DateUtilities() {
    }

    public static LocalDateTime getLocalDateTimeFromString(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}