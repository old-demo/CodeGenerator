package com.heqing.datebase;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.Table;
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
 * 数据库表测试类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
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
        Table table = tableService.getTableByName(sqlSession, "datebase");
        System.out.println("---> "+table);
    }

    @Test
    public void listTable() {
        List<Table> tableList = tableService.listTable(sqlSession);
        for(Table table : tableList) {
            System.out.println("-->"+table);
        }
    }

    @Test
    public void listTableByParamAndPage() {
        try {
            PageInfo<Table> tableList = tableService.listTableByParamAndPage(sqlSession, "r", 1, 2);
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
