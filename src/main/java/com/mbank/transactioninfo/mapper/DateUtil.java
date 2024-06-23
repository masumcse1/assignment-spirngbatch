package com.mbank.transactioninfo.mapper;

import javax.swing.text.DateFormatter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    public static Date getDate(String dateValue , String format) {
        ZoneId defaultZoneId = ZoneId.systemDefault();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate =  LocalDate.parse(dateValue,dateTimeFormatter);
        return  Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());


    }

    public static Time getTime(String time,String timeFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(timeFormat);

        try {
            long ms = sdf.parse(time).getTime();
            Time stime = new Time(ms);

            System.out.println(stime);
            return stime;
        } catch (ParseException e) {
            e.printStackTrace();
        }

         return null;

    }
}
