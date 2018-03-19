package com.heqing.task;

import com.heqing.constants.FrameEnum;
import com.heqing.entity.orm.Datebase;
import com.heqing.entity.orm.Table;
import com.heqing.entity.task.FrameEntity;
import com.heqing.entity.task.MavenTaskEntity;
import com.heqing.service.TableService;
import com.heqing.service.impl.DatebaseServiceImplExt;
import com.heqing.service.task.MavenTaskService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("application");

    Datebase datebase = new Datebase();

    FrameEntity frameEntity = new FrameEntity();

    //zip输出路径
    //String zipPath = System.getProperty("user.dir")+"/code.zip";
    String zipPath = System.getProperty("user.dir")+"/code/";

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

        frameEntity.setProjectFrame(FrameEnum.MAVEN);
//        frameEntity.setControllerFrame(FrameEnum.SPRINGMVC);
        frameEntity.setServiceFrame(FrameEnum.SPRING);
        frameEntity.setRepositoryFrame(FrameEnum.HIBERNATE);
    }

    @Test
    public void testMavenTask() {
        List<Table> tableList = tableService.listTable(datebaseServiceExt.getSqlSession(datebase));
        List<String> tableNames = new ArrayList<>();
        for(Table table : tableList) {
            if(!"datebase".equals(table.getTableName())) {
                tableNames.add(table.getTableName());
            }
        }
        MavenTaskEntity taskEntity = new MavenTaskEntity();
        taskEntity.setGroupId("com.heqing");
        taskEntity.setArtifactId("TestHibernate");
        taskEntity.setVersion("0.0.1-SNAPSHOT");
        taskEntity.setDescription("this is test");

        taskEntity.setTableNames(tableNames);
        taskEntity.setZipPath(zipPath+"maven/");
        taskEntity.setProjectName("TestHibernate");
        taskEntity.setAuthorName("heqing");
        taskEntity.setAuthorEmail("975656343@qq.com");
        taskEntity.setPackageName("com.heqing.yyw");

        taskEntity.setFrame(frameEntity);
        taskEntity.setDatebase(datebase);
        mavenTaskService.execute(taskEntity);
    }

}
