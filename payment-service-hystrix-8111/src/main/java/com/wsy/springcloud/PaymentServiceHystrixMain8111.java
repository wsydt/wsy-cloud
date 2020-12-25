package com.wsy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class PaymentServiceHystrixMain8111 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentServiceHystrixMain8111.class, args);
    }

}
