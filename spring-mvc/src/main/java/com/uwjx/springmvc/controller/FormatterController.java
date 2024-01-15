package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.vo.BRequestVO;
import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("formatter")
@Slf4j
public class FormatterController {

    @GetMapping("o2o")
    public String formatter(@ModelAttribute ProductRequestVO productRequestVO , BRequestVO bRequestVO) {
        log.warn("FormatterController -> formatter");
        log.warn("FormatterController -> formatter productRequestVO : {}" , JSON.toJSONString(productRequestVO));
        log.warn("FormatterController -> formatter bRequestVO : {}" , JSON.toJSONString(bRequestVO));
        return "";
    }

    @GetMapping(value = "s2o")
    public String s2o(@RequestParam("str") BRequestVO bRequestVO) {
        log.warn("FormatterController -> s2o");
        log.warn("FormatterController -> s2o : {}" , JSON.toJSONString(bRequestVO));
        return "";
    }

    @GetMapping(value = "s2o2")
    public String s2o2(@RequestParam("str") ProductRequestVO bRequestVO) {
        log.warn("FormatterController -> s2o2");
        log.warn("FormatterController -> s2o2 : {}" , JSON.toJSONString(bRequestVO));
        return "";
    }
}
