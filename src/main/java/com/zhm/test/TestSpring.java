package com.zhm.test;

import com.zhm.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lzmtx
 * @date 2019/4/11 - 12:17
 */
public class TestSpring {
    @Test
    public void run1() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.findAll();
    }
}
