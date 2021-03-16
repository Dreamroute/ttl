package com.github.dreamroute.ttl.sample.config;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author w.dehi
 */
public class TimeThreadLocal {
    private TimeThreadLocal() {}
    public static final ThreadLocal<Long> TIME = new TransmittableThreadLocal<>();
}
