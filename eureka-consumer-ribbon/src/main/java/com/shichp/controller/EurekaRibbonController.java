package com.shichp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shichp on 2017-12-05.
 */
@RestController
public class EurekaRibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/ribbon")
    public String ribbonClient() {
        /*
        请求的host位置并没有使用一个具体的IP地址和端口的形式，而是采用了服务名的方式组成.
        Spring Cloud Ribbon有一个拦截器，它能够在这里进行实际调用的时候，自动的去选取服务实例，
        并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用。
         */

        /*
        实例发生了故障而该情况还没有被服务治理机制及时的发现和摘除，这时候客户端访问该节点的时候自然会失败。
        为了构建更为健壮的应用系统，我们希望当请求失败的时候能够有一定策略的重试机制，而不是直接返回失败
         */
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

}
