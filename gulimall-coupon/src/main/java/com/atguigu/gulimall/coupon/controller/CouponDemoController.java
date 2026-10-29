package com.atguigu.gulimall.coupon.controller;

import com.atguigu.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 优惠券服务示例接口。
 * 真实业务参考 product 服务的 BrandEntity/Dao/Service 三层范式自行扩展。
 */
@RestController
@RequestMapping("coupon/demo")
public class CouponDemoController {

    @GetMapping("/hello")
    public R hello() {
        return R.ok().data("service", "gulimall-coupon").data("msg", "营销服务骨架已启动");
    }

    /** 示例：返回当前用户可用优惠券（mock） */
    @GetMapping("/member/coupons")
    public R memberCoupons(Long memberId) {
        Map<String, Object> c1 = new HashMap<>();
        c1.put("id", 1L);
        c1.put("name", "满100减10");
        c1.put("amount", 10);
        Map<String, Object> c2 = new HashMap<>();
        c2.put("id", 2L);
        c2.put("name", "新人券");
        c2.put("amount", 20);
        List<Map<String, Object>> coupons = Arrays.asList(c1, c2);
        return R.ok().data("memberId", memberId).data("coupons", coupons);
    }
}
