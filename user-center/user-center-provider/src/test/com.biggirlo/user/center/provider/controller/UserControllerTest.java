package com.biggirlo.user.center.provider.controller;

import com.alibaba.fastjson.JSONObject;
import com.biggirlo.security.api.entiry.CustomUser;
import com.biggirlo.user.center.api.model.user.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserControllerTest extends BaseControllerTest {



    public void testLogin(){

    }


    @Test
    public void test1() throws Exception{
       /* log.debug("测试get请求无参数......");

        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.get("/user/getUserDto").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
    }

    @Test
    public void test2() throws Exception{
        /*log.debug("测试get请求带参数......");

        String myName="debug-steadyjack-大圣";
        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.get("/user/getUserDtoByName").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).param("name",myName))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
    }


    @Test
    public void test3() throws Exception{
        log.debug("测试post请求带参数......");

        /*UserDto userDto=new UserDto();
        userDto.setUserName("debug--大圣");
        userDto.setAddress("北京大同");
        userDto.setSex("男的");
        log.debug("post 参数： {}",userDto);

        ObjectMapper objectMapper=new ObjectMapper();
        String requestJson=objectMapper.writeValueAsString(userDto);

        //mock进行模拟
        mvc.perform(MockMvcRequestBuilders.post("/user/saveUserDto").accept(MediaType.APPLICATION_JSON_UTF8_VALUE).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();*/
    }

    /**
     * 登录
     *
     * @return
     */
    @Test
    public void loginTest() throws Exception {
        log.debug("测试登录接口");

        User user=new User();
        user.setUserName("admin");
        user.setPassword("123456");
        log.debug("post 参数： {}",user);

        mvcPost(user,"/user/login");

    }

    /**
     * 通过用户获取一个id
     *
     * @param id
     * @return
     * @throws Exception
     */
    public User getUserById(String id) throws Exception {
        return null;
    }

    /**
     * 获取当前用户
     *
     * @return
     */
    public User getCurrentUser() {
        return null;
    }

    /**
     * 获取当前用户id
     *
     * @return
     */
    public String getCurrentUserId() {
        return null;
    }

    /**
     * 获取缓存数据
     *
     * @return
     */
    public CustomUser getCustomUser() {
        return null;
    }

    /**
     * 初始化mvc对象
     */
    @Override
    public void init() {
        initMvc(new UserController());
    }
}
