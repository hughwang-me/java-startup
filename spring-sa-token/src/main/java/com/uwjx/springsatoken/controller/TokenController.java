package com.uwjx.springsatoken.controller;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.uwjx.springsatoken.common.SaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "token")
@Slf4j
public class TokenController {

    @GetMapping(value = "getTokenSession")
    public SaSession getTokenSession(){
        return StpUtil.getTokenSession();
    }

    @GetMapping(value = "getTokenSessionByToken")
    public SaSession getTokenSessionByToken(@RequestParam("token") String token){
        return StpUtil.getTokenSessionByToken(token);
    }

    @GetMapping(value = "setTokenValue")
    public void setTokenValue(@RequestParam("token") String token){
        log.warn("setTokenValue - {}" , token);
        StpUtil.setTokenValue(token);
    }
}
