package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auth snifferhu
 * @date 2018/3/29 21:18
 */
@Configuration
public class RestTemplateConfig {

//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);//ms
//        factory.setConnectTimeout(15000);//ms
//        return factory;
//    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
