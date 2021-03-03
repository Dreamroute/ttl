package com.github.dreamroute.ttl.sample.controller;

import com.github.dreamroute.ttl.sample.service.AsyncService;
import com.github.dreamroute.ttl.sample.service.PoolUseService;
import com.github.dreamroute.ttl.sample.service.TtlService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.alibaba.fastjson.JSON.toJSONString;

@RestController
@AllArgsConstructor
public class TtlController {

    private TtlService ttlService;
    private AsyncService asyncService;
    private PoolUseService poolUseService;

    @GetMapping("/ttl")
    public String ttl(Long id) {
        ttlService.ttl();
        asyncService.as();
        poolUseService.pu();
        Dev dev = new Dev();
        dev.setId(id);
        return toJSONString(dev);
    }
}

@Data
class Dev {
    private Long id;
}
