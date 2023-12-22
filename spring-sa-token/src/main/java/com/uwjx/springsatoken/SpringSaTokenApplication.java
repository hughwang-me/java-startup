package com.uwjx.springsatoken;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringSaTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSaTokenApplication.class, args);
        log.warn("启动成功，Sa-Token 配置如下：{}" + SaManager.getConfig());
    }

}
