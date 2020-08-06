package com.cncs.factory;

import com.cncs.service.AccountService;
import com.cncs.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {

    private AccountService accountService = null;

    private TransactionManager transactionManager = null;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public AccountService getAccountService() {
        AccountService accountService1 =(AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnVal = null;
                //1.开启事务
                transactionManager.startTransaction();
                try {
                    returnVal = method.invoke(accountService, args);
                    transactionManager.commit();
                } catch (Exception e) {
                    //6.事务回滚
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                }finally {
                    transactionManager.release();
                }
                return returnVal;
            }
        });
        return accountService1;
    }
}
