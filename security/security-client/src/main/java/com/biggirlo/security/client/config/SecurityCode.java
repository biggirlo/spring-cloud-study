package com.biggirlo.security.client.config;


import com.biggirlo.core.http.response.AbstractCode;

/**
 * 邮箱645614025@qq.com
 * 王雁欣
 * 2018/9/13
 */
public enum SecurityCode implements AbstractCode {
    SECURITY_HEADER_NULL(20001L,"权限拦截头部为空"),
    SECURITY_UN_LOGIN(20002L,"用户未登录"),
    SECURITY_USER_ID_UN_EXIT(20003L,"用户id不存在")
    ;

    private long code;
    private String msg;

    private SecurityCode(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public long value() {
        return this.code;
    }

    @Override
    public String msg() {
        return this.msg;
    }
}
