package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring的主配置类
 */
@Configuration
@ComponentScan(basePackages = "com.cncs")
@PropertySource(value = "classpath:jdbc.properties")
@Import({JdbcConfiguration.class,TxManagerConfiguration.class})
@EnableTransactionManagement
public class SpringConfiguration {
}
