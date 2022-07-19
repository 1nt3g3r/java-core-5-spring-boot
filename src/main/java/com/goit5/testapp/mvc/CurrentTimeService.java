package com.goit5.testapp.mvc;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

@Service
public class CurrentTimeService {
    public String getCurrentTime(String timezone) {
        return getCurrentTime("yyyy.MM.dd hh:mm:ss");
    }

    public String getCurrentTime(String timezone, String format) {
        if (timezone == null) {
            return LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern(format)
            );
        }

        Date date = new Date();
        DateFormat df = new SimpleDateFormat(format);
        df.setTimeZone(TimeZone.getTimeZone(timezone));

        return df.format(date);
    }
}
