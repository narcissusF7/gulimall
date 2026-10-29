package com.atguigu.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果（谷粒商城风格）。
 * 约定：code=0 成功，非 0 为业务/系统异常码。
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R ok() {
        return new R();
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /** 默认 data 字段承载主体数据 */
    public R data(Object value) {
        super.put("data", value);
        return this;
    }

    public R data(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
