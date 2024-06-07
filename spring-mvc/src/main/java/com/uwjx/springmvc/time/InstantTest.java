package com.uwjx.springmvc.time;

import com.uwjx.springmvc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Slf4j
public class InstantTest {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        log.warn("instant -> {}" , instant);
        log.warn("纪元秒 -> {}" , instant.getEpochSecond());
        log.warn("王毫秒 -> {}" , instant.toEpochMilli());
        log.warn("时间戳 -> {}" , System.currentTimeMillis());
        log.warn("王纳秒 -> {}" , instant.getNano());

        log.warn("当前时间:{}" , DateUtil.current());
    }
}
