package com.zf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 2021-01-12 19:48
 */
@SpringBootApplication
@EnableEurekaClient
public class BackstageMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(BackstageMain8001.class,args);
    }
}
