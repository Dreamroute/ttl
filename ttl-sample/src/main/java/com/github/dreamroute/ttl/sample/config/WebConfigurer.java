package com.github.dreamroute.ttl.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfigurer {
    @Bean
    public Interceptor loginInterceptor() {
        return new Interceptor();
    }
}