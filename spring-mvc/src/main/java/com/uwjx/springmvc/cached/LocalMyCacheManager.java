package com.uwjx.springmvc.cached;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class LocalMyCacheManager {
    private static LocalMyCacheManager localMyCacheManager;

    private LocalMyCacheManager() {
    }

    public static LocalMyCacheManager getInstance() {
        if (localMyCacheManager == null) {
            localMyCacheManager = new LocalMyCacheManager();
        }
        return localMyCacheManager;
    }

    private  Map<String , String> cached = new HashMap<>();

    public String get(String key) {
        if(!cached.containsKey(key)){
            log.warn("key : {} 不存在" , key);
        }
        return cached.get(key);
    }

    public void set(String key , String value) {
        cached.put(key , value);
    }

    public void remove(String key) {
        cached.remove(key);
    }

    public void printCache(){
        cached.forEach((k , v) -> {
            log.warn("key : {} value :{}" , k , v);
        });
    }

}
