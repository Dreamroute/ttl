package com.github.dreamroute.ttl.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author w.dehai
 */
@Configuration
@ConditionalOnBean(ThreadPoolTaskExecutor.class)
public class TtlAutoConfiguration implements AsyncConfigurer {

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public Executor getAsyncExecutor() {
        return TtlExecutors.getTtlExecutor(threadPoolTaskExecutor);
    }

}