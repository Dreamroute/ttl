package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.TtlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class TtlServiceImpl implements TtlService {

    private final Set<Long> ids = new HashSet<>();

    @Override
    public void ttl() {
        long id = currentThread().getId();
        ids.add(id);
        Long time = currentTimeMillis();
        TIME.set(time);
        log.info("rt: tomcat ids: " + ids.size() + ", id: " + id + ", time: " + TIME.get());
    }
}
