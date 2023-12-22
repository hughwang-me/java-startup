package com.uwjx.springsatoken.config;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class SaTokenConfig implements StpInterface {
    @Override
    public List<String> getPermissionList(Object o, String s) {
        log.warn("==查询权限==");
        List<String> permission = new ArrayList<>();
        permission.add("user.*");
        permission.add("book.delete");
        permission.add("book.query");
        return permission;
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        log.warn("==查询角色==");
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("woker");
        roles.add("system.*");
        return roles;
    }
}
