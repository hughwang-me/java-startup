package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "netty")
@Slf4j
public class NettyController  {

    @Value("${netty.name}")
    String nettyName;
    @Value("${netty.port}")
    Integer nettyPort;

    @GetMapping
    public String get(){
        log.warn("nettyName :" , nettyName);
        log.warn("nettyPort :" , nettyPort);
        return "ok";
    }

    @PostMapping(value = "post")
    public String post(){
        log.warn("nettyName :" , nettyName);
        log.warn("nettyPort :" , nettyPort);
        return "ok POST";
    }

}
