package com.uwjx.springmvc.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Slf4j
public class StreamTest {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1 ,"王欢1" , 18));
        personList.add(new Person(2 ,"王欢2" , 18));
        personList.add(new Person(3 ,"王欢3" ,19));
        personList.add(new Person(4 ,"王欢4" , 19));
        Person person = personList.stream().sorted(Comparator.comparing(Person::getAge).reversed()).limit(1).findFirst().orElse(new Person());
        log.warn("人员:{}" , person);
    }
}
