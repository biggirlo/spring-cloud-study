/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.client.service;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;
import com.biggirlo.user.center.api.Service;
import com.biggirlo.user.center.api.model.user.User;
import com.biggirlo.user.center.api.service.UserApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

/**
 *   熔断器
 * @author 王雁欣
 * create on 2018/3/14 0:18 
 */

@FeignClient(name = Service.SERVICE_NAME, fallback = UserService.HystrixClientFallback.class)
public interface UserService extends UserApiService {
    @Component
    @Slf4j
    public static class HystrixClientFallback implements UserService {

        /**
         * 登录
         * @param user
         * @return
         */
        @Override
        public Result login(User user) {
            return Result.code(Code.LOGIN_FALSE);
        }

        @Override
        public User getUserById(String id) {
            log.info("获取id：".concat(id).concat("用户为空"));
            return null;
        }

        @Override
        public User getCurrentUser() {
            log.info("获取不到当前用户");
            return null;
        }

        @Override
        public String getCurrentUserId() {
            log.info("获取不到当前用户id");
            return null;
        }
    }

}
