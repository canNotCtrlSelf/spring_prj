package com.cncs.service.impl;

import com.cncs.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存成功");
    }

}
