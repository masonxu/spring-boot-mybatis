package com.tiger.learn.mybatis.sample.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author xuerhu (mailto:xueh@primeton.com)
 */
@Configuration
@AutoConfigureAfter(value = { DatabaseConfiguration.class })
@ConditionalOnClass({ EnableTransactionManagement.class})
@MapperScan(basePackages = {"com.tiger.learn.mybatis.sample.dao"})
public class MybatisConfiguration {
    @Resource(name="dataSource")
    private DataSource dataSource;

    @Bean(name="dataSourceTransactionManager")
    @ConditionalOnMissingBean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.tiger.learn.mybatis.sample.model");
        return sessionFactory;
    }
}
