/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.cloud.zuul.filter;

/**
 *
 * @author 王雁欣
 * create on 2018/3/16 23:02 
 */
import com.biggirlo.cloud.redis.config.RedisClient;
import com.biggirlo.demo.client.service.UserService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessTokenFilter extends ZuulFilter {

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private UserService userService;

    @Override
    public String filterType() {
        return "pre";//前置过滤器
    }

    @Override
    public int filterOrder() {
        return 0;//优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;//是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (redisClient.get(token) != null ) {//暂时简单化测试
            ctx.setSendZuulResponse(true);// 对该请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);// 设值，可以在多个过滤器时使用
            return null;
        } else {
            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
            ctx.setResponseStatusCode(403);// 返回错误码
            ctx.setResponseBody("{\"result\":\"Request illegal!the token is null\"}");// 返回错误内容
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
