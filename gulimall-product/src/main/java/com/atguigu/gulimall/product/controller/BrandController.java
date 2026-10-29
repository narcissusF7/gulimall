package com.atguigu.gulimall.product.controller;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.R;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.atguigu.gulimall.product.service.BrandService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 品牌管理（完整 CRUD 范式示例）。
 * 路径前缀统一为 product/brand，网关转发规则：/api/product/** -> /product/**
 */
@RestController
@RequestMapping("product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /** 健康检查 / 服务自述 */
    @GetMapping("/hello")
    public R hello() {
        return R.ok()
                .data("service", "gulimall-product")
                .data("msg", "谷粒商城-商品服务骨架已启动");
    }

    /** 列表（简化：返回全部；真实场景按 params 分页/条件查询） */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        IPage<BrandEntity> page = new Page<>(
                Long.parseLong(String.valueOf(params.getOrDefault("page", 1))),
                Long.parseLong(String.valueOf(params.getOrDefault("limit", 10))));
        QueryWrapper<BrandEntity> wrapper = new QueryWrapper<>();
        if (params.get("key") != null && !params.get("key").toString().isEmpty()) {
            wrapper.like("name", params.get("key").toString());
        }
        page = brandService.page(page, wrapper);
        R r = R.ok();
        r.putAll(new PageUtils(page));
        return r;
    }

    /** 详情 */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        BrandEntity brand = brandService.getById(id);
        return R.ok().data("brand", brand);
    }

    /** 新增 */
    @PostMapping
    public R save(@RequestBody BrandEntity brand) {
        brandService.save(brand);
        return R.ok();
    }

    /** 修改 */
    @PutMapping
    public R update(@RequestBody BrandEntity brand) {
        brandService.updateById(brand);
        return R.ok();
    }

    /** 删除（批量） */
    @DeleteMapping
    public R delete(@RequestBody Long[] ids) {
        brandService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }
}
