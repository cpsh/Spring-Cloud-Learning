package com.shichp.controller;

import com.shichp.outerService.EurekaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shichp on 2017-12-06.
 */
@RestController
public class EurekaFeignController {

    @Autowired
    EurekaClientService service;

    @GetMapping("/feign/consumer")
    public String feignClient(){
        return service.discoryclient();
    }

}
