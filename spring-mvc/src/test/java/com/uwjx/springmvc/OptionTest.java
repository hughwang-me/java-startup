package com.uwjx.springmvc;

import com.uwjx.springmvc.vo.ProductRequestVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class OptionTest {

    public static void main(String[] args) {
        Optional<ProductRequestVO> productRequestVOOptional = Optional.empty();
//        log.warn("{}" , productRequestVOOptional.get());

        String name = null;
        String key = "你好";
        Optional<String> optionalName = Optional.empty();
        String a = optionalName.ofNullable(name).orElse(createString());
        log.warn("{}", a);


        String b = optionalName.ofNullable(name).orElseGet(() -> createString());

        log.warn("{}", b);
//        if(optionalName.isPresent()){
//            log.warn("{}" , optionalName.get());
//        }
    }

    private static String createString() {
        log.warn("- createString - ");
        return "createString";
    }
}
