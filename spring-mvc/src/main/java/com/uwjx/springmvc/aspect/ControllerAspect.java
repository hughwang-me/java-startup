package com.uwjx.springmvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
@Slf4j
public class ControllerAspect {


    @Pointcut("execution(* com.uwjx.springmvc.controller.*(..))")
    public void point1(){

    }

    @Before("point1()")
    public void before(){
        log.warn("ControllerAspect before()");
    }
}
