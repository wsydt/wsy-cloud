package com.wsy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/{price}")
    public String pay(@PathVariable Integer price) {
        String result = "pay " + price + "$ success, port : " + port;
        System.out.println(result);
        return result;
    }

}
