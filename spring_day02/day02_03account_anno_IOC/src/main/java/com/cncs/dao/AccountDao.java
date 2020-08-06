package com.cncs.dao;

import com.cncs.domain.Account;

import java.util.List;

/**
 * 账户持久层的接口
 */
public interface AccountDao {
    List<Account> findAll();

    Account findById(int accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int accountId);
}
