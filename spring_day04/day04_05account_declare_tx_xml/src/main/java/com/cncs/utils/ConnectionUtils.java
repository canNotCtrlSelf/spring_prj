package com.cncs.utils;

import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection() {
        try {
            //获取连接
            Connection connection = tl.get();
            //判断当前线程是否有连接
            if (connection == null) {
                //从数据源中获取一个连接，存入连接池
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection() {
        tl.remove();
    }
}
