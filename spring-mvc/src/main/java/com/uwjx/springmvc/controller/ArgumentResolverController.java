package com.uwjx.springmvc.controller;

import com.uwjx.springmvc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "resolver")
@Slf4j
public class ArgumentResolverController {


    @GetMapping
    public String get(Person person){
        return "ok";
    }

}
