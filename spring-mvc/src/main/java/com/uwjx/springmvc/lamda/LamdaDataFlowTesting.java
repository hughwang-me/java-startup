package com.uwjx.springmvc.lamda;

import com.alibaba.fastjson.JSON;
import com.uwjx.springmvc.dal.entity.CaffeineUser;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class LamdaDataFlowTesting {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("first", "second", "third");
        Consumer<String> consumer = log::info;
//        stream.forEach(consumer);

        List<CaffeineUser> users = new ArrayList<>();
        users.add(new CaffeineUser(1, "王欢" , 35 , "爸爸"));
        users.add(new CaffeineUser(2, "郝达芬" , 30 , "妈妈"));
        users.add(new CaffeineUser(3, "王谦" , 1 , "儿子"));

//        List<String> list = stream.toList();
//        List<String> collected = list.stream().map(String::toUpperCase).distinct().collect(Collectors.toList());
//        log.warn("collected {}" , JSON.toJSONString(collected));


        int reduce = users.stream().map(user -> {
            log.warn("user id : {} age : {}" , user.getId() , user.getAge());
            int result = user.getId() * user.getAge();
            log.warn("result {}" , result);
            return result;
        }).reduce((a , b ) -> {
            log.warn("a {}", JSON.toJSONString(a));
            log.warn("b {}", JSON.toJSONString(b));
            return a+b;
        }).get();
        log.warn("reduce {}" , reduce);

//        CaffeineUser caffeineUser = users.stream()
//                .map(user -> {
//                    return user.getId() * user.getAge();
//                }).
//                reduce((a, b) -> {
//            log.warn("a {}", JSON.toJSONString(a));
//            log.warn("b {}", JSON.toJSONString(b));
//            return a;
//        }).get();
//        log.warn("user {}" , JSON.toJSONString(caffeineUser));
    }
}
