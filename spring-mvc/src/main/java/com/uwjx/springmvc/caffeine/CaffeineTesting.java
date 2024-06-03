package com.uwjx.springmvc.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CaffeineTesting {

    public static void main(String[] args) {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .maximumSize(100)
                .build();
        cache.put("name" , "王欢");
        cache.put("role" , "admin");
        log.info("name:{}" , cache.getIfPresent("name"));

        try {
            long a = TimeUnit.SECONDS.toMillis(5);
            log.warn("sleep {} seconds" , a);
            Thread.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("name:{}" , cache.getIfPresent("name"));
    }
}
