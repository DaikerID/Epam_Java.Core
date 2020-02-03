package com.Epam.JavaCore.hw18_29_01_20.common.solutions.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class JavaUtilDateUtils {

  private static final String PATTERN = "dd.MM.yyyy";

  private JavaUtilDateUtils(){

  }

  public static ZonedDateTime valueOf(String dateStr, String pattern) throws ParseException {
    return ZonedDateTime.of(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern)),
            LocalTime.now(),
            ZoneId.systemDefault());
  }

  public static ZonedDateTime valueOf(String dateStr) throws ParseException {
    return ZonedDateTime.of(LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(PATTERN)),
            LocalTime.now(),
            ZoneId.systemDefault());
  }

}
