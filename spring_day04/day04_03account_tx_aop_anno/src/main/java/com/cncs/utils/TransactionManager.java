package com.cncs.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.cncs.service.impl.*.*(..))")
    public void pt1() {
    }

    /**
     * 开启事务
     */
    public void startTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit(); //提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connectionUtils.getThreadConnection().close();  //关闭连接
            connectionUtils.removeConnection();             //将连接与线程解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object returnVal = null;
        Object[] args = pjp.getArgs();
        try {
            startTransaction();
            returnVal = pjp.proceed(args);
            commit();
            return returnVal;
        } catch (Throwable e) {
            rollback();
            throw new RuntimeException(e);
        } finally {
            release();
        }
    }

}
