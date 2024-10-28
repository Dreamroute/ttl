package com.github.dreamroute.ttl.util;

import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 描述：TTL包装类, 通过此类包装过的线程池均具备ttl能力
 *
 * @author w.dehai.2024/8/14.00:12
 */
public class TtlUtil {
    public static ExecutorService wrap(ThreadPoolExecutor pool) {
        return TtlExecutors.getTtlExecutorService(pool);
    }
}
