package com.cncs.service.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import com.cncs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(int accountId) {
        return accountDao.findById(accountId);
    }


    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public void transfer(String sourceName, String targetName) {
        System.out.println("transfer...");
        //2.根据名称查找source账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //3.根据名称查找target账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //4.source账户减少钱
        sourceAccount.setMoney(sourceAccount.getMoney() - 200f);
        //5.target账户增加钱
        targetAccount.setMoney(targetAccount.getMoney() + 200f);
        //更新source账户
        accountDao.updateAccount(sourceAccount);

//        int a = 1 / 0;

        //更新target账户
        accountDao.updateAccount(targetAccount);

    }
}
