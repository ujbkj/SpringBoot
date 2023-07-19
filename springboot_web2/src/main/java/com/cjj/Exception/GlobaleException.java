package com.cjj.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 */
@Slf4j
@ControllerAdvice
public class GlobaleException {
    /**
     * 处理数学异常
     * @return
     */
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class}) //处理异常
    public String handleArithException(Exception ex ){
        log.error("handleArithException异常是{}",ex);
        return "login"; //返回的视图地址
    }
}
