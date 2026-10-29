package com.atguigu.gulimall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 订单服务：演示通过 OpenFeign 远程调用商品服务。
 * 调用方/被调用方都需注册到同一 Nacos。
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.atguigu.gulimall.order.feign")
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu.gulimall.order", "com.atguigu.common"})
public class GulimallOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallOrderApplication.class, args);
    }
}
