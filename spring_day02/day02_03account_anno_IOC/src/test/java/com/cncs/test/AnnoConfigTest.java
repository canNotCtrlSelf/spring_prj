package com.cncs.test;

import com.cncs.config.SpringConfiguration;
import com.cncs.domain.Account;
import com.cncs.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AnnoConfigTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById() {
        Account account = accountService.findById(7);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setMoney(3333);
        account.setName("李思思");
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(12);
        account.setMoney(5555);
        account.setName("李思思");
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccount(12);
    }
}
