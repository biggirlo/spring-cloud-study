package com.biggirlo.security.api.entiry;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 王雁欣
 * 2018/5/16
 */
@Data
public class CustomUser implements CustomUserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


    //目前这里置空
    private String password;

    private String username;

    private String userId;

    private Long loginTime;

    @Override
    public String toJson() {
        return JSONObject.toJSONString(this);
    }
}
