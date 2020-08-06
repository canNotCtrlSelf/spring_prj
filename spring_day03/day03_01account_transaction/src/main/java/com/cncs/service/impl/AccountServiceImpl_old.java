package com.cncs.service.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import com.cncs.service.AccountService;
import com.cncs.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_old implements AccountService {
    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(int accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        //1.开启事务
        transactionManager.startTransaction();
        try {
            accountDao.updateAccount(account);
        }catch (Exception e){
            transactionManager.rollback();
            throw new RuntimeException(e);
        }
        //7.提交事务
        transactionManager.commit();
    }

    @Override
    public void deleteAccount(int accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName) {
        //1.开启事务
        transactionManager.startTransaction();
        try {
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

            int a = 1/0;

            //更新target账户
            accountDao.updateAccount(targetAccount);
            transactionManager.commit();

        } catch (Exception e) {
            //6.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            transactionManager.release();
        }
    }
}
