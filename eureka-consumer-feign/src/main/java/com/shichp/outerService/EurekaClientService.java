package com.shichp.outerService;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by shichp on 2017-12-06.
 *
 * 使用@FeignClient注解来指定这个接口所要调用的服务名称，接口中定义的各个函数使用Spring MVC的注解就可以来绑定服务提供方的REST接口
 * 通过@FeignClient定义的接口来统一的声明需要依赖的微服务接口。
 */
@FeignClient("eureka-client")
public interface EurekaClientService {

    //绑定Eureka-client服务提供的接口
    @GetMapping("/dc")
    public String discoryclient();


}
