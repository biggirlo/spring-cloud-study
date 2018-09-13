package com.biggirlo.security.client.authority;

import org.springframework.security.core.GrantedAuthority;

/**
 * 王雁欣
 * 角色
 * 2018/5/22
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
