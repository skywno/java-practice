import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("Before JDK 8: ");
        //yyyy-MM-dd
        Date date = new Date();

        SimpleDateFormat formatterD1 = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = formatterD1.format(date);
        System.out.println("d1 = " + d1);

        //yyyy-MM-dd HH:mm:ss
        SimpleDateFormat formatterD2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d2 = formatterD2.format(date);
        System.out.println("d2 = " + d2);

        //yyyy-MM-dd HH:mm:ss.SSSZ
        SimpleDateFormat formatterD3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
        String d3 = formatterD3.format(date);
        System.out.println("d3 = " + d3);

        System.out.println("\nStarting with JDK 8:");
        //yyyy-MM-dd
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ld1 = formatterLocalDate.format(localDate);
        System.out.println("ld1 = " + ld1);

        // or in short,
        String ld2 = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("ld2 = " + ld2);

        //HH:mm:ss
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatterLocalTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String lt1 = formatterLocalTime.format(localTime);
        System.out.println("lt1 = " + lt1);

        //or in short,
        String lt2 = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("lt2 = " + lt2);

        //yyyy-MM-dd HH:mm:ss
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ldt1 = formatterLocalDateTime.format(localDateTime);
        System.out.println("ldt1 = " + ldt1);

        //or in short,
        String ldt2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("ldt2 = " + ldt2);

        //E MMM yyyy hh:mm:ss.SSS Z
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        DateTimeFormatter formatterOffsetDateTime = DateTimeFormatter.ofPattern("E MMM yyyy hh:mm:ss.SSS Z");
        String odt1 = formatterOffsetDateTime.format(offsetDateTime);
        System.out.println("odt1 = " + odt1);

        //or in short,
        String odt2 = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("E MMM yyyy hh:mm:ss.SSS Z"));
        System.out.println("odt2 = " + odt2);

        //HH:mm:ss, Z
        OffsetTime offsetTime = OffsetTime.now();
        DateTimeFormatter formatterOffsetTime = DateTimeFormatter.ofPattern("HH:mm:ss, Z");
        String ot1 = formatterOffsetTime.format(offsetTime);
        //in short
        String ot2 = OffsetTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss, Z"));
        System.out.println("ot1 = " + ot1);
        System.out.println("ot2 = " + ot2);

    }
}
