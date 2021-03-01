package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    private final Set<Long> ids = new HashSet<>();

    @Async
    @Override
    public void as() {
        long id = currentThread().getId();
        ids.add(id);
        log.info("as: spring ids: " + ids.size() + ", id: " + id + ", time: " + TIME.get());
    }
}
