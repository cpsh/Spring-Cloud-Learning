package com.shichp.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shichp on 2017-11-30.
 */

@RestController
public class DiscoveryClientController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String discoryclient(){
        String services = "services： " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
