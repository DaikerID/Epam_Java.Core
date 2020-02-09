package com.Epam.JavaCore.hw20_07_02_20.common.solutions.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class JavaUtilDateUtils {

    private static final String PATTERN = "dd.MM.yyyy";

    private JavaUtilDateUtils() {

    }

    public static ZonedDateTime valueOf(String dateStr, String pattern) {
        return ZonedDateTime.of(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern)),
                LocalTime.now(),
                ZoneId.systemDefault());
    }

    public static ZonedDateTime valueOf(String dateStr) {
        return ZonedDateTime.of(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(PATTERN)),
                LocalTime.now(),
                ZoneId.systemDefault());
    }

}
