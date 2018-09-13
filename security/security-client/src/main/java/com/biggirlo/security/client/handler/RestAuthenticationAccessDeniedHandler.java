package com.biggirlo.security.client.handler;

import com.biggirlo.core.http.response.Code;
import com.biggirlo.core.http.response.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 王雁欣
 * 无权限访问异常
 * 2018/5/15
 */
@Component
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        writer.println(Result.code(Code.FORBIDDEN));
    }

}