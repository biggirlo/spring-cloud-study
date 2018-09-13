package com.biggirlo.cloud.zuul.handler;

import com.biggirlo.core.exception.AbstractRuntimeException;
import com.biggirlo.core.http.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * 王雁欣
 * 异常全局扫描
 * 2018/6/21
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result handleSQLException(HttpServletRequest request, Exception ex) {
        Result result ;
        if(ex instanceof AbstractRuntimeException){
            long exCode = ((AbstractRuntimeException )ex).getExceptionCode();
            result = new Result(exCode ,ex.getMessage() );
        }else{
            result = ExceptionHandlerUtil.initExceptionHandler(ex);
        }
        return result;
    }

}
