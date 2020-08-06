package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("存钱成功！");
    }
}
