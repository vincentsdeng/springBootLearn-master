package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auth snifferhu
 * @date 2018-03-30 14:02:55
 */
@RestController
public class UserApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name", defaultValue = "Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://simple/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }

    @GetMapping(value = "/add")
    public String add() {
        return restTemplate.getForEntity("http://simple/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping("/")
    public String hello() {
        return this.restTemplate.getForObject("http://simple/", String.class);
    }
}