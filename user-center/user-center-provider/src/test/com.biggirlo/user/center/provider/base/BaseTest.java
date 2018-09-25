package com.biggirlo.user.center.provider.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 王雁欣
 * 2018/9/25
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
@Slf4j
public abstract class BaseTest {

    @Before
    public abstract void init();

    @After
    public abstract void after();

}
