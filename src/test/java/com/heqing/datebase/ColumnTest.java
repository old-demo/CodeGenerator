package com.heqing.datebase;

import com.heqing.entity.orm.Column;
import com.heqing.service.ColumnService;
import com.heqing.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.ResourceBundle;

/**
 * 数据库列测试类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnTest {

    @Autowired
    ColumnService tableService;

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    DataSource dataSource = null;
    SqlSession sqlSession = null;

    @Before
    public void before() {
        String driver = BUNDLE.getString("db.driver");
        String url = BUNDLE.getString("db.url");
        int port = Integer.parseInt(BUNDLE.getString("db.port"));
        String dbName = BUNDLE.getString("db.dbName");
        String userName = BUNDLE.getString("db.username");
        String password = BUNDLE.getString("db.password");
        url = "jdbc:MySQL://"+url+":"+port+"/"+dbName;
        dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
        sqlSession = DataSourceUtil.createSqlSession(dataSource);
    }

    @Test
    public void listColumnByTable() {
        List<Column> columnList = tableService.listColumnByTable(sqlSession, "datebase");
        for(Column column : columnList) {
            System.out.println("-->"+column);
        }
    }

    @After
    public void after() {
        if(sqlSession != null) {
            sqlSession.clearCache();
            sqlSession.close();
        }
    }
}
