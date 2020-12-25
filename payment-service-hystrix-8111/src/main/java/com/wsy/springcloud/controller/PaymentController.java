package com.wsy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@DefaultProperties(defaultFallback = "fallback")
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/{price}/{time}/{div}")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS, value = "5000"),
            @HystrixProperty(name = HystrixPropertiesManager.CIRCUIT_BREAKER_SLEEP_WINDOW_IN_MILLISECONDS, value = "20000")
    })
    public String pay(@PathVariable Integer price, @PathVariable long time, @PathVariable int div) {
        String result = "pay " + price + "$ success, port : " + port;
        System.out.println(result);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(price / div);
        return result;
    }

    public String fallback(Integer price, long time) {
        System.out.println("request parameter price : " + price + ", time : " + time);
        String result = "service fallback .." + Thread.currentThread();
        System.out.println(result);
        return "服务器忙, 请稍后再试!";
    }

    public String fallback(){
        return "服务器忙, 请稍后再试!";
    }


}