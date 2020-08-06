package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public List<Account> findAll() {
        try {
            return getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account findById(int accountId) {
        try {
            return getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), accountId).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void updateAccount(Account account) {
        try {
            getJdbcTemplate().update("update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<>(Account.class), accountName);
            if (accounts.size() == 1){
                return accounts.get(0);
            }else{
                throw new RuntimeException("查询结果不合法");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
