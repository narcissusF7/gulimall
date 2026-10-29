package com.atguigu.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

/**
 * 将 MyBatis-Plus 分页结果封装为前端友好的 Map（page/limit/totalCount/totalPage/list）。
 */
public class PageUtils extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public PageUtils(IPage<?> page) {
        put("page", page.getCurrent());
        put("limit", page.getSize());
        put("totalCount", page.getTotal());
        put("totalPage", page.getPages());
        put("list", page.getRecords());
    }

    public PageUtils(Map<String, Object> params, long totalCount, Object list) {
        put("page", params.getOrDefault("page", 1));
        put("limit", params.getOrDefault("limit", 10));
        put("totalCount", totalCount);
        put("list", list);
    }
}
