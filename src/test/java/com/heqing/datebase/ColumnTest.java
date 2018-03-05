package com.heqing.datebase;

import com.heqing.entity.orm.ColumnEntity;
import com.heqing.service.ColumnService;
import com.heqing.util.DataSourceUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by heqing on 2018/1/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ColumnTest {

    @Autowired
    ColumnService tableService;

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/code_generator";
    String userName = "root";
    String password = "246512";
    DataSource dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
    SqlSession sqlSession = DataSourceUtil.createSqlSession(dataSource);

    @Test
    public void listColumnByTable() {
        try {
            DataSource dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
            SqlSession sqlSession = DataSourceUtil.createSqlSession(dataSource);
            List<ColumnEntity> columnList = tableService.listColumnByTable(sqlSession, "datebase");
            for(ColumnEntity column : columnList) {
                System.out.println("-->"+column);
            }
            sqlSession.clearCache();
            sqlSession.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
