package com.jingye.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.fastjson.JSON;
import com.jingye.util.PageInfoUtil;

import com.jingye.entity.TemporaryParking;
import com.jingye.service.TemporaryParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class TemporaryParkingTest {

    @Autowired
    TemporaryParkingService temporaryParkingService;

    @Test
    public void testSaveTemporaryParking() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setTpNote(""+1);
        temporaryParking.setTpTime(""+1);
        temporaryParking.setTpCharge(""+1);
        temporaryParking.setId(1);
        System.out.println("-->"+temporaryParkingService.saveTemporaryParking(temporaryParking));
    }

    @Test
    public void testBatchSaveTemporaryParking() {
        List<TemporaryParking> temporaryParkingList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            TemporaryParking temporaryParking = new TemporaryParking();
            temporaryParking.setTpNote(""+i);
            temporaryParking.setTpTime(""+i);
            temporaryParking.setTpCharge(""+i);
            temporaryParking.setId(i);
            temporaryParkingList.add(temporaryParking);
        }
        System.out.println("-->"+temporaryParkingService.saveTemporaryParking(temporaryParkingList));
    }

    @Test
    public void testListTemporaryParking() {
        System.out.println("-->"+temporaryParkingService.listTemporaryParking());
    }

    @Test
    public void testListTemporaryParkingByParam() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setTpNote("1");
        System.out.println("-->"+temporaryParkingService.listTemporaryParkingByParam(temporaryParking));
    }

    @Test
    public void testListTemporaryParkingByPage() {
        PageInfoUtil<TemporaryParking> temporaryParkingList = temporaryParkingService.listTemporaryParkingByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(temporaryParkingList));
    }

    @Test
    public void testListTemporaryParkingByParamAndPage() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setTpNote("1");
        PageInfoUtil<TemporaryParking> temporaryParkingList = temporaryParkingService.listTemporaryParkingByParamAndPage(temporaryParking, 1, 2);
        System.out.println("-->"+JSON.toJSONString(temporaryParkingList));
    }

    @Test
    public void testDeleteTemporaryParkingByParam() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setTpNote("1");
        System.out.println("-->"+temporaryParkingService.deleteTemporaryParkingByParam(temporaryParking));
    }

    @Test
    public void testUpdateTemporaryParkingByKey() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setId(1);
        temporaryParking.setTpNote("1");
        temporaryParking.setTpCharge("1");
        temporaryParking.setTpTime("1");
        System.out.println("-->"+temporaryParkingService.updateTemporaryParkingByKey(temporaryParking));
    }

    @Test
    public void testUpdateBatchTemporaryParkingByKey() {
        List<TemporaryParking> temporaryParkingList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            TemporaryParking temporaryParking = new TemporaryParking();
            temporaryParking.setId(i-5);
            temporaryParking.setTpNote(""+i);
            temporaryParking.setTpCharge(""+i);
            temporaryParking.setTpTime(""+i);
            temporaryParkingList.add(temporaryParking);
        }
        System.out.println("-->"+temporaryParkingService.updateTemporaryParkingByKey(temporaryParkingList));
    }


    @Test
    public void testGetTemporaryParkingByKey() {
        int temporaryParkingPK = 1;
        System.out.println("-->"+temporaryParkingService.getTemporaryParkingByKey(temporaryParkingPK));
    }

    @Test
    public void testListTemporaryParkingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+temporaryParkingService.listTemporaryParkingByKey(keyList));
    }

    @Test
    public void testDeleteTemporaryParkingByKey() {
        int temporaryParkingPK = 1;
        System.out.println("-->"+temporaryParkingService.deleteTemporaryParkingByKey(temporaryParkingPK));
    }

    @Test
    public void testDeleteBatchTemporaryParkingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+temporaryParkingService.deleteTemporaryParkingByKey(keyList));
    }

}
