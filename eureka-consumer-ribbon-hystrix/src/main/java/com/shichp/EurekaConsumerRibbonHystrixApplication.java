package com.shichp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//应用主类中使用@EnableCircuitBreaker或@EnableHystrix注解开启Hystrix的使用
@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerRibbonHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
	}
}
