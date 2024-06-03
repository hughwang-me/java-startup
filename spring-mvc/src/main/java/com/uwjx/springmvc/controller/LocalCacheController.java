package com.uwjx.springmvc.controller;

import com.uwjx.springmvc.cached.LocalMyCacheManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "localCache")
@Slf4j
public class LocalCacheController {

    @Resource
    LocalMyCacheManager localMyCacheManager;


    @GetMapping
    public String get(@RequestParam(value = "key") String key ){
        return localMyCacheManager.get(key);
    }



    @PostMapping
    public String post(@RequestParam(value = "key") String key ,
                       @RequestParam(value = "value")String value){
        localMyCacheManager.set(key , value);
        return "ok";
    }

    @GetMapping(value = "print")
    public String print(){
        localMyCacheManager.printCache();
        return "ok";
    }

}
