package com.uwjx.springmvc.lamda;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class LamdaDataFlowTesting {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("first", "second", "third");
        Consumer<String> consumer = log::info;
        stream.forEach(consumer);

        List<String> list = stream.toList();
        List<String> collected = list.stream().map(String::toUpperCase).distinct().collect(Collectors.toList());

    }
}
