package com.biggirlo.security.client.config;

import com.biggirlo.security.client.filter.TokenAuthenticationFilter;
import com.biggirlo.security.client.handler.RestAuthenticationAccessDeniedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * 王雁欣
 * 2018/5/15
 */
public abstract class BiggirloWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers(
                        this.getAntMatchers()
                ).permitAll() //全部放行的url
                .anyRequest().authenticated()// 任何请求,登录后可以访问
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()//解决跨域问题
                .and()
                .formLogin()
                .loginPage(getLoginPage())   //这里的处理方式为转发到一个指定403路径，在403路径返回一个json错误信息
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new RestAuthenticationAccessDeniedHandler())
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //关闭session创建
                .and()
                .addFilterBefore(getTokenGenericFilter(), UsernamePasswordAuthenticationFilter.class)
                //.httpSecurity.headers().cacheControl(); // 禁用缓存
                .csrf().disable(); //关闭CSRF ;
    }

    /**
     * 获取到放行的url
     * @return
     */
    public abstract String[] getAntMatchers();

    public abstract String getLoginPage();

    @Bean
    public TokenAuthenticationFilter getTokenGenericFilter() throws Exception {
        return new TokenAuthenticationFilter();
    }



}