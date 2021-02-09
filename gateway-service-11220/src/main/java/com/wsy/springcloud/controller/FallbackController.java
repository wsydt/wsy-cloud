package com.wsy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/fallback")
    public String hystrixFallback1() {
        return "gateway fallback port : " + port;
    }



}
