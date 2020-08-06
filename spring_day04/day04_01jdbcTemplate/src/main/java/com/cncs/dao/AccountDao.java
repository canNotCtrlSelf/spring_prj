package com.cncs.dao;

import com.cncs.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    Account findById(int accountId);

    void insertAccunt(Account account);

    void updateAccount(Account account);

    void deleteAccount(int accountId);

    Long findCount();
}
