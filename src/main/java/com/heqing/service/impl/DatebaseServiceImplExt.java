package com.heqing.service.impl;

import com.heqing.entity.orm.DatebaseEntity;
import com.heqing.service.DatebaseServiceExt;
import com.heqing.util.DataSourceUtil;
import com.heqing.util.ObjectUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接信息数据持久层实现类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
@Service
public class DatebaseServiceImplExt extends DatebaseServiceImpl implements DatebaseServiceExt {

    private static final Logger LOGGER = Logger.getLogger(DatebaseServiceImplExt.class);

    @Override
    public Boolean connect(DatebaseEntity datebase) {
        String url = "jdbc:MySQL://"+datebase.getUrl()+":"+datebase.getPort()+"/"+datebase.getDbName();
        return connect(datebase.getDriver(), url, datebase.getUsername(), datebase.getPassword());
    }

    @Override
    public Boolean connect(String driverClass, String url, String userName, String password) {
        Boolean connect = false;
        Driver driver = getDriver(driverClass);
        if(driver != null) {
            Properties props = new Properties();
            props.setProperty("user", userName);
            props.setProperty("password", password);

            Connection conn = null;
            try {
                String connectionUrl = url;
                conn = driver.connect(connectionUrl, props);
                if(conn != null) {
                    connect = true;
                    conn.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return connect;
    }

    @Override
    public SqlSession getSqlSession(Integer dbId) {
        return getSqlSession(getDatebaseByKey(dbId));
    }

    @Override
    public SqlSession getSqlSession(DatebaseEntity datebase) {
        if(datebase != null) {
            String driver = datebase.getDriver() == null ? "" : datebase.getDriver();
            String url = datebase.getUrl() == null ? "" : datebase.getUrl();
            Integer port = datebase.getPort() == null ? 0 : datebase.getPort();
            String dbName = datebase.getDbName() == null ? "" : datebase.getDbName();
            String userName = datebase.getUsername() == null ? "" : datebase.getUsername();
            String password = datebase.getPassword() == null ? "" : datebase.getPassword();
            url = "jdbc:MySQL://" + url + ":" + port + "/" + dbName;

            DataSource dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
            if(dataSource !=null) {
                return DataSourceUtil.createSqlSession(dataSource);
            }
        }
        return null;
    }

    private Driver getDriver(String driverClass) {
        Driver driver = null;

        try {
            Class<?> clazz = ObjectUtil.externalClassForName(driverClass);
            driver = (Driver) clazz.newInstance();
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
            e.printStackTrace();
        }
        return driver;
    }
}
