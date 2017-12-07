package com.shichp.fallback;

import com.shichp.outerService.EurekaClientService;
import org.springframework.stereotype.Component;

/**
 * Created by shichp on 2017-12-07.
 *
 * Feign调用外部服务失败进行熔断hystrix处理
 */
@Component
public class FeignClientHystrix  implements EurekaClientService{

    @Override
    public String discoryclient() {
        return "feign-client -hystrix == fallback : result = -1";
    }
}
