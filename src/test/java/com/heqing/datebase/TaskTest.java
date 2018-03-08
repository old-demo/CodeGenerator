package com.heqing.datebase;

import com.heqing.entity.Datebase;
import com.heqing.entity.orm.TableEntity;
import com.heqing.entity.task.MavenTaskEntity;
import com.heqing.entity.task.TaskEntity;
import com.heqing.service.TableService;
import com.heqing.service.impl.DatebaseServiceImplExt;
import com.heqing.service.task.MavenTaskService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by heqing on 2018/1/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTest {

    @Autowired
    MavenTaskService mavenTaskService;

    @Autowired
    DatebaseServiceImplExt datebaseServiceExt;

    @Autowired
    TableService tableService;

    Datebase datebase = new Datebase();

    //zip输出路径
    //String zipPath = System.getProperty("user.dir")+"/code.zip";
    String zipPath = System.getProperty("user.dir")+"/code/";

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
        String url = "jdbc:MySQL://" + datebase.getUrl() + ":" + datebase.getPort() + "/" + datebase.getDbName();
        try {
            Connection conn = datebaseServiceExt.connect(datebase.getDriver(), url, datebase.getUsername(), datebase.getPassword());
            if (conn != null) {
                conn.close();
                System.out.println("数据库连接成功！");
            } else {
                System.out.println("数据库连接失败！");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMavenTask() {
        List<TableEntity> tableList = tableService.listTable(datebaseServiceExt.getSqlSession(datebase));
        List<String> tableNames = new ArrayList<>();
        for(TableEntity table : tableList) {
            if(!"datebase".equals(table.getTableName())) {
                tableNames.add(table.getTableName());
            }
        }
        MavenTaskEntity taskEntity = new MavenTaskEntity();
        taskEntity.setGroupId("com.heqing");
        taskEntity.setArtifactId("SpringTest");
        taskEntity.setVersion("0.0.1-SNAPSHOT");
        taskEntity.setDescription("this is test");
        taskEntity.setDatebase(datebase);
        taskEntity.setProjectName("SpringTest");
        taskEntity.setTableNames(tableNames);
        taskEntity.setZipPath(zipPath+"maven/");
        taskEntity.setAuthorName("heqing");
        taskEntity.setAuthorEmail("975656343@qq.com");
        taskEntity.setPackageName("com.heqing.yyw");
        taskEntity.setServiceFrame(MavenTaskEntity.SPRING);
        mavenTaskService.execute(taskEntity);
    }


}
