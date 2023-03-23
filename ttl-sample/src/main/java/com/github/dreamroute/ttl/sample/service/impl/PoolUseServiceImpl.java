package com.github.dreamroute.ttl.sample.service.impl;

import com.github.dreamroute.ttl.sample.service.PoolUseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

@Slf4j
@Service
public class PoolUseServiceImpl implements PoolUseService {

    @Resource
    private ExecutorService pool;

    @Override
    public void poolUse() {
        Collection<Callable<Void>> cs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cs.add(() -> {
                log.warn("     pool-use-service in: tid: " + currentThread().getId() + ", time: " + TIME.get());
                return null;
            });
        }
        try {
            pool.invokeAll(cs);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        pool.submit(() -> log.info("                     submit              " + TIME.get()));
        CompletableFuture.supplyAsync(() -> {
            log.info("          completablefuture              " + TIME.get());

            for (int k = 0; k < 10; k++) {
                Thread t = new Thread(() -> log.info("    inner.completablefuture              " + TIME.get()));
                t.setName("innser.completable." + k);
                t.start();
            }

            try {
                SECONDS.sleep(1L);
            } catch (Exception e) {
                //
            }
            return "w.dehai";
        }, pool).join();
        log.info("                                         " + TIME.get());
    }
}
