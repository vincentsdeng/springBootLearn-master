package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @auth snifferhu
 * @date 2018/3/30 21:22
 */
@Service
public class SimpleServiceImpl implements SimpleService{
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String add(){
        return restTemplate.getForEntity("http://simple/add?a=10&b=20", String.class).getBody();
    }

    public String fallback() {
        return "error";
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String home() {
        return restTemplate.getForEntity("http://simple/", String.class).getBody();
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public String greet() {
        return restTemplate.getForEntity("http://simple/greeting", String.class).getBody();
    }
}
