package com.cncs.test;

import com.cncs.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    public static void main(String[] args) {
        //获取spring核心容器
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //获取service对象
        AccountService accountService = (AccountService) ac.getBean("accountServiceImpl");
        AccountService accountService2 = (AccountService) ac.getBean("accountServiceImpl");
        System.out.println(accountService==accountService2);
        ac.close();
        //获取dao对象
//        AccountDao accountDao = ac.getBean("accountDao",AccountDao.class);
//        System.out.println(accountService);
//        accountService.save();
    }
}
