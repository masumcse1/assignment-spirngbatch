package com.mbank.transactioninfo.mapper;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.text.DateFormatter;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Component
@Getter
public class DateUtil {

    @Value("${file.date.format}")
    private    String dateFormat ;
    @Value("${file.time.format}")
    private   String timeFormat ;


}
