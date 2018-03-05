package com.heqing.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据库持久层帮助类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/08
 */
public class DataSourceUtil {

    public static DataSource createDataSource(String driver, String url, String userName, String password) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    public static SqlSessionFactory createSqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        try {
            bean.setDataSource(dataSource);
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/heqing/dao/mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static SqlSession createSqlSession(DataSource dataSource) {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory(dataSource);
        if(sqlSessionFactory != null) {
            return sqlSessionFactory.openSession();
        }
        return null;
    }

    public static DataSourceTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public static SqlSessionTemplate createSqlSessionTemplate(DataSource dataSource) {
        SqlSessionFactory sqlSessionFactory = createSqlSessionFactory(dataSource);
        if(sqlSessionFactory != null) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
        return null;
    }
}
