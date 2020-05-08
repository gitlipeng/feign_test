package com.movitech.product.project.remote.mc;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class McFeignClientFallbackFactory implements FallbackFactory<McFeignService> {
    @Override
    public McFeignService create(Throwable throwable) {
        throwable.printStackTrace();
        return new McFeignClientFallback();
    }
}
