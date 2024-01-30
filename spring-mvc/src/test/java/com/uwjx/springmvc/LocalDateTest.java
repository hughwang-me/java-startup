package com.uwjx.springmvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class LocalDateTest {

    @Test
    public void run() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("日期1:{}", localDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        log.warn("日期2:{}", localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));

        Instant instant = Instant.now();
        log.warn("日期3:{}", instant.toEpochMilli());
        log.warn("日期4:{}", System.currentTimeMillis());
    }
}
