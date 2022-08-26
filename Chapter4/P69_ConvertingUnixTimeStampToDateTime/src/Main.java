import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Fri Aug 26 2022 15:09:07 GMT+0300 (동유럽 하계 표준시)
        long unixTimestamp = 1661515747; // SECONDS SINCE JAN 01 1970. (UTC)


        Date date1 = new Date(unixTimestamp * 1000L);
        Date date2 = new Date(TimeUnit.MILLISECONDS.convert(unixTimestamp, TimeUnit.SECONDS));

        System.out.println(unixTimestamp + " as date-time in default time zone is " + date1);
        System.out.println(unixTimestamp + " as date-time in default time zone is " + date2);

        // JDK 8
        Instant instant = Instant.ofEpochSecond(unixTimestamp);
        Date date3 = Date.from(instant);

        LocalDateTime date4 = LocalDateTime
                .ofInstant(instant, ZoneId.of("Australia/Perth"));

        ZonedDateTime date5 = ZonedDateTime
                .ofInstant(instant, ZoneId.of("Europe/Bucharest"));


        System.out.println(unixTimestamp + " as date-time in default time zone is " + date3);
        System.out.println("\n" + unixTimestamp + " as date-time in Australia/Perth time zone is " + date4);
        System.out.println(unixTimestamp + " as date-time in Europe/Bucharest time zone is "
                + date5.format(DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss Z VV")));
        System.out.println("\n" + unixTimestamp + " as instant (UTC time) is " + instant);
    }


}
