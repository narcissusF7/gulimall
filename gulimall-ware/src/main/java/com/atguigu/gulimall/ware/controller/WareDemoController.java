package com.atguigu.gulimall.ware.controller;

import com.atguigu.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 仓储服务示例接口。
 */
@RestController
@RequestMapping("ware/demo")
public class WareDemoController {

    @GetMapping("/hello")
    public R hello() {
        return R.ok().data("service", "gulimall-ware").data("msg", "仓储服务骨架已启动");
    }

    /** 示例：查询某 sku 库存（mock） */
    @GetMapping("/sku/stock")
    public R skuStock(@RequestParam Long skuId) {
        Map<String, Object> stock = new HashMap<>();
        stock.put("skuId", skuId);
        stock.put("stock", 100);
        stock.put("locked", 10);
        return R.ok().data("stock", stock);
    }
}
