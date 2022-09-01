package javaBasic;

import java.sql.Timestamp;
import java.time.*;

public class DateAndTime {


    public void client() {

        //date
        LocalDate localDate = LocalDate.of(2022,2,20);
        //time
        LocalTime localTime = LocalTime.of(21,5,20);

        //date time
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        //timestamp
   //    ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Goose_Bay"));

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);


    }
}
