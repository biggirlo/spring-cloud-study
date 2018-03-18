/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.cloud.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author 王雁欣
 * create on 2018/3/18 19:35 
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void insertString(String key , String value) {
        stringRedisTemplate.opsForValue().set("stringKey", "stringValue");
    }

    public String get(String key){
        return  stringRedisTemplate.opsForValue().get(key);
    }
}
