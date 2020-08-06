package com.cncs.test;

import com.cncs.dao.AccountDao;
import com.cncs.dao.impl.AccountDaoImpl;
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
        AccountDao accountDao = ac.getBean("accountDaoImpl", AccountDaoImpl.class);
        System.out.println(accountService);
        System.out.println(accountDao);
    }
}
