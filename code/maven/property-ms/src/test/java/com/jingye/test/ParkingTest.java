package com.jingye.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.jingye.util.PageInfoUtil;

import com.jingye.entity.Parking;
import com.jingye.service.ParkingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class ParkingTest {

    @Autowired
    ParkingService parkingService;

    @Test
    public void testSaveParking() {
        Parking parking = new Parking();
        parking.setParkingId(1);
        parking.setParkingArea(""+1);
        parking.setParkingOwnerId(1);
        parking.setParkingCarNumber(""+1);
        parking.setParkingInfo(""+1);
        parking.setParkingCarKind(""+1);
        System.out.println("-->"+parkingService.saveParking(parking));
    }

    @Test
    public void testBatchSaveParking() {
        List<Parking> parkingList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Parking parking = new Parking();
            parking.setParkingId(i);
            parking.setParkingArea(""+i);
            parking.setParkingOwnerId(i);
            parking.setParkingCarNumber(""+i);
            parking.setParkingInfo(""+i);
            parking.setParkingCarKind(""+i);
            parkingList.add(parking);
        }
        System.out.println("-->"+parkingService.saveParking(parkingList));
    }

    @Test
    public void testListParking() {
        System.out.println("-->"+parkingService.listParking());
    }

    @Test
    public void testListParkingByParam() {
        Parking parking = new Parking();
        parking.setParkingArea("1");
        System.out.println("-->"+parkingService.listParkingByParam(parking));
    }

    @Test
    public void testListParkingByPage() {
        PageInfoUtil<Parking> parkingList = parkingService.listParkingByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(parkingList));
    }

    @Test
    public void testListParkingByParamAndPage() {
        Parking parking = new Parking();
        parking.setParkingArea("1");
        PageInfoUtil<Parking> parkingList = parkingService.listParkingByParamAndPage(parking, 1, 2);
        System.out.println("-->"+JSON.toJSONString(parkingList));
    }

    @Test
    public void testDeleteParkingByParam() {
        Parking parking = new Parking();
        parking.setParkingArea("1");
        System.out.println("-->"+parkingService.deleteParkingByParam(parking));
    }

    @Test
    public void testUpdateParkingByKey() {
        Parking parking = new Parking();
        parking.setParkingId(1);
        parking.setParkingArea("1");
        parking.setParkingCarKind("1");
        parking.setParkingInfo("1");
        parking.setParkingCarNumber("1");
        parking.setParkingOwnerId(1);
        System.out.println("-->"+parkingService.updateParkingByKey(parking));
    }

    @Test
    public void testUpdateBatchParkingByKey() {
        List<Parking> parkingList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Parking parking = new Parking();
            parking.setParkingId(i-5);
            parking.setParkingArea(""+i);
            parking.setParkingCarKind(""+i);
            parking.setParkingInfo(""+i);
            parking.setParkingCarNumber(""+i);
            parking.setParkingOwnerId(i);
            parkingList.add(parking);
        }
        System.out.println("-->"+parkingService.updateParkingByKey(parkingList));
    }


    @Test
    public void testGetParkingByKey() {
        int parkingPK = 1;
        System.out.println("-->"+parkingService.getParkingByKey(parkingPK));
    }

    @Test
    public void testListParkingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+parkingService.listParkingByKey(keyList));
    }

    @Test
    public void testDeleteParkingByKey() {
        int parkingPK = 1;
        System.out.println("-->"+parkingService.deleteParkingByKey(parkingPK));
    }

    @Test
    public void testDeleteBatchParkingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+parkingService.deleteParkingByKey(keyList));
    }

}
