import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy");
        DateTimeFormatter zoneFormatter = DateTimeFormatter.ofPattern("hh:mm a, MMM dd, yyyy z VV");

        ZonedDateTime auPerthDepart = ZonedDateTime.of(LocalDateTime.of(2022, Month.SEPTEMBER, 10, 15, 50), ZoneId.of("Australia/Perth"));

        System.out.println("Perth LocalDateTime: " + auPerthDepart.format(formatter)
                + " | Scheduled Flight Time: 27 hours and 40 minutes\n");

        ZonedDateTime euBucharestDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        ZonedDateTime auPerthArrive = auPerthDepart.plusHours(27).plusMinutes(40);
        ZonedDateTime euBucharestArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("Europe/Bucharest"));

        OffsetDateTime utcAtDepart = auPerthDepart.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();
        OffsetDateTime utcAtArrive = auPerthArrive.withZoneSameInstant(ZoneId.of("UTC")).toOffsetDateTime();

        System.out.println("UTC time at depart is: " + utcAtDepart.format(formatter));
        System.out.println("UTC time at arrive is: " + utcAtArrive.format(formatter));
        System.out.println("\nAt depart, in Perth is: " + auPerthDepart.format(zoneFormatter));
        System.out.println("At arrive, in Perth is: " + auPerthArrive.format(zoneFormatter));
        System.out.println("\nAt depart, in Bucharest is: " + euBucharestDepart.format(zoneFormatter));
        System.out.println("At arrive, in Bucharest is: " + euBucharestArrive.format(zoneFormatter));
    }
}