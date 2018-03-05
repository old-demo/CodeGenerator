package com.heqing.datebase;

import com.heqing.entity.orm.TableEntity;
import com.heqing.service.TableService;
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
public class TableTest {

    @Autowired
    TableService tableService;

    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:MySQL://localhost:3306/code_generator";
    String userName = "root";
    String password = "246512";
    DataSource dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
    SqlSession sqlSession = DataSourceUtil.createSqlSession(dataSource);

    @Test
    public void getTableByName() {
        try {
            TableEntity table = tableService.getTableByName(sqlSession, "datebase");
            System.out.println("---> "+table);
            sqlSession.clearCache();
            sqlSession.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listTable() {
        try {
            List<TableEntity> tableList = tableService.listTable(sqlSession);
            for(TableEntity table : tableList) {
                System.out.println("-->"+table);
            }
            sqlSession.clearCache();
            sqlSession.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
