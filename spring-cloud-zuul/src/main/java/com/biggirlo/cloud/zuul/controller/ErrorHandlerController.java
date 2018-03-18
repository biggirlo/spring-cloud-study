/**
 * **********************************************************
 * 该项目仅用于学习
 * 有任何疑问或者建议请致邮件于 email:645614025@qq.com
 * **********************************************************
 * **********************************************************
 */
package com.biggirlo.cloud.zuul.controller;

/**
 *
 * @author 王雁欣
 * create on 2018/3/18 4:06 
 */
import com.biggirlo.core.http.response.Restult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class ErrorHandlerController implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * 自定义返回结果
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/error")
    public Restult error(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> errorAttributes = getErrorAttributes(request, true);
        Integer status=(Integer)errorAttributes.get("status");
        //String path=(String)errorAttributes.get("path");
        String messageFound=(String)errorAttributes.get("message");
        return new Restult(status,messageFound);
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
}
