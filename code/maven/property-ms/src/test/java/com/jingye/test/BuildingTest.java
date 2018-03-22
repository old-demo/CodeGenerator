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

import com.jingye.entity.Building;
import com.jingye.service.BuildingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@RunWith(SpringJUnit4ClassRunner.class)		// 表示继承了 SpringJUnit4ClassRunner 类
@ContextConfiguration(locations = {"classpath*:spring_core.xml","classpath:spring_mybatis.xml"})
public class BuildingTest {

    @Autowired
    BuildingService buildingService;

    @Test
    public void testSaveBuilding() {
        Building building = new Building();
        building.setBuildingId(1);
        building.setBuildingKind(""+1);
        building.setBulidingLevel(""+1);
        building.setBuildingHead(""+1);
        building.setBulidingArea(""+1);
        building.setBuildingInfo(""+1);
        System.out.println("-->"+buildingService.saveBuilding(building));
    }

    @Test
    public void testBatchSaveBuilding() {
        List<Building> buildingList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Building building = new Building();
            building.setBuildingId(i);
            building.setBuildingKind(""+i);
            building.setBulidingLevel(""+i);
            building.setBuildingHead(""+i);
            building.setBulidingArea(""+i);
            building.setBuildingInfo(""+i);
            buildingList.add(building);
        }
        System.out.println("-->"+buildingService.saveBuilding(buildingList));
    }

    @Test
    public void testListBuilding() {
        System.out.println("-->"+buildingService.listBuilding());
    }

    @Test
    public void testListBuildingByParam() {
        Building building = new Building();
        building.setBulidingLevel("1");
        System.out.println("-->"+buildingService.listBuildingByParam(building));
    }

    @Test
    public void testListBuildingByPage() {
        PageInfoUtil<Building> buildingList = buildingService.listBuildingByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingList));
    }

    @Test
    public void testListBuildingByParamAndPage() {
        Building building = new Building();
        building.setBulidingLevel("1");
        PageInfoUtil<Building> buildingList = buildingService.listBuildingByParamAndPage(building, 1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingList));
    }

    @Test
    public void testDeleteBuildingByParam() {
        Building building = new Building();
        building.setBulidingLevel("1");
        System.out.println("-->"+buildingService.deleteBuildingByParam(building));
    }

    @Test
    public void testUpdateBuildingByKey() {
        Building building = new Building();
        building.setBuildingId(1);
        building.setBulidingLevel("1");
        building.setBuildingKind("1");
        building.setBuildingHead("1");
        building.setBulidingArea("1");
        building.setBuildingInfo("1");
        System.out.println("-->"+buildingService.updateBuildingByKey(building));
    }

    @Test
    public void testUpdateBatchBuildingByKey() {
        List<Building> buildingList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Building building = new Building();
            building.setBuildingId(i-5);
            building.setBulidingLevel(""+i);
            building.setBuildingKind(""+i);
            building.setBuildingHead(""+i);
            building.setBulidingArea(""+i);
            building.setBuildingInfo(""+i);
            buildingList.add(building);
        }
        System.out.println("-->"+buildingService.updateBuildingByKey(buildingList));
    }


    @Test
    public void testGetBuildingByKey() {
        int buildingPK = 1;
        System.out.println("-->"+buildingService.getBuildingByKey(buildingPK));
    }

    @Test
    public void testListBuildingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingService.listBuildingByKey(keyList));
    }

    @Test
    public void testDeleteBuildingByKey() {
        int buildingPK = 1;
        System.out.println("-->"+buildingService.deleteBuildingByKey(buildingPK));
    }

    @Test
    public void testDeleteBatchBuildingByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingService.deleteBuildingByKey(keyList));
    }

}
