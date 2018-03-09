package com.heqing.datebase;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.TableEntity;
import com.heqing.service.TableService;
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

/**
 * Created by heqing on 2018/1/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TableTest {

    @Autowired
    TableService tableService;

    DataSource dataSource = null;
    SqlSession sqlSession = null;

    @Before
    public void before() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:MySQL://localhost:3306/code_generator";
        String userName = "root";
        String password = "246512";
        dataSource = DataSourceUtil.createDataSource(driver, url, userName, password);
        sqlSession = DataSourceUtil.createSqlSession(dataSource);
    }

    @Test
    public void getTableByName() {
        TableEntity table = tableService.getTableByName(sqlSession, "datebase");
        System.out.println("---> "+table);
    }

    @Test
    public void listTable() {
        List<TableEntity> tableList = tableService.listTable(sqlSession);
        for(TableEntity table : tableList) {
            System.out.println("-->"+table);
        }
    }

    @Test
    public void listTableByParamAndPage() {
        try {
            PageInfo<TableEntity> tableList = tableService.listTableByParamAndPage(sqlSession, "r", 1, 2);
            System.out.println("-->"+ JSON.toJSONString(tableList));
        } catch(Exception e) {
            e.printStackTrace();
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
