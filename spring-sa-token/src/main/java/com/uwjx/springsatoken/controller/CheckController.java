package com.uwjx.springsatoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "check")
@Slf4j
public class CheckController {


    @GetMapping(value = "permission")
    public String permission(@RequestParam("permission") String permission) {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasPermission(permission)) {
                return "有该权限";
            }
            return "无该权限";
        } else {
            return "当前未登录";
        }
    }

    @GetMapping(value = "checkPermission")
    public void checkPermission(@RequestParam("permission") String permission) {
        StpUtil.checkPermission(permission);
    }

    @GetMapping(value = "role")
    public String role(@RequestParam("role") String role) {
        if (StpUtil.isLogin()) {
            if (StpUtil.hasRole(role)) {
                return "有该角色";
            }
            return "无该角色";
        } else {
            return "当前未登录";
        }
    }
}
