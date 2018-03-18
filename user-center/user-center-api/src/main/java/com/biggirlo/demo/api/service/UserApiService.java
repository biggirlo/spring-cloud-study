/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.api.service;

import com.biggirlo.core.http.response.Restult;
import com.biggirlo.demo.api.model.user.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public Restult login(@RequestBody User user);

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    User getUserById(String id) throws Exception;

    User getCurrentUser();

    String getCurrentId();

}
