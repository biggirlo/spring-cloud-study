package com.biggirlo.cloud.zuul.handler;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;

/**
 * 王雁欣
 * 2018/9/10
 */
public class ExceptionHandlerUtil {
    public static Result initExceptionHandler(Exception ex) {
        return Result.code(Code.SYSTEM_ERROR);
    }
}
