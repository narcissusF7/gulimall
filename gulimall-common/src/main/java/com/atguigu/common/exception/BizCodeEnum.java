package com.atguigu.common.exception;

/**
 * 业务状态码枚举（谷粒商城约定：10xxx 为系统/通用异常，11xxx 起按业务域划分）。
 */
public enum BizCodeEnum {

    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "参数格式校验失败"),
    TOO_MANY_REQUEST(10002, "请求流量过大，请稍后再试"),
    PRODUCT_UP_EXCEPTION(11000, "商品上架异常"),
    USERNAME_PASSWORD_INVALID(15001, "用户名或密码错误");

    private final int code;
    private final String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
