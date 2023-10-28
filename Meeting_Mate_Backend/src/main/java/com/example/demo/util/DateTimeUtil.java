package com.example.demo.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static final String TIME_FORMAT = "hh:mm a";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);

    public static LocalTime parseTime(String timeString) {
        return LocalTime.parse(timeString, FORMATTER);
    }
}
