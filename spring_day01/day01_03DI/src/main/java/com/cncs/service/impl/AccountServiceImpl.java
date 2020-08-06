package com.cncs.service.impl;

import com.cncs.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    private String name;
    private int age;
    private Date date;

    public AccountServiceImpl(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    @Override
    public void save() {
        System.out.println("name:" + name + ",age:" + age + ",date:" + date);
    }
}
