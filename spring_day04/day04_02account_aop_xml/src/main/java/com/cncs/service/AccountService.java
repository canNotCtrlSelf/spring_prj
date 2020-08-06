package com.cncs.service;

import com.cncs.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    List<Account> findAll();

    Account findById(int accountId);


    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(int accountId);

    void transfer(String sourceName, String targetName);
}
