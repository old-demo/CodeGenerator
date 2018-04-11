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

import com.jingye.entity.ParkingSpaces;
import com.jingye.service.ParkingSpacesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class ParkingSpacesTest {

    @Autowired
    ParkingSpacesService parkingSpacesService;

    @Test
    public void testSaveParkingSpaces() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setCwOpen(new Date());
        parkingSpaces.setCwClose(new Date());
        parkingSpaces.setCwCost(""+1);
        parkingSpaces.setCwYzId(1);
        parkingSpaces.setCwNote(""+1);
        parkingSpaces.setId(1);
        parkingSpaces.setCwId(""+1);
        parkingSpaces.setCwBuildingId(""+1);
        parkingSpaces.setCwArea(""+1);
        System.out.println("-->"+parkingSpacesService.saveParkingSpaces(parkingSpaces));
    }

    @Test
    public void testBatchSaveParkingSpaces() {
        List<ParkingSpaces> parkingSpacesList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            ParkingSpaces parkingSpaces = new ParkingSpaces();
            parkingSpaces.setCwOpen(new Date());
            parkingSpaces.setCwClose(new Date());
            parkingSpaces.setCwCost(""+i);
            parkingSpaces.setCwYzId(i);
            parkingSpaces.setCwNote(""+i);
            parkingSpaces.setId(i);
            parkingSpaces.setCwId(""+i);
            parkingSpaces.setCwBuildingId(""+i);
            parkingSpaces.setCwArea(""+i);
            parkingSpacesList.add(parkingSpaces);
        }
        System.out.println("-->"+parkingSpacesService.saveParkingSpaces(parkingSpacesList));
    }

    @Test
    public void testListParkingSpaces() {
        System.out.println("-->"+parkingSpacesService.listParkingSpaces());
    }

    @Test
    public void testListParkingSpacesByParam() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setCwBuildingId("1");
        System.out.println("-->"+parkingSpacesService.listParkingSpacesByParam(parkingSpaces));
    }

    @Test
    public void testListParkingSpacesByPage() {
        PageInfoUtil<ParkingSpaces> parkingSpacesList = parkingSpacesService.listParkingSpacesByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(parkingSpacesList));
    }

    @Test
    public void testListParkingSpacesByParamAndPage() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setCwBuildingId("1");
        PageInfoUtil<ParkingSpaces> parkingSpacesList = parkingSpacesService.listParkingSpacesByParamAndPage(parkingSpaces, 1, 2);
        System.out.println("-->"+JSON.toJSONString(parkingSpacesList));
    }

    @Test
    public void testDeleteParkingSpacesByParam() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setCwBuildingId("1");
        System.out.println("-->"+parkingSpacesService.deleteParkingSpacesByParam(parkingSpaces));
    }

    @Test
    public void testUpdateParkingSpacesByKey() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setId(1);
        parkingSpaces.setCwBuildingId("1");
        parkingSpaces.setCwId("1");
        parkingSpaces.setCwArea("1");
        parkingSpaces.setCwOpen(new Date());
        parkingSpaces.setCwNote("1");
        parkingSpaces.setCwClose(new Date());
        parkingSpaces.setCwYzId(1);
        parkingSpaces.setCwCost("1");
        System.out.println("-->"+parkingSpacesService.updateParkingSpacesByKey(parkingSpaces));
    }

    @Test
    public void testUpdateBatchParkingSpacesByKey() {
        List<ParkingSpaces> parkingSpacesList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            ParkingSpaces parkingSpaces = new ParkingSpaces();
            parkingSpaces.setId(i-5);
            parkingSpaces.setCwBuildingId(""+i);
            parkingSpaces.setCwId(""+i);
            parkingSpaces.setCwArea(""+i);
            parkingSpaces.setCwOpen(new Date());
            parkingSpaces.setCwNote(""+i);
            parkingSpaces.setCwClose(new Date());
            parkingSpaces.setCwYzId(i);
            parkingSpaces.setCwCost(""+i);
            parkingSpacesList.add(parkingSpaces);
        }
        System.out.println("-->"+parkingSpacesService.updateParkingSpacesByKey(parkingSpacesList));
    }


    @Test
    public void testGetParkingSpacesByKey() {
        int parkingSpacesPK = 1;
        System.out.println("-->"+parkingSpacesService.getParkingSpacesByKey(parkingSpacesPK));
    }

    @Test
    public void testListParkingSpacesByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+parkingSpacesService.listParkingSpacesByKey(keyList));
    }

    @Test
    public void testDeleteParkingSpacesByKey() {
        int parkingSpacesPK = 1;
        System.out.println("-->"+parkingSpacesService.deleteParkingSpacesByKey(parkingSpacesPK));
    }

    @Test
    public void testDeleteBatchParkingSpacesByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+parkingSpacesService.deleteParkingSpacesByKey(keyList));
    }

}
