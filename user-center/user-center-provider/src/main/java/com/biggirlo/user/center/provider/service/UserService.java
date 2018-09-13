/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.user.center.provider.service;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;
import com.biggirlo.core.service.BaseServiceImpl;
import com.biggirlo.core.util.StringUtil;
import com.biggirlo.user.center.api.model.user.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * 用户服务类
 * @author 王雁欣
 * create on 2018/3/14 23:00 
 */
@Service
public class UserService extends BaseServiceImpl<User> {

    /**
     * 登录
     * @param from
     * @return
     */
    public Result login(User from) {
        String psdMd5 = StringUtil.MD5(from.getPassword());
        User user = getUserByUserNameAndUserMd5Psw(from.getUserName(),psdMd5);
        if(user == null){
            return Result.code(Code.LOGIN_ERROR_FALIE_NAME_PASSWORD);
        }
        else{
            String token = UUID.randomUUID().toString().replaceAll("-","");
            return Result.success().data(user);
        }

    }

    /**
     * 通过账号加密密码获取
     * @param userName
     * @param pswMd5
     * @return
     */
    public User getUserByUserNameAndUserMd5Psw(String userName, String pswMd5){
        Query query = new Query(Criteria.where("userName").is(userName).and("password").is(pswMd5));
        return findOne(query);
    }
}
