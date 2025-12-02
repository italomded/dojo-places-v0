package br.com.alura.dojoplaces.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtilities {
    private static final DateTimeFormatter BRAZILIAN_DATE_CONVENTION_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String formatDateToBrazilianConvention(LocalDateTime dateTime) {
        return BRAZILIAN_DATE_CONVENTION_FORMATTER.format(dateTime);
    }

    public static long countDaysSince(LocalDateTime dateTime) {
        return dateTime.until(LocalDateTime.now(), ChronoUnit.DAYS);
    }
}
