package com.biggirlo.security.api.entiry;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 王雁欣
 * 2018/5/23
 *
 * 拓展UserDetails接口
 */
public interface CustomUserDetails extends UserDetails {

     void setUserId(String userId);

    String getUserId();

    /**
     * 修改登录时间
     * @param time
     */
    void setLoginTime(Long time);

    /**
     * 获取登录时间
     * @return
     */
    Long getLoginTime();

    String toJson();
}
