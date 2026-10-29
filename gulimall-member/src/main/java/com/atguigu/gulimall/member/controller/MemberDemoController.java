package com.atguigu.gulimall.member.controller;

import com.atguigu.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 会员服务示例接口。
 */
@RestController
@RequestMapping("member/demo")
public class MemberDemoController {

    @GetMapping("/hello")
    public R hello() {
        return R.ok().data("service", "gulimall-member").data("msg", "会员服务骨架已启动");
    }

    /** 示例：会员信息（mock） */
    @GetMapping("/info")
    public R info(@RequestParam(defaultValue = "1") Long id) {
        Map<String, Object> member = new HashMap<>();
        member.put("id", id);
        member.put("nickname", "谷粒用户" + id);
        member.put("level", "黄金会员");
        return R.ok().data("member", member);
    }
}
