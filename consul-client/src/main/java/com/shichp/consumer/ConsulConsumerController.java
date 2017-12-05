package com.shichp.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shichp on 2017-12-04.
 */
@RestController
public class ConsulConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    /*
    通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，这个服务实例的基本信息存储在ServiceInstance中，
     */
    @GetMapping("/consumer")
    public String loadConsumer() {
        ServiceInstance instance = loadBalancerClient.choose("consul-client");
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/add?a=1&b=3";
        System.out.println("consul-client - consumer - loadBalance , request url : " + url);
        return restTemplate.getForObject(url, String.class);
    }
}
