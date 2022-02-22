package com.github.dreamroute.ttl.sample.controller;

import com.github.dreamroute.ttl.sample.service.AsyncService;
import com.github.dreamroute.ttl.sample.service.PoolUseService;
import com.github.dreamroute.ttl.sample.service.TtlService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@RestController
@AllArgsConstructor
public class TtlController {

    private final TtlService ttlService;
    private final AsyncService asyncService;
    private final PoolUseService poolUseService;

    @GetMapping("/ttl")
    public String ttl() {
        log.info("           controller in: tid: " + currentThread().getId() + ", time: " + TIME.get());
        ttlService.ttl();
        asyncService.async();
        poolUseService.poolUse();
        return "ok";
    }
}
