package com.errordataredis.redisviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RedisviewsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisviewsApplication.class, args);
    }

}
