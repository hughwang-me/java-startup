package com.uwjx.springmvc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class CompletableFutureTest {

    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.completedFuture("你好");
        CompletableFuture<String> second = CompletableFuture.supplyAsync(() -> "第二个任务").thenComposeAsync(data -> {
            log.warn("第一步的返回值:{}" , data);
            return future;
        });

        log.warn("第 1 个任务 result -> {}", future.join());
        log.warn("第 2 个任务 result -> {}", second.join());
    }
}
