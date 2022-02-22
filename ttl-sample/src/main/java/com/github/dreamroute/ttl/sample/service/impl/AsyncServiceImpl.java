package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    @Override
    public void async() {
        log.warn("        async-service in: tid: " + currentThread().getId() + ", time: " + TIME.get());
    }
}
