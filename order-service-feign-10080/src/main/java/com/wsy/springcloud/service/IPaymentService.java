package com.wsy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PAYMENT-SERVICE")
public interface IPaymentService {

    @GetMapping("/pay/{price}")
    String pay(@PathVariable Integer price);

}
