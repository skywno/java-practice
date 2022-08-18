import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTimes {

    public enum OffsetType {
        GMT, UTC
    }
    public static List<String> fetchTimeZones7(OffsetType type) {
        List<String> timeZones = new ArrayList<String>();
        String[] zoneIds = TimeZone.getAvailableIDs();

        long timestamp = new Date().getTime();

        for (String zoneId: zoneIds) {
            TimeZone curTimeZone = TimeZone.getTimeZone(zoneId);
            curTimeZone.useDaylightTime();
            String offset = formatOffset(curTimeZone.getOffset(timestamp));

            timeZones.add("(" + type + offset + ")" + zoneId);
        }

        return timeZones;
    }

    public static List<String> fetchTimeZones8(OffsetType type) {
        List<String> timeZones = new ArrayList<String>();
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        LocalDateTime now = LocalDateTime.now();

        zoneIds.forEach(zoneId -> {
            timeZones.add("(" + type + now.atZone(ZoneId.of(zoneId)).getOffset().getId().replace("Z", "00:00") + ")" + zoneId);
        });

        return timeZones;
    }

    public static String formatOffset(int offset) {

        if (offset == 0) {
            return "+00:00";
        }

        long offsetInHours = TimeUnit.MILLISECONDS.toHours(offset);
        long offsetInMinutesFromHours = TimeUnit.HOURS.toMinutes(offsetInHours);
        long offsetInMinutes = TimeUnit.MILLISECONDS.toMinutes(offset);

        offsetInMinutes = Math.abs(offsetInMinutesFromHours - offsetInMinutes);

        return String.format("%+03d:%02d", offsetInHours, offsetInMinutes);
    }
}
