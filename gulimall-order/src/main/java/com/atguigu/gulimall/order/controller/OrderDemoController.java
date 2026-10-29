package com.atguigu.gulimall.order.controller;

import com.atguigu.common.utils.R;
import com.atguigu.gulimall.order.feign.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务示例接口，演示本地接口与跨服务 Feign 调用。
 */
@RestController
@RequestMapping("order/demo")
public class OrderDemoController {

    @Autowired(required = false)
    private ProductFeignService productFeignService;

    @GetMapping("/hello")
    public R hello() {
        return R.ok().data("service", "gulimall-order").data("msg", "订单服务骨架已启动");
    }

    /** 示例：下单时远程获取商品品牌信息（需商品服务已注册） */
    @GetMapping("/with/product")
    public R withProduct(@RequestParam(defaultValue = "1") Long brandId) {
        if (productFeignService == null) {
            return R.error("Feign 客户端未加载，请确认商品服务已注册到 Nacos");
        }
        return R.ok().data("productResult", productFeignService.info(brandId));
    }
}
