package com.bootdo.doll.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @author mading
 * @desc
 * @date 2018/7/17
 **/

//@Configuration
@MapperScan(basePackages = {
        "com.bootdo.doll.dao"
}, sqlSessionTemplateRef = "dollSqlSessionTemplate")
public class DollDatasourceConfig {

    @Bean(name = "dollDataSource")
    @ConfigurationProperties(prefix = "datasource.doll")
    public DataSource dollDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dollSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dollDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:doll.mybatis/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "dollTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("dollDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "dollSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("dollSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

