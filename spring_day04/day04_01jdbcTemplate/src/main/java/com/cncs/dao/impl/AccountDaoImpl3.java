package com.cncs.dao.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 通过依赖注入数据
 */
public class AccountDaoImpl3 implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> findAll() {
        List<Account> accounts = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
        return accounts;
    }

    @Override
    public Account findById(int accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<>(Account.class), 9);
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
        jdbcTemplate.update("update account set name =?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void deleteAccount(int accountId) {
        jdbcTemplate.update("delete from account where id=?", accountId);
    }

    @Override
    public Long findCount() {
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        return count;
    }
}
