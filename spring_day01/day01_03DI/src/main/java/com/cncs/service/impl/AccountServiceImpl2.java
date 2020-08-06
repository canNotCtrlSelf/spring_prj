package com.cncs.service.impl;

import com.cncs.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {
    private String name;
    private int age;
    private Date date;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public void save() {
        System.out.println("name:" + name + ",age:" + age + ",date:" + date);
    }
}
