# ttl
transmittable-thread-local

##### 封装了阿里的ttl，封装的理由：使用agent的方式有点繁琐，需要修改启动命令，另外，本地IDE开发的时候总是需要配置jvm启动参数，参考了ttl项目的issue#152和#173，总结出来的。

##### 使用方法
SpringBoot依赖：
```
<dependency>
    <groupId>com.github.dreamroute</groupId>
    <artifactId>ttl-spring-boot-starter</artifactId>
    <version>最新版本</version>
</dependency>
```

### 最新版本，[点击查看](https://search.maven.org/search?q=ttl-spring-boot-starter)

##### 效果：
* 系统中被@Async标记的方法回从Spring线程池中获取线程，获取到的线程已经被ttl处理过，对用来说是透明的
* 如果系统中其他地方需要使用线程池，并且希望带着ThreadLocal信息，那么直接注入ExecutorService即可，starter已经将ExecutorService用ttl代理，
只要引入starter包，系统中任何地方注入ExecutorService，都可以享受到ThreadLocal的传递