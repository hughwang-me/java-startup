package com.uwjx.springmvc.sync;

import com.uwjx.springmvc.dal.entity.CaffeineUser;
import com.uwjx.springmvc.dal.entity.JsKafkaPda;
import com.uwjx.springmvc.dal.entity.SyncData;
import com.uwjx.springmvc.util.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
public class SyncTask {

    @Resource
    SyncService syncService;

    @Scheduled(fixedRate = 1000 * 2000)
    public void task() {


        JsKafkaPda jsKafkaPda = new JsKafkaPda();
        String threadName = Thread.currentThread().getName();
        jsKafkaPda.setPhone(1);
        jsKafkaPda.setName(threadName);
        jsKafkaPda.setDate(Instant.now());

//        log.info("开始执行同步插入 {}" , threadName);
        for (int i = 0; i < 10; i++) {
            syncService.save2Db(jsKafkaPda);
        }


//        CaffeineUser caffeineUser = new CaffeineUser();
//        String threadName = Thread.currentThread().getName();
//        caffeineUser.setName(threadName);
//        caffeineUser.setAge(18);
//        syncService.saveCaffeineUser2Db(caffeineUser);
    }
}
