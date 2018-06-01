package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @auth snifferhu
 * @date 2018/3/15 22:04
 */
@RestController
@Transactional
public class SayHelloApplication {
    private static Logger logger = LoggerFactory.getLogger(SayHelloApplication.class);


    @RequestMapping(value = "/greeting")
    public String greet() {
        logger.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }


}
