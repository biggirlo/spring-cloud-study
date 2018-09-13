package com.biggirlo.security.client.controller;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;


/**
 * 王雁欣
 * 该控制器用来处理部分返回异常信息，将错误信息包装成rest接口返回信息
 * 包括对spring Security 未登录返回信息的处理
 * 2018/5/16
 */
public class ZuulErrorController extends AbstractErrorController {


    /**
     * 未登录
     *
     * @return
     */
    @Override
    public Result errorUnloginMessage() {
        return Result.code(Code.UN_LOGIN);
    }
}
