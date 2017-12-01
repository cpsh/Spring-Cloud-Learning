# SpringCloud Consul 介绍
[Consul官方下载地址](https://www.consul.io/downloads.html)

# win Consul服务
- widnow系统：cmd窗口运行consul.exe，然后执行命令启动consul服务.
```bash
   consul agent -dev
```
- 在浏览窗口输入localhost:8500，打开web ui服务注册管理界面。

- 运行springboot程序，在application.properties文件中配置consul的服务地址信息

```java
spring.cloud.consul.host=localhost
spring.cloud.consul.port=8500
spring.cloud.consul.enabled=true
spring.cloud.consul.discovery.enabled=true
```

