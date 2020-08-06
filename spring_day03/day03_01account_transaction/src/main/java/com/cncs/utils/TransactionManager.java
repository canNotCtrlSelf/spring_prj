package com.cncs.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void startTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚
     */
    public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit(); //提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getThreadConnection().close();  //关闭连接
            connectionUtils.removeConnection();             //将连接与线程解绑
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
