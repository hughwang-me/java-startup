package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.UserAdditionalInfo;
import com.uwjx.springmvc.model.UserBasicInfo;
import com.uwjx.springmvc.model.UserInfo;
import com.uwjx.springmvc.service.UserAdditionalInfoService;
import com.uwjx.springmvc.service.UserBasicInfoService;
import com.uwjx.springmvc.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.*;
import java.util.function.Supplier;

@RestController
@RequestMapping("completableFuture")
@Slf4j
public class CompletableFutureController {

    @Autowired
    UserBasicInfoService basicInfoService;
    @Autowired
    UserAdditionalInfoService additionalInfoService;

    @GetMapping("userInfo")
    public String userInfo( ) throws InterruptedException {
        log.warn("CompletableFutureController -> userInfo");
        UserBasicInfo userBasicInfo = basicInfoService.get();
        UserAdditionalInfo userAdditionalInfo = additionalInfoService.get();
        UserInfo userInfo = new UserInfo();
        userInfo.setBasicInfo(userBasicInfo);
        userInfo.setAdditionalInfo(userAdditionalInfo);
        return JSON.toJSONString(userInfo);
    }

    @GetMapping("userInfo2")
    public String userInfo2( ) throws InterruptedException, ExecutionException {
        log.warn("CompletableFutureController -> userInfo2");
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        log.warn("当前时间 开始 userBasicInfoFutureTask : {}" , DateUtil.current());
        FutureTask<UserBasicInfo> userBasicInfoFutureTask = new FutureTask<>(() -> basicInfoService.get());
        executorService.submit(userBasicInfoFutureTask);

        log.warn("当前时间 开始 userAdditionalInfoFutureTask : {}" , DateUtil.current());
        FutureTask<UserAdditionalInfo> userAdditionalInfoFutureTask = new FutureTask<>(() -> additionalInfoService.get());
        executorService.submit(userAdditionalInfoFutureTask);

        UserAdditionalInfo userAdditionalInfo = userAdditionalInfoFutureTask.get();
        log.warn("查询完毕 userAdditionalInfo : {}" , DateUtil.current());
        UserBasicInfo userBasicInfo = userBasicInfoFutureTask.get();
        log.warn("查询完毕 userBasicInfo : {}" , DateUtil.current());

        UserInfo userInfo = new UserInfo();
        userInfo.setBasicInfo(userBasicInfo);
        userInfo.setAdditionalInfo(userAdditionalInfo);
        return JSON.toJSONString(userInfo);
    }

    @GetMapping("userInfo3")
    public String userInfo3( ) throws InterruptedException, ExecutionException {
        log.warn("CompletableFutureController -> userInfo2");
        CompletableFuture<UserBasicInfo> userBasicInfoCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return basicInfoService.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        CompletableFuture<UserAdditionalInfo> userAdditionalInfoCompletableFuture = CompletableFuture.supplyAsync(()->{
            try {
                return additionalInfoService.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        UserAdditionalInfo userAdditionalInfo = userAdditionalInfoCompletableFuture.get();
        log.warn("查询完毕 userAdditionalInfo : {}" , DateUtil.current());
        UserBasicInfo userBasicInfo = userBasicInfoCompletableFuture.join();
        log.warn("查询完毕 userBasicInfo : {}" , DateUtil.current());

        UserInfo userInfo = new UserInfo();
        userInfo.setBasicInfo(userBasicInfo);
        userInfo.setAdditionalInfo(userAdditionalInfo);
        return JSON.toJSONString(userInfo);
    }
}
