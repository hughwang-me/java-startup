package com.uwjx.springmvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("myasp")
@Slf4j
public class MyAspectController {

    @GetMapping
    public String get(){
        log.warn("AspectController -> get");
        return "aspect - get";
    }
}
