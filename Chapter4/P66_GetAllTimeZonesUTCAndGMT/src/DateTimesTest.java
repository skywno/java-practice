import org.junit.jupiter.api.Test;

import java.util.List;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.TimeZone;


class DateTimesTest {

    @Test
    void fetchTimeZones7() {
        List<String> timeZones = DateTimes.fetchTimeZones7(DateTimes.OffsetType.UTC);
        System.out.println("timeZones = " + timeZones);
    }

    @Test
    void fetchTimeZones8() {
        System.out.println(ZoneId.getAvailableZoneIds());

    }
}