package com.uwjx.springmvc.cached;

import com.uwjx.springmvc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CacheTask {

    @Scheduled(fixedRate = 1000 * 5)
    public void task(){
        log.warn("执行缓存定时任务");
        CacheManager.getInstance().set("time" , DateUtil.current());
        log.warn("执行结果:{}" , CacheManager.getInstance().get("time"));
    }
}
