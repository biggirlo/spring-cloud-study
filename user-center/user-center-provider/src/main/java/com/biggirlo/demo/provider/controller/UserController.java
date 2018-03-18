/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.provider.controller;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Restult;
import com.biggirlo.core.util.Validate;
import com.biggirlo.demo.api.model.user.User;
import com.biggirlo.demo.api.service.UserApiService;
import com.biggirlo.demo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @author 王雁欣
 * create on 2018/3/14 22:55 
 */
@RestController
public class UserController implements UserApiService{

    @Autowired
    private UserService userService;

    @Override
    public Restult login(User user) {
        if(Validate.isBlankStr(user.getUserName()) && Validate.isBlankStr(user.getPassword()))
            return new Restult(Code.LOGIN_ERROR_UN_EXIST_NAME_PASSWORD);
        return userService.login(user);
    }

    public User getUserById(@PathVariable("id")String id) throws Exception {
        return userService.findById(id);
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public String getCurrentId() {
        return null;
    }

}
