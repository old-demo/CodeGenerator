package com.heqing.task;

import com.heqing.constants.FrameEnum;
import com.heqing.entity.orm.Datebase;
import com.heqing.entity.orm.Table;
import com.heqing.entity.task.FrameEntity;
import com.heqing.entity.task.MavenTaskEntity;
import com.heqing.service.TableService;
import com.heqing.service.impl.DatebaseServiceImplExt;
import com.heqing.service.task.MavenTaskService;

import com.heqing.util.FileUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

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

    FrameEntity frameEntity = new FrameEntity();

    //zip输出路径
    //String zipPath = System.getProperty("user.dir")+"/code.zip";
    String zipPath = System.getProperty("user.dir")+"/code/";

    @Before
    public void createDateBase() {
        String driver = "com.mysql.jdbc.Driver";
        String url = "localhost";
        int port = 3306;
        String dbName = "yzadmin";
        String userName = "root";
        String password = "246512";

        datebase.setDriver(driver);
        datebase.setUrl(url);
        datebase.setPort(port);
        datebase.setDbName(dbName);
        datebase.setUsername(userName);
        datebase.setPassword(password);

        frameEntity.setProjectFrame(FrameEnum.MAVEN);
        frameEntity.setServiceFrame(FrameEnum.SPRING_BOOT);
        frameEntity.setRepositoryFrame(FrameEnum.MYBATIS);
        frameEntity.setControllerFrame(FrameEnum.SPRING_MVC);
        frameEntity.setH5Frame(FrameEnum.BOOTSTRAP);
    }

    @Test
    public void testMavenTask() {
        List<Table> tableList = tableService.listTable(datebaseServiceExt.getSqlSession(datebase));
        List<String> tableNames = new ArrayList<>();
        for(Table table : tableList) {
            tableNames.add(table.getTableName());
        }
        MavenTaskEntity taskEntity = new MavenTaskEntity();
        taskEntity.setGroupId("com.yz");
        taskEntity.setArtifactId("yzDateTest");
        taskEntity.setVersion("0.0.1-SNAPSHOT");
        taskEntity.setDescription("这是 1诊测试 数据测试项目");

        taskEntity.setTableNames(tableNames);
        taskEntity.setZipPath(zipPath+"maven/");
        taskEntity.setProjectName("YzDateTest");
        taskEntity.setAuthorName("heqing");
        taskEntity.setAuthorEmail("975656343@qq.com");
        taskEntity.setPackageName("com.yz");

        taskEntity.setFrame(frameEntity);
        taskEntity.setDatebase(datebase);
        mavenTaskService.execute(taskEntity);

        Iterator entries = taskEntity.getErrorMap().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            String key = (String) entry.getKey();
            Object value = (Object) entry.getValue();
            System.out.println("Key = " + key + ", Value = " + value);
        }
    }

    @Test
    public void testKey() {
        String filePath = System.getProperty("user.dir")+"/src/main/resources/keyWord.txt";
        System.out.println("---->"+FileUtil.readFile(filePath));
    }

}
