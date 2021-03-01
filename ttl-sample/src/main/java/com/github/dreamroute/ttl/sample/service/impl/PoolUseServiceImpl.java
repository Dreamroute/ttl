package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.PoolUseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@Service
public class PoolUseServiceImpl implements PoolUseService {

    @Resource
    private ExecutorService pool;
    private final Set<Long> ids = new HashSet<>();

    @Override
    public void pu() {
        Collection<Callable<Void>> cs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cs.add(() -> {
                long id = currentThread().getId();
                ids.add(id);
                log.info("pu: spring ids: " + ids.size() + ", id: " + id + ", time: " + TIME.get());
                return null;
            });
        }
        try {
            pool.invokeAll(cs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
