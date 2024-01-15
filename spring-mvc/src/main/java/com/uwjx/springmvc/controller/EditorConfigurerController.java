package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.vo.BRequestVO;
import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("editor")
@Slf4j
public class EditorConfigurerController {

    @GetMapping("test1")
    public String test1(@RequestParam("date") Date date ) {
        log.warn("EditorConfigurerController -> test1");
        log.warn("EditorConfigurerController -> test1 date : {}" , JSON.toJSONString(date));
        return "";
    }
}
