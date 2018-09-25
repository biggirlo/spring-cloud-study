/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.provider.controller;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;
import com.biggirlo.user.center.api.model.user.User;
import com.biggirlo.user.center.api.service.UserApiService;
import com.biggirlo.user.center.provider.service.UserService;
import com.biggirlo.security.api.entiry.CustomUser;
import com.biggirlo.security.client.service.SecurityUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author 王雁欣
 * create on 2018/3/14 22:55 
 */
@RestController
public class UserController implements UserApiService {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityUserService securityUserService;

    @Override
    public Result login(@RequestBody User user) {
        if(StringUtils.isBlank(user.getUserName()) && StringUtils.isBlank(user.getPassword())){
            return Result.code(Code.LOGIN_ERROR_UN_EXIST_NAME_PASSWORD);
        }
        return userService.login(user);
    }

    @Override
    public User getUserById(@PathVariable("id")String id) throws Exception {
        return userService.findById(id);
    }

    @Override
    public User getCurrentUser() {
        return userService.findById(securityUserService.getLoginUserDetailId());
    }

    /**
     * 获取当前登录id
     * @return
     */
    @Override
    public String getCurrentUserId() {
        return securityUserService.getLoginUserDetailId();
    }

    /**
     * 获取缓存数据
     *
     * @return
     */
    @Override
    public CustomUser getCustomUser() {
        return securityUserService.getLoginUserDetail();
    }

}
