package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:20
 */

@FeignClient(value = "simple",fallbackFactory = HystrixClientFallbackFactory.class)
public interface SimpleClient extends SimpleService {

}
