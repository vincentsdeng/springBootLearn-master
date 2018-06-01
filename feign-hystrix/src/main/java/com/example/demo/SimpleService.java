package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auth snifferhu
 * @date 2018/3/31 10:44
 */
@Service
public class SimpleService {
    @Autowired
    Simple client;

    @HystrixCommand(fallbackMethod = "reliable")
    public String home() {
        return client.home();
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String add(Integer a, Integer b) {
        return client.add(a,b);
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String greet() {
        return client.greet();
    }

    public String reliable() {
        return "Cloud Native Java (O'Reilly)";
    }
}
