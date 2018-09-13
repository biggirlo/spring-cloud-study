package com.biggirlo.security.client.filter;

import com.biggirlo.security.api.entiry.CustomUser;
import com.biggirlo.security.client.config.SecurityConfig;
import com.biggirlo.security.client.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 王雁欣
 * 2018/5/16
 */
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private SecurityUserService securityUserService;

    /**
     * 校验
     * @param request
     * @param response
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {
        final String authToken = request.getHeader(SecurityConfig.HTTP_TOKEN_KEY_NAME);
        if (authToken != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (securityUserService.isLogin()) {
                CustomUser userDetails = securityUserService.getLoginUserDetail();
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(
                        request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }
}
