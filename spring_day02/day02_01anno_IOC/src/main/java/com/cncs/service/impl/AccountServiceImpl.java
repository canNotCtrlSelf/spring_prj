package com.cncs.service.impl;

import com.cncs.dao.AccountDao;
import com.cncs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
@Scope("prototype")
public class AccountServiceImpl implements AccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name = "accountDao1")
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化了。。。");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁了。。。");
    }
}
