package com.cncs.factory;

import com.cncs.service.AccountService;
import com.cncs.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
