package com.example.demo;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:42
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<SimpleClient>{
    @Override
    public SimpleClient create(Throwable throwable) {
        return new SimpleClient() {
            @Override
            public String home() {
                return "oops";
            }

            @Override
            public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
                return "oops";
            }

            @Override
            public String greet() {
                return "oops";
            }
        };
    }
}
