package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonEurekaApplication.class, args);
	}
}
