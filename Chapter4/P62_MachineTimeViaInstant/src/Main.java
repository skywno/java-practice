import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        // Get an Instant
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        //String to Instant
        Instant timestampFromString = Instant.parse("2022-06-16T12:00:33.234Z");
        System.out.println("Timestamp from string: " + timestampFromString);

        //plus two hours
        Instant finlandTime = Instant.now().plus(2, ChronoUnit.HOURS);

        System.out.println("twoHoursLater = " + finlandTime);

        // Minus 10 minutes
        Instant tenMinutesEarlier = finlandTime.minus(10, ChronoUnit.MINUTES);
        System.out.println("tenMinutesEarlier = " + tenMinutesEarlier);

        //Check if one Instant is after another Instant
        Instant timestamp1 = Instant.now();
        Instant timestamp2 = timestamp1.plusSeconds(120);
        boolean isAfter = timestamp1.isAfter(timestamp2);
        System.out.println("isAfter = " + isAfter);
        boolean isBefore = timestamp1.isBefore(timestamp2);
        System.out.println("isBefore = " + isBefore);

        // Difference between two instants
        long difference = timestamp1.until(timestamp2, ChronoUnit.SECONDS);
        System.out.println("difference = " + difference);

        // Convert Instant to LocalDateTime
        LocalDateTime ldt = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);
        System.out.println("ldt = " + ldt);

        //Convert LocatlDateTime to Instant
        Instant instantLDT = LocalDateTime.now().toInstant(ZoneOffset.UTC);

        // Convert Instant to ZonedDateTime
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Helsinki"));
        System.out.println("zdt = " + zdt + "(offset: " + zdt.getOffset()+")");

        // Convert ZonedDateTime to Instant
        Instant instantZDT = LocalDateTime.now().atZone(ZoneId.of("Europe/Helsinki")).toInstant();
        System.out.println("instantZDT = " + instantZDT);

        // Convert Instant to OffsetDateTime
        OffsetDateTime odt = OffsetDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Helsinki"));
        OffsetDateTime odt2 = Instant.now().atOffset(ZoneOffset.of("+03:00"));
        System.out.println("odt = " + odt);
        System.out.println("odt2 = " + odt2);

        // Convert OffsetDateTime to Instant
        Instant instantODT = Instant.now().atOffset(ZoneOffset.of("+03:00")).toInstant();
        System.out.println("instantODT = " + instantODT);





    }
}
