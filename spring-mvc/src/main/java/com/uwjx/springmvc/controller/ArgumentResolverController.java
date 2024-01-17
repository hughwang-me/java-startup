package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.Person;
import com.uwjx.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "resolver")
@Slf4j
public class ArgumentResolverController {


    @GetMapping
    public String get(Person person , @ModelAttribute User user){
        log.warn("person:{}" , JSON.toJSONString(person));
        log.warn("user:{}" , JSON.toJSONString(user));
        return "ok";
    }

}
