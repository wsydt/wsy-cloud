package com.wsy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${order.info}")
    private String info;

    @GetMapping("config/getInfo")
    public String getConfigInfo(HttpServletRequest request){
        System.out.println(info);
        System.out.println(request);
        return info;
    }

}
