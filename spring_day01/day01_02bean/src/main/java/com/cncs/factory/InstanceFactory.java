package com.cncs.factory;

import com.cncs.service.AccountService;
import com.cncs.service.impl.AccountServiceImpl;

public class InstanceFactory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
