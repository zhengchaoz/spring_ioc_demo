package com.jt.aop;

import com.jt.vo.SysResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 郑超
 * @create 2021/5/14
 */
@RestControllerAdvice// 定义全局异常处理，拦截controller层，返回json
public class AOPException {

    @ExceptionHandler(RuntimeException.class)
    public Object exception(Exception e) {
        e.printStackTrace();
        return SysResult.fail();
    }

}
