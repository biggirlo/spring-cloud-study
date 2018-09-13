package com.biggirlo.security.client.service;

import com.alibaba.fastjson.JSONObject;
import com.biggirlo.cloud.redis.config.RedisClient;
import com.biggirlo.core.exception.BaseCodeException;
import com.biggirlo.security.api.entiry.CustomUser;
import com.biggirlo.security.api.entiry.CustomUserDetails;
import com.biggirlo.security.client.config.SecurityCode;
import com.biggirlo.security.client.config.SecurityConfig;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 王雁欣
 * 2018/5/22
 */
@Service
public class SecurityUserServiceImpl implements SecurityUserService {

    @Resource
    private RedisClient redisClient;

    @Autowired
    HttpServletRequest request;

    /**
     * 是否登录
     *
     * @return
     */
    @Override
    public boolean isLogin() {
        String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        if(authToken == null){
            return false;
        }
        String userJson = redisClient.get(SecurityConfig.REDIS_SECURITY_TOKEN_KEY_NAME.concat(authToken));
        if(userJson == null){
            return false;
        }
        //刷新token
        redisClient.set(SecurityConfig.REDIS_SECURITY_TOKEN_KEY_NAME.concat(authToken),userJson,SecurityConfig.LOGIN_OUT_TIME);

        return true;
    }

    /**
     * 获取登录用户信息在json 串
     *
     * @return
     */
    @Override
    public String getLoginUserJson() {
        String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        return this.getLoginUserJson(authToken);
    }

    /**
     * 获取登录用户信息在json 串
     *
     * @return
     */
    private String getLoginUserJson(String token) {
        if(token == null){
            //token请求头为空
            throw new BaseCodeException(SecurityCode.SECURITY_HEADER_NULL);
        }
        String userJson = redisClient.get(SecurityConfig.REDIS_SECURITY_TOKEN_KEY_NAME.concat(token));
        if(userJson == null){
            throw new BaseCodeException(SecurityCode.SECURITY_UN_LOGIN);
        }
        return  userJson ;
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    @Override
    public CustomUser getLoginUserDetail() {
        //
        String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        return this.getLoginUserDetail(authToken);
    }

    /**
     * 获取登录用户信息
     *
     * @return
     */
    private CustomUser getLoginUserDetail(String token) {
        //
        String userJson = this.getLoginUserJson(token);
        if(userJson != null){
            CustomUser customUser = JSONObject.parseObject(userJson,CustomUser.class);
            return customUser;
        }else {
            //用户未登录
            throw new BaseCodeException(SecurityCode.SECURITY_UN_LOGIN);
        }
    }

    /**
     * 获取登录用户的id
     *
     * @return
     */
    @Override
    public String getLoginUserDetailId() {
        String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        return getLoginUserDetail(authToken).getUserId();
    }

    /**
     * 登录
     *
     * @param userId   用户id
     * @param userName 用户名
     * @return
     */
    @Override
    public String login(String userId, String userName) {
        CustomUser customUser = new CustomUser();
        customUser.setUserId(userId);
        customUser.setUsername(userName);
        return login(customUser);
    }

    /**
     * 登录
     *
     * @param userId   用户id
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public String login(String userId, String userName, String password) {
        CustomUser customUser = new CustomUser();
        customUser.setUserId(userId);
        customUser.setUsername(userName);
        customUser.setPassword(password);
        return login(customUser);
    }

    /**
     * 登录
     *
     * @param cutonUserDetails
     */
    @Override
    public String login(CustomUserDetails cutonUserDetails) {

        if(StringUtils.isBlank(cutonUserDetails.getUserId())){
            throw new BaseCodeException(SecurityCode.SECURITY_USER_ID_UN_EXIT);
        }
        //32位uuid
        String token = UUID.randomUUID().toString().replaceAll("-","");
        cutonUserDetails.setLoginTime(System.currentTimeMillis());
        redisClient.set(SecurityConfig.REDIS_SECURITY_TOKEN_KEY_NAME.concat(token),cutonUserDetails.toJson(),SecurityConfig.LOGIN_OUT_TIME);

        return token;
    }

    /**
     * 退出登录
     *
     */
    @Override
    public void loginOut(){
        String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        if(authToken != null){
            redisClient.delete(SecurityConfig.REDIS_SECURITY_TOKEN_KEY_NAME.concat(authToken));
        }
    }
}
