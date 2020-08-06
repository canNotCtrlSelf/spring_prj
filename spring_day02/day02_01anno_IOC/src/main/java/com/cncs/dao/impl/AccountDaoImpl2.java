package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public void save() {
        System.out.println("222存钱成功！");
    }
}
