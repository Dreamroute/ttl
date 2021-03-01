package com.github.dreamroute.ttl.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.currentThread;

@Slf4j
@WebFilter
@Component
public class JavaFilter implements Filter {

    private final Set<Long> ids = new HashSet<>();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        ids.add(currentThread().getId());
        log.info("java filter ids: " + ids.size());
        log.info("------------------------------");
    }
}
