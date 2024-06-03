package com.uwjx.springmvc.controller;

import com.uwjx.springmvc.cached.CacheManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "localCache")
@Slf4j
public class LocalCacheController {

    @Resource
    CacheManager cacheManager;


    @GetMapping
    public String get(@RequestParam(value = "key") String key ){
        return cacheManager.get(key);
    }



    @PostMapping
    public String post(@RequestParam(value = "key") String key ,
                       @RequestParam(value = "value")String value){
        cacheManager.set(key , value);
        return "ok";
    }

    @GetMapping(value = "print")
    public String print(){
        cacheManager.printCache();
        return "ok";
    }

}
