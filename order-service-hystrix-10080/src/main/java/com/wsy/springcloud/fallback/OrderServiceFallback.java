package com.wsy.springcloud.fallback;

import com.wsy.springcloud.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService {

    @Override
    public String order(Integer price, Long time, Integer div) {
        return "支付服务调用失败";
    }
}
