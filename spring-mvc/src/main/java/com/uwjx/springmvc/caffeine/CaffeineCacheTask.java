package com.uwjx.springmvc.caffeine;

import com.uwjx.springmvc.util.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CaffeineCacheTask {

    @Resource
    private CacheManager cacheManager;

    @Resource
    CaffeineService caffeineService;

    @Scheduled(fixedRate = 1000 * 5)
    public void task(){
//        log.warn("执行CaffeineCacheTask缓存定时任务");
//        caffeineService.findById(2);
//        cacheManager.getCacheNames().forEach(name -> log.warn("name:{}", name));

//        Cache usersCache = cacheManager.getCache("2");
//        usersCache.put("2" , "time:" + DateUtil.current());
    }
}
