package com.github.dreamroute.ttl.sample.controller;

import com.github.dreamroute.ttl.sample.service.PoolUseService;
import com.github.dreamroute.ttl.sample.service.TtlService;
import com.github.dreamroute.ttl.sample.service.AsyncService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TtlController {

    private TtlService ttlService;
    private AsyncService asyncService;
    private PoolUseService poolUseService;

    @GetMapping("/ttl")
    public String ttl() {
        ttlService.ttl();
        asyncService.as();
        poolUseService.pu();
        return "ok";
    }
}
