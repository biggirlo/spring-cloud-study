/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.api.model.user;

import com.biggirlo.core.model.BaseModel;
import com.biggirlo.demo.api.model.group.Group;
import com.biggirlo.demo.api.model.role.Role;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 *
 * @author 王雁欣
 * create on 2018/3/13 0:47 
 */
@Document(collection = "user")
public class User extends BaseModel{

    private String userName;

    private String nickName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
