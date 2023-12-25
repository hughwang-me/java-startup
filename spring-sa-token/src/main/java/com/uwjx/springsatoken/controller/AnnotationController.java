package com.uwjx.springsatoken.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.uwjx.springsatoken.common.SaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "annotation")
@Slf4j
public class AnnotationController {

    @GetMapping("checkLogin")
    @SaCheckLogin
    public String checkLogin(){
        log.warn(SaConstants.SUCCESS);
        return SaConstants.SUCCESS;
    }

}
