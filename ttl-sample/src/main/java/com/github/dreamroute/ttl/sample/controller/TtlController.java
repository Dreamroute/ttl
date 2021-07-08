package com.github.dreamroute.ttl.sample.controller;

import com.github.dreamroute.ttl.sample.service.AsyncService;
import com.github.dreamroute.ttl.sample.service.PoolUseService;
import com.github.dreamroute.ttl.sample.service.TtlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TtlController {

    private final TtlService ttlService;
    private final AsyncService asyncService;
    private final PoolUseService poolUseService;

    @GetMapping("/ttl")
    public String ttl(Long id) {
        ttlService.ttl();
        asyncService.as();
        poolUseService.pu();
        return "ok";
    }
}
