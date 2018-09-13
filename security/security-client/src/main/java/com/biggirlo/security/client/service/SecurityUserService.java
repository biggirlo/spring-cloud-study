package com.biggirlo.security.client.service;


import com.biggirlo.security.api.entiry.CustomUser;
import com.biggirlo.security.api.entiry.CustomUserDetails;

/**
 * 自定义获取用户service类
 * 王雁欣
 * 2018/5/16
 */
public interface SecurityUserService {


    /**
     * 是否登录
     * @return
     */
    boolean isLogin();

    /**
     * 获取登录用户信息在json 串
     * @return
     */
    String  getLoginUserJson();

    /**
     * 获取登录用户信息
     * @return
     */
    CustomUser getLoginUserDetail();

    /**
     * 获取登录用户在id
     * @return
     */
    String getLoginUserDetailId();


    /**
     * 登录
     * @param userDetails
     */
    String  login(CustomUserDetails userDetails);

    /**
     * 登录
     * @param userId 用户id
     * @param userName 用户名
     * @return
     */
    String login(String userId, String userName);

    /**
     * 登录
     * @param userId 用户id
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    String login(String userId, String userName, String password);

    /**
     * 退出登录
     */
    public void loginOut();
}
