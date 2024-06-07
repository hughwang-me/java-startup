package com.uwjx.springmvc.sync;

import com.uwjx.springmvc.dal.dao.CaffeineUserRepository;
import com.uwjx.springmvc.dal.dao.JsKafkaPdaRepository;
import com.uwjx.springmvc.dal.entity.CaffeineUser;
import com.uwjx.springmvc.dal.entity.JsKafkaPda;
import com.uwjx.springmvc.dal.entity.SyncData;
import com.uwjx.springmvc.dal.dao.SyncRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.Instant;

@Service
@Slf4j
public class SyncService {

    @Resource
    JsKafkaPdaRepository jsKafkaPdaRepository;

    @Resource
    CaffeineUserRepository caffeineUserRepository;

    @Async("javaTpExecutor")
    public void save2Db(JsKafkaPda jsKafkaPda1){

        JsKafkaPda jsKafkaPda = new JsKafkaPda();
        jsKafkaPda.setDate(Instant.now());
        String threadName = Thread.currentThread().getName();
        jsKafkaPda.setName(threadName);


        log.warn("{} 进入队列" , threadName);
        synchronized (this){
            JsKafkaPda item = jsKafkaPdaRepository.findFirstByName(jsKafkaPda.getName());
            if(ObjectUtils.isEmpty(item)){
                jsKafkaPdaRepository.save(jsKafkaPda);
            }else {
                item.setDate(Instant.now());
                jsKafkaPdaRepository.save(item);
            }
            log.warn("{} 处理完毕" , threadName);
        }
    }

    public void saveCaffeineUser2Db(CaffeineUser caffeineUser){
        CaffeineUser item = caffeineUserRepository.findFirstByName(caffeineUser.getName());
        if(ObjectUtils.isEmpty(item)){
            caffeineUserRepository.save(caffeineUser);
        }
    }
}
