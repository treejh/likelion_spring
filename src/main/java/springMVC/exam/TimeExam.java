package springMVC.exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class TimeExam {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());

        LocalDate firstDate = LocalDate.of(2025,1,1);
        System.out.println(firstDate.plusDays(100));

        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        System.out.println(ZonedDateTime.now(ZoneId.of(("America/Argentina/Buenos_Aires"))));

        Set<String> ZoneIds = ZoneId.getAvailableZoneIds();

//        for(String zone : ZoneIds){
//            System.out.println(zone);
//        }
    }
}
