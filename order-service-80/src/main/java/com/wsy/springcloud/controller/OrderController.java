package com.wsy.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String paymentUrl = "http://PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/order/{price}")
    public String order(@PathVariable Integer price) {
        String response = restTemplate.getForObject(paymentUrl + "/pay/" + price, String.class);
        System.out.println("response : ------------" + response);
        return response;
    }
}
