/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.api.model.user;

import com.biggirlo.core.model.BaseModel;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 0:47 
 */
@Data
@Document(collection = "user")
public class User extends BaseModel{

    private String userName;

    private String nickName;

    private String password;

    @Override
    public User init() {
        return this;
    }
}
