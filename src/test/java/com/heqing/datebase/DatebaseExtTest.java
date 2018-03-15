package com.heqing.datebase;

import com.heqing.entity.orm.Datebase;
import com.heqing.service.impl.DatebaseServiceImplExt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ResourceBundle;

/**
 * 数据库连接测试类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatebaseExtTest {

    @Autowired
    DatebaseServiceImplExt datebaseServiceExt;

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    Datebase datebase = new Datebase();

    @Before
    public void createDateBase() {
        String driver = BUNDLE.getString("db.driver");
        String url = BUNDLE.getString("db.url");
        int port = Integer.parseInt(BUNDLE.getString("db.port"));
        String dbName = BUNDLE.getString("db.dbName");
        String userName = BUNDLE.getString("db.username");
        String password = BUNDLE.getString("db.password");

        datebase.setDriver(driver);
        datebase.setUrl(url);
        datebase.setPort(port);
        datebase.setDbName(dbName);
        datebase.setUsername(userName);
        datebase.setPassword(password);
    }

    @Test
    public void testConnect() {
        boolean conn = datebaseServiceExt.connect(datebase);
        if (conn) {
            System.out.println("数据库连接成功！");
        } else {
            System.out.println("数据库连接失败！");
        }
    }
}
