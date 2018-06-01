package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableCircuitBreaker
public class FeignApplication {

	@Autowired
	SimpleService service;

	@RequestMapping("/")
	public String hello() {
		return service.home();
	}

	@RequestMapping("/add")
	public String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
		return service.add(a,b);
	}

	@RequestMapping("/greeting")
	public String greet() {
		return service.greet();
	}

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

}

@FeignClient("simple")
interface Simple {
    @GetMapping(value = "/")
    String home();

    @GetMapping(value = "/add")
    String add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping(value = "/greeting")
    String greet();
}
