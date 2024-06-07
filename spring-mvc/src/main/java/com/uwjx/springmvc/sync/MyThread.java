package com.uwjx.springmvc.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class MyThread extends Thread{

    private int count;
    @Override
    public void run() {
        log.warn("{} -> {}" , Thread.currentThread().getName() , "进入RUN()");
        synchronized (this){
            count--;
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(3));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.warn("{} -> count-- {}" , Thread.currentThread().getName() , count);
        }
    }
}
