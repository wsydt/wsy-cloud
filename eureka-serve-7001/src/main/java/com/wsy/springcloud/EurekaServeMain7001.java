package com.wsy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServeMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServeMain7001.class, args);
    }
}
