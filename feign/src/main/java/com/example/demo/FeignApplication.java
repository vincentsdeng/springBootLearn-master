package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}


	static class HystrixClientFallback implements SimpleClient {

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
	}

}


