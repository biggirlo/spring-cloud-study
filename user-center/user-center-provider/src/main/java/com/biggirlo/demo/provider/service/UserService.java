/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.demo.provider.service;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Restult;
import com.biggirlo.core.http.response.RestultDate;
import com.biggirlo.core.service.BaseService;
import com.biggirlo.core.service.BaseServiceImpl;
import com.biggirlo.core.util.StringUtil;
import com.biggirlo.demo.api.model.user.User;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 *
 * @author 王雁欣
 * create on 2018/3/14 23:00 
 */
@Service
public class UserService extends BaseServiceImpl<User> {

    public Restult login(User from) {
        String psdMd5 = StringUtil.MD5(from.getPassword());
        User user = getUserByUserNameAndUserPsw(from.getUserName(),psdMd5);
        if(user == null)
            return new Restult(Code.LOGIN_ERROR_FALIE_NAME_PASSWORD);
        else{
            String token = UUID.randomUUID().toString().replaceAll("-","");
            return new RestultDate(Code.SUCCESS,user);
        }

    }

    public User getUserByUserNameAndUserPsw(String userName, String pswMd5){
        Query query = new Query(Criteria.where("userName").is(userName).and("password").is(pswMd5));
        return findOne(query);
    }
}
