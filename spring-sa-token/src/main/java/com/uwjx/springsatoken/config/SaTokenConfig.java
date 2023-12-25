package com.uwjx.springsatoken.config;

import cn.dev33.satoken.interceptor.SaInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class SaTokenConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 Sa-Token 拦截器，打开注解式鉴权功能
        log.warn("注册 Sa-Token 拦截器，打开注解式鉴权功能");
//        registry.addInterceptor(new SaInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new SaInterceptor(
//                        handler -> {
//                            SaRouter.match("/**")
//                                    .notMatch("/account/*")
//                                    .check(r -> StpUtil.checkLogin());
//                        }
//                ))
//                .addPathPatterns("/**");
    }
}
