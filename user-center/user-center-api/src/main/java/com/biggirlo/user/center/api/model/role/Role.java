/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.api.model.role;

import com.biggirlo.core.model.BaseModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 23:49 
 */
@Data
public class Role extends BaseModel {

    private String roleCode;

    private String name;

    private List<String> users;

    @Override
    public Role init() {
        users = new ArrayList<>();
        return this;
    }
}
