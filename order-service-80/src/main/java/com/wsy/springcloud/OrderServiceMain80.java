package com.wsy.springcloud;

import loadBalance.MyLoadBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "PAYMENT-SERVICE", configuration = MyLoadBalance.class)
public class OrderServiceMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceMain80.class, args);
    }

}
