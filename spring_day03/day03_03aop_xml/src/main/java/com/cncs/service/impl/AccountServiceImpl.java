package com.cncs.service.impl;

import com.cncs.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存成功");
    }

    @Override
    public void update(int money) {
        System.out.println("更新了："+money);
    }

    @Override
    public boolean delete() {
        System.out.println("执行了删除");
        return false;
    }

    @Override
    public String find(int id) {
        System.out.println("执行了查找"+id);
        return "account@zhangsan";
    }
}
