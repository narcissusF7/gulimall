package com.atguigu.common.exception;

import com.atguigu.common.utils.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理。basePackages 覆盖所有微服务的 controller 包。
 */
@RestControllerAdvice(basePackages = "com.atguigu.gulimall")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = RRException.class)
    public R handleRRException(RRException e) {
        return R.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(), BizCodeEnum.UNKNOWN_EXCEPTION.getMsg());
    }
}
