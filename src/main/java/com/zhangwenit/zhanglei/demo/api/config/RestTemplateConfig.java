package com.zhangwenit.zhanglei.demo.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/14 6:41 PM
 * @Version 1.0
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}