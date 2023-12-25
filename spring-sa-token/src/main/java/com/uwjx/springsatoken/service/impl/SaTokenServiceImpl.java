package com.uwjx.springsatoken.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SaTokenServiceImpl implements StpInterface {
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
