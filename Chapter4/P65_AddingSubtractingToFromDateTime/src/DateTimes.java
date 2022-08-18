import java.util.Calendar;
import java.util.Date;

public class DateTimes {
    public static Date addOrSubtractYears(Date date, int year) {
//        return new Date(date.getYear()+year, date.getMonth(), date.getDate(), date.getHours(), date.getMinutes());

        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.YEAR, year);

        return calendar.getTime();
    }

    public static Date addOrSubtractHours(Date date, int hours) {

        if (date == null) {
            throw new IllegalArgumentException("Hours cannot be null");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.HOUR, hours);

        return calendar.getTime();
    }
}
