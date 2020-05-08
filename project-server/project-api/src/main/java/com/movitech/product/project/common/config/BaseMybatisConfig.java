package com.movitech.product.project.common.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.movitech.generics.framework.common.mybatis.entity.BaseEntity;

/**
 * Mybatis配置
 *
 * @author hawods
 * @version 2018-02-22
 */
@Configuration
public class BaseMybatisConfig {
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesSuperType(BaseEntity.class);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource mybatisConfigXml = resolver.getResource("classpath:mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(mybatisConfigXml);
        Resource[] mapperXmls = resolver.getResources("classpath*:mapper/**/*.xml");
        sqlSessionFactoryBean.setMapperLocations(mapperXmls);
        sqlSessionFactoryBean.setDatabaseIdProvider(databaseIdProvider());
        return sqlSessionFactoryBean;
    }

    @Bean
    public DatabaseIdProvider databaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle", "oracle");
        p.setProperty("MySQL", "mysql");
        p.setProperty("PostgreSQL", "postgresql");
        p.setProperty("DB2", "db2");
        p.setProperty("SQL Server", "sqlserver");
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }

}
