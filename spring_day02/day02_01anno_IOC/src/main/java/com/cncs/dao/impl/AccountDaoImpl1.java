package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl1 implements AccountDao {
    @Override
    public void save() {
        System.out.println("111存钱成功！");
    }
}
