package com.cncs.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Configuration //标识当前类是一个配置类
@Import({JdbcConfig.class})
@ComponentScan(basePackages = {"com.cncs"}) //声明spring创建容器时要扫描的包
public class SpringConfiguration {

}
