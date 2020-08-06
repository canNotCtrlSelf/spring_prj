package config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TxManagerConfiguration {

    @Bean("txManager")
    public PlatformTransactionManager createTxManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
