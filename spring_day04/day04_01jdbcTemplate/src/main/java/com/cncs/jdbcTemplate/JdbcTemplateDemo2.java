package com.cncs.jdbcTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * 使用spring ioc容器创建数据源对象
 * jdbcTemplate最基本用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        DriverManagerDataSource ds = ac.getBean("dataSource", DriverManagerDataSource.class);
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
        //执行查找
        jdbcTemplate.execute("insert into account(name,money)values('tiem:1800',1000)");

    }
}
