package com.heqing.datebase;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.heqing.util.PageInfoUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.heqing.entity.Datebase;
import com.heqing.service.DatebaseService;

/**
 * 数据库连接信息数据持久层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DatebaseTest {

    @Autowired
    DatebaseService datebaseService;

    @Test
    public void testSaveDatebase() {
        Datebase datebase = new Datebase();
        datebase.setUrl("test1");
        datebase.setDescribe("test1");
        datebase.setCreateTime(new Date());
        datebase.setPassword("test1");
        datebase.setSchema("test1");
        datebase.setDbName("test1");
        datebase.setUpdateTime(new Date());
        datebase.setId(2);
        datebase.setConnectName("test1");
        datebase.setCreateUser("test1");
        datebase.setDriver("test1");
        datebase.setUsername("test1");
        datebase.setPort(1);
        System.out.println("-->"+datebaseService.saveDatebase(datebase));
    }

    @Test
    public void testSaveBatchDatebase() {
        List<Datebase> datebaseList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Datebase datebase = new Datebase();
            datebase.setUrl("test"+i);
            datebase.setDescribe("test"+i);
            datebase.setCreateTime(new Date());
            datebase.setPassword("test"+i);
            datebase.setSchema("test"+i);
            datebase.setDbName("test"+i);
            datebase.setUpdateTime(new Date());
            datebase.setId(i);
            datebase.setConnectName("test"+i);
            datebase.setCreateUser("test"+i);
            datebase.setDriver("test"+i);
            datebase.setUsername("test"+i);
            datebase.setPort(i);
            datebaseList.add(datebase);
        }
        System.out.println("-->"+datebaseService.saveBatchDatebase(datebaseList));
    }

    @Test
    public void testModifyDatebaseByKey() {
        Datebase datebase = new Datebase();
        datebase.setId(1);
        datebase.setDbName("test"+11);
        datebase.setUpdateTime(new Date());
        datebase.setUrl("test"+11);
        datebase.setConnectName("test"+11);
        datebase.setDescribe("test"+11);
        datebase.setCreateTime(new Date());
        datebase.setCreateUser("test"+11);
        datebase.setDriver("test"+11);
        datebase.setPassword("test"+11);
        datebase.setUsername("test"+11);
        datebase.setPort(1+10);
        datebase.setSchema("test"+11);
        System.out.println("-->"+datebaseService.modifyDatebaseByKey(datebase));
    }

    @Test
    public void testModifyBatchDatebaseByKey() {
        List<Datebase> datebaseList = new ArrayList<>();
        for(int i=12;i<15;i++) {
            Datebase datebase = new Datebase();
            datebase.setId(i-10);
            datebase.setDbName("test"+i);
            datebase.setUpdateTime(new Date());
            datebase.setUrl("test"+i);
            datebase.setConnectName("test"+i);
            datebase.setDescribe("test"+i);
            datebase.setCreateTime(new Date());
            datebase.setCreateUser("test"+i);
            datebase.setDriver("test"+i);
            datebase.setPassword("test"+i);
            datebase.setUsername("test"+i);
            datebase.setPort(i);
            datebase.setSchema("test"+i);
            datebaseList.add(datebase);
        }
        System.out.println("-->"+datebaseService.modifyBatchDatebaseByKey(datebaseList));
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
//        datebase.setUrl("test1");
//        datebase.setConnectName("testInsert");
        System.out.println("-->"+datebaseService.listDatebaseByParam(datebase).size());
    }

    @Test
    public void testListDatebaseByPage() {
        Page<Datebase> datebaseList = datebaseService.listDatebaseByPage(1,1);
        PageInfoUtil<Datebase> pageInfo = new PageInfoUtil<>(datebaseList);
        System.out.println("-->"+JSON.toJSONString(pageInfo));
    }

    @Test
    public void testListDatebaseByParamAndPage() {
        Datebase datebase = new Datebase();
        datebase.setUrl("localhost");
        Page<Datebase> datebaseList = datebaseService.listDatebaseByParamAndPage(datebase, 1,2);
        PageInfoUtil<Datebase> pageInfo = new PageInfoUtil<>(datebaseList);
        System.out.println("-->"+JSON.toJSONString(pageInfo));
    }

    @Test
    public void testRemoveDatebaseByKey() {
        System.out.println("-->"+datebaseService.removeDatebaseByKey(
            1
        ));
    }

    @Test
    public void testRemoveBatchDatebaseByKey() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        System.out.println("-->"+datebaseService.removeBatchDatebaseByKey(ids));
    }
 
    @Test
    public void removeBatchDatebaseByParam() {
        Datebase datebase = new Datebase();
        datebase.setUrl("test1");
        System.out.println("-->"+datebaseService.removeBatchDatebaseByParam(datebase));
    }

}
