package com.uwjx.springmvc.lamda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Message<P, K> {
    K print(P p);
}


@Slf4j
public class Lamda1Testing {

    public static void main(String[] args) {

        Function<String , String> function = String::toLowerCase;
        log.warn("结果:{}" , function.apply("Wdskja"));

        Function<String , Integer> f2 = Integer::parseInt;

        Consumer<String> consumer = System.out::print;
        consumer.accept("王欢");

        Supplier<Long> supplier = System::currentTimeMillis;
        log.warn("输出:{}" , supplier.get());

        String input = "100";
        Predicate<String> predicate = input::endsWith;
        log.warn("断言结果:{}" , predicate.test("0"));

        Function<String , Boolean> function1 = input::endsWith;
        log.warn("断言结果2:{}" , function1.apply("0"));
    }
}
