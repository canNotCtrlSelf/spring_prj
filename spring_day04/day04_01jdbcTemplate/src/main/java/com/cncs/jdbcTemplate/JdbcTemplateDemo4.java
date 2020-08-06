package com.cncs.jdbcTemplate;

import com.cncs.dao.AccountDao;
import com.cncs.dao.impl.AccountDaoImpl;
import com.cncs.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * jdbcTemplate CRUD操作
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
        //执行查找所有
//        List<Account> accounts = jdbcTemplate.query("select * from account",new AccountRowMapper());
        List<Account> accounts = accountDao.findAll();
        System.out.println(accounts);
        //执行按照id查询
/*        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?", new AccountRowMapper(),9);
        if(accounts.isEmpty()){
            System.out.println("该账户不存在");
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        System.out.println(accounts.get(0));*/
        //执行更新
       /* Account account = new Account();
        account.setName("hey know");
        account.setMoney(1444f);
        jdbcTemplate.update("update account set name =?,money=? where id=?", account.getName(), account.getMoney(), 15);*/
        //执行删除
/*        jdbcTemplate.update("delete from account where id=?", 15);
        //执行统计查询数据总数
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(count);*/
        //插入一个数据
//        jdbcTemplate.execute("insert into account(name,money)values('tiem:1800',1000)");

    }
}
