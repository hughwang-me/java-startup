package com.uwjx.springmvc.random;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class RandomTest {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            log.warn("{}" , new Random().nextInt(28800));
        }
    }
}
