package com.uwjx.springmvc.caffeine;

import com.uwjx.springmvc.dal.entity.CaffeineUser;
import com.uwjx.springmvc.util.DateUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "caffeine")
@Slf4j
public class CaffeineController {

    @Resource
    private CacheManager cacheManager;
    @Resource
    CaffeineService caffeineService;

    @GetMapping
    public List<CaffeineUser> get(@RequestParam("id") Integer id)
    {
        return caffeineService.get();
    }

    @GetMapping(value = "findById")
    public CaffeineUser findById(@RequestParam("id") Integer id)
    {
        return caffeineService.findById(id);
    }

    @GetMapping(value = "listKeys")
    public void listKeys(){
        cacheManager.getCacheNames().forEach(name -> log.warn("name:{}", name));
        Objects.requireNonNull(cacheManager.getCache("data")).putIfAbsent(2 , caffeineService.findById(2));
//        cacheManager.getCache("name").put("2" , "wanghuan" + DateUtil.current());
    }
}
