package com.uwjx.springmvc.sync;

import com.uwjx.springmvc.dal.dao.CaffeineUserRepository;
import com.uwjx.springmvc.dal.dao.JsKafkaPdaRepository;
import com.uwjx.springmvc.dal.entity.CaffeineUser;
import com.uwjx.springmvc.dal.entity.JsKafkaPda;
import com.uwjx.springmvc.dal.entity.SyncData;
import com.uwjx.springmvc.dal.dao.SyncRepository;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@Slf4j
public class SyncService {

    @Resource
    JsKafkaPdaRepository jsKafkaPdaRepository;

    @Resource
    CaffeineUserRepository caffeineUserRepository;


    public void save2Db(JsKafkaPda jsKafkaPda){
        JsKafkaPda item = jsKafkaPdaRepository.findFirstByName(jsKafkaPda.getName());
        if(ObjectUtils.isEmpty(item)){
            jsKafkaPdaRepository.save(jsKafkaPda);
        }
    }

    public void saveCaffeineUser2Db(CaffeineUser caffeineUser){
        CaffeineUser item = caffeineUserRepository.findFirstByName(caffeineUser.getName());
        if(ObjectUtils.isEmpty(item)){
            caffeineUserRepository.save(caffeineUser);
        }
    }
}
