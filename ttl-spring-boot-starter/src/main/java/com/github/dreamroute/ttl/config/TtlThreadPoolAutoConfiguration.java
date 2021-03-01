package com.github.dreamroute.ttl.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ExecutorService已经被ttl处理过了，可以直接注入到系统中使用
 *
 * @author w.dehi
 */
@AllArgsConstructor
public class TtlThreadPoolAutoConfiguration {

    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Bean
    public ExecutorService ttlThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = threadPoolTaskExecutor.getThreadPoolExecutor();
        return TtlExecutors.getTtlExecutorService(threadPoolExecutor);
    }
}
