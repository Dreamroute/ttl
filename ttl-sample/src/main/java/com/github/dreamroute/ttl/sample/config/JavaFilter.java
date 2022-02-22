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

import static com.github.dreamroute.ttl.sample.config.TimeThreadLocal.TIME;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

@Slf4j
@WebFilter
@Component
public class JavaFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long time = currentTimeMillis();
        TIME.set(time);
        log.info("          java filter in: tid: " + currentThread().getId() + ", time: " + time);
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("         java filter out: tid: " + currentThread().getId() + ", time: " + TIME.get());
    }
}
