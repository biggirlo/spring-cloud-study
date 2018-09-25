package com.biggirlo.user.center.provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.biggirlo.user.center.provider.base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 王雁欣
 * 2018/9/25
 */
@Slf4j
public abstract class BaseControllerTest extends BaseTest{

    private MockMvc mvc;

    /**
     * 初始化mvc对象
     * @param controllers
     */
    public void initMvc(Object controllers){
        mvc= MockMvcBuilders.standaloneSetup(controllers).build();
    }

    /**
     * 模拟mvc get请求
     */
    protected void mvcGet() {

    }

    /**
     * 模拟mvc post请求
     *
     */
    protected void mvcPost(Object obj,String url) throws Exception {
        String requestJson= JSONObject.toJSONString(obj);
        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.post(url).accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


    @Override
    public void after() {
        System.out.println("测试结束-----------------");
    }
}
