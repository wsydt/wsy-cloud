package com.wsy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route( p -> p
                        .path("/config/getInfo")
                        .filters(f -> f
                                .addRequestHeader("Hello", "World"))
                        .uri("http://localhost:8111"))
                .route(h -> h
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("myCmd")
                                        .setFallbackUri("forward:/fallback")))
                        .uri("http://localhost:8111"))
                .build();
    }

}
