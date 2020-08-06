package com.cncs.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring_learn");
        ds.setUsername("root");
        ds.setPassword("1705640");
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(ds);
        //执行查找
        jdbcTemplate.execute("insert into account(name,money)values('2m13',1000)");

    }
}
