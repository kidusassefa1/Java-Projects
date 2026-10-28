package Workbook_3.FormatDates;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class FormatDates {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        ZonedDateTime gmtDate = ZonedDateTime.now(ZoneOffset.UTC);

        System.out.println(date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm")));
        System.out.println(gmtDate.format(DateTimeFormatter.ofPattern("EEEE, MMM dd, yyyy HH:mm")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("H:mm 'on' dd-MMM-yyyy")));

    }
}
