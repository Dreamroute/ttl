package com.github.dreamroute.ttl.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.currentThread;

@Slf4j
@Component
public class SpringFilter extends OncePerRequestFilter {

    private final Set<Long> ids = new HashSet<>();
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        filterChain.doFilter(httpServletRequest, httpServletResponse);
        ids.add(currentThread().getId());
        log.info("spring filter ids: " + ids.size());
    }
}
