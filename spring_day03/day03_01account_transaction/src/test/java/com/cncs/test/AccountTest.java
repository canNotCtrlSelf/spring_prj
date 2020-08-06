package com.cncs.test;

import com.cncs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class AccountTest {

    @Autowired
    @Qualifier("factoryAccountService")
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("aaa","bbb");
    }
}
