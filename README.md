# ttl-spring-boot-starter

封装了阿里[`TransmittableThreadLocal(TTL)`](https://github.com/alibaba/transmittable-thread-local)工具，让`SpringBoot`应用更简单地使用`TTL`。

#### 封装阿里`TTL`的原因

使用`Agent`的方式有点繁琐，需要修改启动命令；另外，本地`IDE`开发的时候总是需要配置`JVM`启动参数。

参考了`TTL`项目的issue [#152](https://github.com/alibaba/transmittable-thread-local/issues/152) 和 [#173](https://github.com/alibaba/transmittable-thread-local/issues/173)，总结出来的。

## 使用方法

`SpringBoot`依赖：

```xml
<dependency>
    <groupId>com.github.dreamroute</groupId>
    <artifactId>ttl-spring-boot-starter</artifactId>
    <version>最新版本</version>
</dependency>
```

#### 最新版本：[![点击查看](https://img.shields.io/maven-central/v/com.github.dreamroute/ttl-spring-boot-starter?color=2d545e&logo=apache-maven&logoColor=white)](https://search.maven.org/artifact/com.github.dreamroute/ttl-spring-boot-starter)

## 效果

* 系统中被`@Async`标记的方法回从`Spring`线程池中获取线程，获取到的线程已经被`TTL`处理过，对用户来说是透明的。
* 如果系统中其他地方需要使用线程池，并且希望带着`ThreadLocal`信息，那么直接注入`ExecutorService`即可，`starter`已经将`ExecutorService`用`TTL`代理，
只要引入`starter`包，系统中任何地方注入`ExecutorService`，都可以享受到`ThreadLocal`的传递。
