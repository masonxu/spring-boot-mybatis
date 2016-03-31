package com.tiger.learn.mybatis.sample.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Value("${jdbc.driverClass}")
    private String jdbcDriverClass;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maxPoolSize}")
    private String maxPoolSize;

    @Primary
    @Bean(name="dataSource")
    public DataSource dataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(jdbcDriverClass);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setTestConnectionOnCheckin(true);
            dataSource.setTestConnectionOnCheckout(true);
            dataSource.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        } catch (Throwable e) {
        }


        return dataSource;
    }
}
