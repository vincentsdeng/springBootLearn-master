package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auth snifferhu
 * @date 2018/4/1 11:22
 */
@RestController
public class SimpleController implements SimpleService{
    @Autowired
    SimpleClient client;

    @Override
    public String home() {
        return client.home();
    }

    @Override
    public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return client.add(a,b);
    }

    @Override
    public String greet() {
        return client.greet();
    }
}
