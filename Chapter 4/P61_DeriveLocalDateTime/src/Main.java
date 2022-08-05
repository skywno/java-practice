import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalTime lt = LocalTime.now();
        LocalDate ld = LocalDate.now();
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        System.out.println("lt = " + lt);
        System.out.println("ld = " + ld);
        System.out.println("ldt = " + ldt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd E a hh:mm:ss");
        System.out.println("LocalDateTime: " + formatter.format(ldt));


    }
}
