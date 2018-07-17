package com.bootdo.common.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        "com.bootdo.activiti.dao",
        "com.bootdo.blog.dao",
        "com.bootdo.common.dao",
        "com.bootdo.oa.dao",
        "com.bootdo.system.dao"
}, sqlSessionTemplateRef = "bootdoSqlSessionTemplate")
public class BootdoDatasourceConfig {

    @Bean(name = "bootdoDataSource")
    @ConfigurationProperties(prefix = "datasource.bootdo")
    @Primary
    public DataSource bootdoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bootdoSqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("bootdoDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/**/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "bootdoTransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("bootdoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "bootdoSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("bootdoSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

