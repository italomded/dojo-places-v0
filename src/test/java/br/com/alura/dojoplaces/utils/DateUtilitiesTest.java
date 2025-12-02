package br.com.alura.dojoplaces.utils;


import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilitiesTest {
    @Test
    void countDaysSince__should_return_correct_amount_of_days_since_date() {
        LocalDateTime now = LocalDateTime.now();
        assertEquals(0, DateUtilities.countDaysSince(now));

        LocalDateTime tomorrow = now.minusDays(1);
        assertEquals(1, DateUtilities.countDaysSince(tomorrow));

        LocalDateTime nextMonth = now.minusDays(30);
        assertEquals(30, DateUtilities.countDaysSince(nextMonth));
    }

    @Test
    void formatDateToBrazilianConvention__should_return_correct_data_format() {
        assertEquals("04/08/2001", DateUtilities.formatDateToBrazilianConvention(LocalDateTime.of(2001, Month.AUGUST, 4, 0, 0)));
        assertEquals("29/11/2001", DateUtilities.formatDateToBrazilianConvention(LocalDateTime.of(2001, Month.NOVEMBER, 29, 0, 0)));
    }
}
