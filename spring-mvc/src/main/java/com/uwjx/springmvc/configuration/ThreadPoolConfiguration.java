package com.uwjx.springmvc.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;


@Slf4j
@EnableAsync
@Configuration
public class ThreadPoolConfiguration {

    @Bean("javaTpExecutor")
    public ThreadPoolTaskExecutor javaTpExecutor() {
        ThreadPoolTaskExecutor threadPoolExecutor = new ThreadPoolTaskExecutor();
        threadPoolExecutor.setCorePoolSize(5);
        threadPoolExecutor.setMaxPoolSize(20);
        threadPoolExecutor.setQueueCapacity(1000);
        threadPoolExecutor.setThreadNamePrefix("java-testing-tp-");
        threadPoolExecutor.setKeepAliveSeconds(30);
        threadPoolExecutor.setAllowCoreThreadTimeOut(false);
        threadPoolExecutor.setWaitForTasksToCompleteOnShutdown(false);
        threadPoolExecutor.setAwaitTerminationSeconds(10);
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return threadPoolExecutor;
    }
}
