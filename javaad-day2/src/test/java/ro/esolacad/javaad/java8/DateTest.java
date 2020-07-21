package ro.esolacad.javaad.java8;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

public class DateTest {

    @Test
    public void testDate() {
        Date date = new Date();

        System.out.println(date);
        date.setHours(10);

        System.out.println(date);
    }

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();

//        System.out.println(now);
//        System.out.println(LocalDate.of(2020, 1, 1));

        LocalDate localDate = now.withDayOfMonth(29);
        System.out.println(now);
        System.out.println(localDate);

        LocalDate localDate1 = localDate.plusDays(10);
        System.out.println(localDate1);
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();

        System.out.println(now);
    }

    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();

        System.out.println(now);

        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
    }

    @Test
    public void testZoneTime() {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-07-21T14:00:00");
        System.out.println(localDateTime);

        ZonedDateTime utc = localDateTime.atZone(ZoneId.of("UTC"));
        System.out.println(utc);

        ZonedDateTime bucharestTime = utc.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));
        System.out.println(bucharestTime);
    }

    @Test
    public void testPeriodDuration() {
        LocalDate now = LocalDate.now();
        LocalDate days = now.plusDays(15);

        Period between = Period.between(now, days);

        assert between.getDays() == 15;

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusDays(5);

        Duration duration = Duration.between(localDateTime, localDateTime1);

        assert duration.equals(Duration.ofDays(5));
        assert duration.equals(Duration.ofHours(5 * 24));
    }
}










