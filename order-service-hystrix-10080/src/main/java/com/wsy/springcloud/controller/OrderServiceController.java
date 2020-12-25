package com.wsy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.wsy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class OrderServiceController {

    @Resource
    private OrderService orderService;

//    @HystrixCommand(commandProperties = {@HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "1000")})
    @GetMapping("/order/{price}/{time}/{div}")
    public String order(@PathVariable Integer price, @PathVariable Long time, @PathVariable Integer div){
        System.out.println("order hystrix ....");
        return orderService.order(price, time, div);
    }



}
