package com.uwjx.springmvc.time;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

@Slf4j
public class LocalTimeTesting {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        log.warn("now:{}",now.getHour());

        LocalTime start = LocalTime.of(8,0,0);
        log.warn("start:{}",start.getHour());

        LocalDateTime localDateTime = LocalDateTime.now();
        log.warn("localDateTime:{}",localDateTime.getDayOfMonth());

        log.warn("currentTimeMillis 时间戳:{}",System.currentTimeMillis());
        log.warn("localDateTime 时间戳:{}",localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        //1716447345
        //1716447345147
    }
}
