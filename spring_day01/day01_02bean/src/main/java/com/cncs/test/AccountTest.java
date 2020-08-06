package com.cncs.test;

import com.cncs.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    public static void main(String[] args) {
        //获取spring核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取service对象
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        //获取dao对象
        System.out.println(accountService);
    }
}
