package com.heqing.datebase;

import com.alibaba.fastjson.JSON;
import com.heqing.entity.orm.Datebase;
import com.heqing.util.PageInfoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.service.DatebaseService;

/**
 * 数据库连接信息数据持久层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatebaseTest {

    @Autowired
    DatebaseService datebaseService;

    @Test
    public void testSaveDatebase() {
        Datebase datebase = new Datebase();
        datebase.setConnectName("1");
        datebase.setDriver("1");
        datebase.setUpdateTime(new Date());
        datebase.setId(1);
        datebase.setRemark("1");
        datebase.setUrl("1");
        datebase.setCreateTime(new Date());
        datebase.setUsername("1");
        datebase.setDbName("1");
        datebase.setCreateUser("1");
        datebase.setPort(1);
        datebase.setPassword("1");
        System.out.println("-->"+datebaseService.saveDatebase(datebase));
    }

    @Test
    public void testSaveBatchDatebase() {
        List<Datebase> datebaseList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Datebase datebase = new Datebase();
            datebase.setConnectName(""+i);
            datebase.setDriver(""+i);
            datebase.setUpdateTime(new Date());
            datebase.setId(i);
            datebase.setRemark(""+i);
            datebase.setUrl(""+i);
            datebase.setCreateTime(new Date());
            datebase.setUsername(""+i);
            datebase.setDbName(""+i);
            datebase.setCreateUser(""+i);
            datebase.setPort(i);
            datebase.setPassword(""+i);
            datebaseList.add(datebase);
        }
        System.out.println("-->"+datebaseService.saveBatchDatebase(datebaseList));
    }

    @Test
    public void testGetDatebaseByKey() {
        System.out.println("-->"+datebaseService.getDatebaseByKey(
                1
        ));
    }

    @Test
    public void testListDatebaseByKey() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        System.out.println("-->"+datebaseService.listDatebaseByKey(ids));
    }

    @Test
    public void testListDatebase() {
        System.out.println("-->"+datebaseService.listDatebase());
    }

    @Test
    public void testListDatebaseByParam() {
        Datebase datebase = new Datebase();
        datebase.setConnectName("1");
        System.out.println("-->"+datebaseService.listDatebaseByParam(datebase));
    }

    @Test
    public void testListDatebaseByPage() {
        PageInfoUtil<Datebase> datebaseList = datebaseService.listDatebaseByPage(1,2);
        System.out.println("-->"+JSON.toJSONString(datebaseList));
    }

    @Test
    public void testListDatebaseByParamAndPage() {
        Datebase datebase = new Datebase();
        datebase.setConnectName("1");
        PageInfoUtil<Datebase> datebaseList = datebaseService.listDatebaseByParamAndPage(datebase, 1,2);
        System.out.println("-->"+JSON.toJSONString(datebaseList));
    }

    @Test
    public void testUpdateDatebaseByKey() {
        Datebase datebase = new Datebase();
        datebase.setId(1);
        datebase.setConnectName(""+6);
        datebase.setUsername(""+6);
        datebase.setPassword(""+6);
        datebase.setDbName(""+6);
        datebase.setRemark(""+6);
        datebase.setPort(1+5);
        datebase.setUrl(""+6);
        datebase.setCreateUser(""+6);
        datebase.setUpdateTime(new Date());
        datebase.setDriver(""+6);
        datebase.setCreateTime(new Date());
        System.out.println("-->"+datebaseService.updateDatebaseByKey(datebase));
    }

    @Test
    public void testUpdateBatchDatebaseByKey() {
        List<Datebase> datebaseList = new ArrayList<>();
        for(int i=7;i<10;i++) {
            Datebase datebase = new Datebase();
            datebase.setId(i-5);
            datebase.setConnectName(""+i);
            datebase.setUsername(""+i);
            datebase.setPassword(""+i);
            datebase.setDbName(""+i);
            datebase.setRemark(""+i);
            datebase.setPort(i);
            datebase.setUrl(""+i);
            datebase.setCreateUser(""+i);
            datebase.setUpdateTime(new Date());
            datebase.setDriver(""+i);
            datebase.setCreateTime(new Date());
            datebaseList.add(datebase);
        }
        System.out.println("-->"+datebaseService.updateBatchDatebaseByKey(datebaseList));
    }

    @Test
    public void testDeleteDatebaseByKey() {
        System.out.println("-->"+datebaseService.deleteDatebaseByKey(
                1
        ));
    }

    @Test
    public void testDeleteBatchDatebaseByKey() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        System.out.println("-->"+datebaseService.deleteBatchDatebaseByKey(ids));
    }

    @Test
    public void testDeleteBatchDatebaseByParam() {
        Datebase datebase = new Datebase();
        datebase.setConnectName("1");
        System.out.println("-->"+datebaseService.deleteBatchDatebaseByParam(datebase));
    }
}