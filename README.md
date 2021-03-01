# ttl
transmittable-thread-local

##### 封装了阿里的ttl，封装的理由：使用agent的方式有点繁琐，需要修改启动命令，另外，本地IDE开发的时候总是需要配置jvm启动参数，参考了ttl项目的issue152和173，总结出来的。

##### 使用方法
SpringBoot依赖：
```
<dependency>
    <groupId>com.github.dreamroute</groupId>
    <artifactId>ttl-spring-boot-starter</artifactId>
    <version>1.0-RELEASE</version>
</dependency>
```
