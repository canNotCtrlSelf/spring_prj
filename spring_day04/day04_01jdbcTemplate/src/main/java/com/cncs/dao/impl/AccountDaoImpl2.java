package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * 使用Spring提供的JdbcDaoSupport
 */
public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {

    @Override
    public List<Account> findAll() {
        List<Account> accounts = getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public Account findById(int accountId) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 9);
        if (accounts.isEmpty()) {
            System.out.println("该账户不存在");
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void insertAccunt(Account account) {

    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name =?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccount(int accountId) {
        getJdbcTemplate().update("delete from account where id=?", accountId);
    }

    @Override
    public Long findCount() {
        Long count = getJdbcTemplate().queryForObject("select count(*) from account", Long.class);
        return count;
    }
}
