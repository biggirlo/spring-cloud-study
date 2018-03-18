/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.api.model.role;

import com.biggirlo.core.model.BaseModel;

import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 23:49 
 */
public class Role extends BaseModel {

    private String roleCode;

    private String name;

    private List<String> users;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
