package com.cncs.test;

import com.cncs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testAop(){
        accountService.save();
        accountService.update(40);
        accountService.find(3);
        boolean state = accountService.delete();
        System.out.println(state);
    }
}
