package com.cncs.service.impl;

import com.cncs.dao.AccountDao;
import com.cncs.domain.Account;
import com.cncs.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
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
    public void transfer(String sourceName, String targetName, float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {

                System.out.println("transfer...");
                //2.根据名称查找source账户
                Account sourceAccount = accountDao.findAccountByName(sourceName);
                //3.根据名称查找target账户
                Account targetAccount = accountDao.findAccountByName(targetName);
                //4.source账户减少钱
                sourceAccount.setMoney(sourceAccount.getMoney() - money);
                //5.target账户增加钱
                targetAccount.setMoney(targetAccount.getMoney() + money);
                //更新source账户
                accountDao.updateAccount(sourceAccount);

//                int a = 1 / 0;

                //更新target账户
                accountDao.updateAccount(targetAccount);

                return null;
            }
        });


    }
}
