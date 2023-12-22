package com.uwjx.springsatoken.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "account")
@Slf4j
public class AccountController {

    @GetMapping(value = "login")
    public String login(@RequestParam("username") String username
            , @RequestParam("password") String password){
        if(StringUtils.hasLength(username)
            && StringUtils.hasLength(password)){
            if(username.equals("wanghuan")
                && password.equals("123456")){
                StpUtil.login("wanghuan");
                return "登录OK";
            }
        }
        return "登录失败";
    }

    @GetMapping(value = "isLogin")
    public String isLogin(){
        return StpUtil.isLogin() ? "已经登录" : "未登录";
    }

    @GetMapping(value = "getTokenInfo")
    public SaTokenInfo getTokenInfo(){
        if(StpUtil.isLogin()){
            return StpUtil.getTokenInfo();
        }else {
            return null;
        }
    }

    @GetMapping(value = "logout")
    public String logout(){
        if(StpUtil.isLogin()){
            StpUtil.logout();
            return "已经退出登录";
        }else {
            return "当前未登录";
        }
    }
}
