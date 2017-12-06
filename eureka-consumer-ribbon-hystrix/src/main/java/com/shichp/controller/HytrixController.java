package com.shichp.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shichp on 2017-12-06.
 */
@RestController
public class HytrixController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/hystrix")
    public String hystrix() {
        return consumerService.consumer();
    }

    @Service
    class ConsumerService {

        @Autowired
        RestTemplate restTemplate;

        /*
        eureka-client服务的/dc请求实现逻辑进行线程sleep(5000L)，返回前延迟了5秒，
        而服务消费方触发了服务请求超时异常，服务消费者就通过HystrixCommand注解中指定的降级逻辑进行执行，因此该请求的结果返回了fallback。
        这样的机制，对自身服务起到了基础的保护，同时还为异常情况提供了自动的服务降级切换机制。

        在application.properties中配置hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds属性指定线程隔离的超时时间，触发fallbackMethod
         */

        // 在为具体执行逻辑的函数上增加@HystrixCommand注解来指定服务降级方法
        @HystrixCommand(fallbackMethod = "fallback")
        public String consumer() {
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback() {
            return "hytrix - fallbck ";
        }

    }

}
