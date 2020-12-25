package com.wsy.springcloud.controller;

import com.wsy.springcloud.service.IPaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;

@RestController
public class OrderController {

    @Resource
    private IPaymentService paymentService;

    @GetMapping("/order/{price}")
    public String order(@PathVariable Integer price) {
        String response = paymentService.pay(price);
        System.out.println("response : ------------" + response);
        return response;
    }
}
