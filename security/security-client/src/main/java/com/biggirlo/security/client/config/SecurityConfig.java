package com.biggirlo.security.client.config;

/**
 * 王雁欣
 * 2018/5/22
 * 权限相关的配置
 */
public abstract class SecurityConfig {

    /**
     * 登录的redis头部
     */
    public String TOKEN_KEY_NAME = getTokenKeyName();

    public static final String HTTP_TOKEN_KEY_NAME = "token";

    public static final String REDIS_SECURITY_TOKEN_KEY_NAME = "SECURITY_";

    /**
     * 登录超时的时间
     */
    public final static Long LOGIN_OUT_TIME = 24 * 60 * 60L ;


    public abstract String getTokenKeyName();
}
