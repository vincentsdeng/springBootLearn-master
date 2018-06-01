package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:21
 */
public interface SimpleService {
    @GetMapping(value = "/")
    String home();

    @GetMapping(value = "/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping(value = "/greeting")
    String greet();
}
