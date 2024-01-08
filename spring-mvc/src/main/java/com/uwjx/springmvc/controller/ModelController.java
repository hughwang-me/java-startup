package com.uwjx.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "model")
@Slf4j
public class ModelController {

    @GetMapping
    public String get(@RequestParam(value = "p1" , required = false) String p1){
        log.warn("get : p1 : {}" , p1);
        return "ok - " + p1;
    }

//    @ModelAttribute
//    public void initializeModel(Model model) {
//        // 在每次请求之前被调用，用于添加模型属性
//        log.warn("initializeModel 被执行");
//        User myUser = new User();
//        myUser.setAge("90");
//        myUser.setName("王佳敏");
//        model.addAttribute("globalAttribute", "globalValue");
//        model.addAttribute(myUser);
//    }
//
//    @ModelAttribute
//    public void initializeModel2(Model model) {
//        // 在每次请求之前被调用，用于添加模型属性
//        log.warn("initializeModel2 被执行");
//        User myUser = new User();
//        myUser.setAge("90");
//        myUser.setName("王佳敏");
//        model.addAttribute("globalAttribute", "globalValue");
//        model.addAttribute(myUser);
//    }

    @ModelAttribute
    public void myModel(@RequestParam(required = false) String abc, Model model) {
        log.warn("myModel 被执行");
        model.addAttribute("abc", abc);
        model.addAttribute("bbb", "bbb");
    }

    @GetMapping(value = "t1")
    public String t1(@ModelAttribute("abc") String abc){
        log.warn("t1 : 被执行 ");
        log.warn("abc = {}" , abc);
        return "ok - ";
    }

    @GetMapping(value = "t2")
    public String get(@ModelAttribute("myUser") User myUser){
        log.warn("get : p1 : {}" , JSON.toJSONString(myUser));
        return "ok - " + JSON.toJSONString(myUser);
    }
}
