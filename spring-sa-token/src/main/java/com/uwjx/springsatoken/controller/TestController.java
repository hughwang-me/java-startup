package com.uwjx.springsatoken.controller;

import cn.dev33.satoken.basic.SaBasicUtil;
import cn.dev33.satoken.util.SaResult;
import com.uwjx.springsatoken.common.SaConstants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {

    @GetMapping(value = "test1")
    public String test1(){
        return SaConstants.SUCCESS;
    }

    @RequestMapping("checkBasic")
    public SaResult checkBasic() {
        SaBasicUtil.check("sa:123456");
        // ... 其它代码
        return SaResult.ok();
    }

    @GetMapping(value = "testHttpServletResponse")
    public void ch(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ("WWW-Authenticate", "Basic Realm=" + realm);
        log.warn("测试testHttpServletResponse");
        response.setStatus(401);
        response.addHeader("WWW-Authenticate" , "Basic Realm=Wa-Token");
//        response.getOutputStream().write("");
    }

}
