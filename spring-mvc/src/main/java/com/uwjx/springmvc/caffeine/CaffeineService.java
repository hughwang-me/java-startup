package com.uwjx.springmvc.caffeine;

import com.uwjx.springmvc.dal.dao.CaffeineUserRepository;
import com.uwjx.springmvc.dal.entity.CaffeineUser;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class CaffeineService {

    @Resource
    CaffeineUserRepository caffeineUserRepository;

    public List<CaffeineUser> get() {
        List<CaffeineUser> all = caffeineUserRepository.findAll();
        return all;
    }


    @Cacheable(value = "data", key = "#id")
    public CaffeineUser findById(Integer id) {
        log.warn("开始查询数据库");
        Optional<CaffeineUser> byId = caffeineUserRepository.findById(id);
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.warn("结束查询数据库");
        return byId.orElse(null);
    }
}
