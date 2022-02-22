package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.TtlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class TtlServiceImpl implements TtlService {

    @Override
    public void ttl() {
        log.info("          ttl-service in: tid: " + currentThread().getId() + ", time: " + TIME.get());
    }
}
