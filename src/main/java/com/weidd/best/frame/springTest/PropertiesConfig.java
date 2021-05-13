package com.weidd.best.spring.springtest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-11 17:10
 **/
@Component
@PropertySource("classpath:env.properties")
public class PropertiesConfig {

    @Value("${test.ip}")
    private String ip;

    @Bean
    public  PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getIp() {
        return ip;
    }
}
