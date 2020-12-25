package com.wsy.springcloud.service;

import com.wsy.springcloud.fallback.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PAYMENT-SERVICE-HYSTRIX", fallback = OrderServiceFallback.class)
public interface OrderService {

    @GetMapping("/pay/{price}/{time}/{div}")
    String order(@PathVariable Integer price, @PathVariable Long time, @PathVariable Integer div);

}
