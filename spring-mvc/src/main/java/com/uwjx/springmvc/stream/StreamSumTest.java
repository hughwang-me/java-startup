package com.uwjx.springmvc.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
public class StreamSumTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1 ,"王欢1" , 18));
        personList.add(new Person(2 ,"王欢2" , 18));
        personList.add(new Person(3 ,"王欢1" ,18));
        personList.add(new Person(4 ,"王欢4" , 19));
        int sum = personList.stream().mapToInt(Person::getAge).sum();
        Map<String , List<Person>> stringPersonMap = personList.stream().collect(Collectors.groupingBy(person -> person.getName() + "." + person.getAge()));
        log.warn("sum:{}" , stringPersonMap);
    }
}
