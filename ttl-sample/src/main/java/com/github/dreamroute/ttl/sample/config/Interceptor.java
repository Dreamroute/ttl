package com.github.dreamroute.ttl.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.currentThread;

@Slf4j
public class Interceptor implements HandlerInterceptor {
    private final Set<Long> ids = new HashSet<>();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ids.add(currentThread().getId());
        log.info("interceptor ids: " + ids.size());
        return true;
    }
}
