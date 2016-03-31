package com.tiger.learn.mybatis.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
@Configuration
@ComponentScan(basePackages={"com.tiger.learn.mybatis.sample"})
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}