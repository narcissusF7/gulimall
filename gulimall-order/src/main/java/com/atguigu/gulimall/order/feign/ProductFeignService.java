package com.atguigu.gulimall.order.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 远程调用商品服务。name 对应商品服务在 Nacos 注册的应用名。
 */
@FeignClient("gulimall-product")
public interface ProductFeignService {

    @GetMapping("/product/brand/info/{id}")
    R info(@PathVariable("id") Long id);
}
