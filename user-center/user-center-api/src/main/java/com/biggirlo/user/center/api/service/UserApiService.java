/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.api.service;

import com.biggirlo.core.http.response.Result;
import com.biggirlo.user.center.api.model.user.User;
import com.biggirlo.security.api.entiry.CustomUser;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author 王雁欣
 * create on 2018/3/12 22:12 
 */
public interface UserApiService {

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping(value = "/user/login")
    public Result login(@RequestBody User user);

    /**
     * 通过用户获取一个id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/user/{id}")
    User getUserById(String id) throws Exception;

    /**
     * 获取当前用户
     * @return
     */
    @GetMapping(value = "/currentUser")
    User getCurrentUser();

    /**
     * 获取当前用户id
     * @return
     */
    @GetMapping(value = "/currentUserId")
    String getCurrentUserId();


    /**
     * 获取缓存数据
     * @return
     */
    @GetMapping(value = "/customUser")
    CustomUser getCustomUser();

}
