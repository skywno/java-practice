import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DateTimes {

    public static Date parseToDate(String source, String pattern) throws ParseException {
        Objects.requireNonNull(source);
        Objects.requireNonNull(pattern);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(source);

    }
    public static String fromDateAsString(Date date, String pattern) {
        Objects.requireNonNull(pattern);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static Date fromDateAsDate(Date date) throws ParseException {
        Objects.requireNonNull(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.parse(simpleDateFormat.format(date));

    }
    public static Date fromDateAsTime(Date date) throws ParseException {
        Objects.requireNonNull(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.parse(simpleDateFormat.format(date));


    }
}
