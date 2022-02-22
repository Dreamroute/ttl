package com.github.dreamroute.ttl.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.Thread.currentThread;

@Slf4j
@Component
public class SpringFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        log.info("        spring filter in: tid: " + currentThread().getId() + ", time: " + TIME.get());
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        log.info("       spring filter out: tid: " + currentThread().getId() + ", time: " + TIME.get());
    }
}
