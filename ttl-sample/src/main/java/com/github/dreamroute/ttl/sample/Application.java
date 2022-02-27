package com.github.dreamroute.ttl.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 结论：
 * 1. 默认情况下，spring会自动创建一个线程池ThreadPoolTaskExecutor（core: 8, max: Integer.MAX_VALUE, queue: Integer.MAX_VALUE），可以自定义线程名称前缀：spring.task.execution.thread-name-prefix
 * 2. 默认情况下，并不会使用spring线程池，而是使用tomcat线程池中的线程，线程名称是：nio-8080-exec-xxx
 * 3. tomcat线程池和spring线程池都可以在配置文件中被配置
 * 4. spring线程池只有异步调用（@Async）和注入pool会被使用（这里的AysncService和PoolUseService），否则，在单线程情况下都使用的是tomcat线程池
 * 5. 这里由于使用了ttl代理了线程池和单个线程，所以直接注入ExecutorService即可
 * 6. 观察控制台输出：
 *  1. info部分是tomcat线程
 *  2. warn部分是spring线程
 *  3. 二者的线程名称也不同
 *  4. 二者的tid（thread id）不同
 */
@Async
@SpringBootApplication
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
