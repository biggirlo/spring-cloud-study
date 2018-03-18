/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.client.service;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Restult;
import com.biggirlo.demo.api.Service;
import com.biggirlo.demo.api.model.user.User;
import com.biggirlo.demo.api.service.UserApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

/**
 *   熔断器
 * @author 王雁欣
 * create on 2018/3/14 0:18 
 */

@FeignClient(name = Service.SERVICE_NAME, fallback = UserService.HystrixClientFallback.class)
public interface UserService extends UserApiService{
    @Component
    public static class HystrixClientFallback implements UserService {
        private static final Logger LOG = LoggerFactory.getLogger(HystrixClientFallback.class);

        /**
         * 登录
         * @param user
         * @return
         */
        @Override
        public Restult login(User user) {
            return new Restult(Code.LOGIN_FALSE);
        }

        @Override
        public User getUserById(String id) {
            return null;
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

}
