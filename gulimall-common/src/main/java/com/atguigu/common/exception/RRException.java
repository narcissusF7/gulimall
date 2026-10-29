package com.atguigu.common.exception;

/**
 * 业务运行时异常，携带业务状态码。
 */
public class RRException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;

    public RRException(String msg) {
        super(msg);
        this.code = 500;
    }

    public RRException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
