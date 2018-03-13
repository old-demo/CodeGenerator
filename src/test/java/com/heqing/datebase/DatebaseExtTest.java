package com.heqing.datebase;

import com.heqing.entity.orm.Datebase;
import com.heqing.service.impl.DatebaseServiceImplExt;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by heqing on 2018/2/7.
 */
public class DatebaseExtTest {

    @Autowired
    DatebaseServiceImplExt datebaseServiceExt;

    Datebase datebase = new Datebase();

    @Before
    public void createDateBase() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "localhost";
        int port = 3306;
        String dbName = "code_generator";
        String userName = "root";
        String password = "246512";

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
