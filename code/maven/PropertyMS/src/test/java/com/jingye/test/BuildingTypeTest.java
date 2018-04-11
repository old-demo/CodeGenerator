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

import com.jingye.entity.BuildingType;
import com.jingye.service.BuildingTypeService;

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
public class BuildingTypeTest {

    @Autowired
    BuildingTypeService buildingTypeService;

    @Test
    public void testSaveBuildingType() {
        BuildingType buildingType = new BuildingType();
        buildingType.setId(1);
        buildingType.setBtNote(""+1);
        buildingType.setBtName(""+1);
        buildingType.setBtRoomNumber(1);
        System.out.println("-->"+buildingTypeService.saveBuildingType(buildingType));
    }

    @Test
    public void testBatchSaveBuildingType() {
        List<BuildingType> buildingTypeList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            BuildingType buildingType = new BuildingType();
            buildingType.setId(i);
            buildingType.setBtNote(""+i);
            buildingType.setBtName(""+i);
            buildingType.setBtRoomNumber(i);
            buildingTypeList.add(buildingType);
        }
        System.out.println("-->"+buildingTypeService.saveBuildingType(buildingTypeList));
    }

    @Test
    public void testListBuildingType() {
        System.out.println("-->"+buildingTypeService.listBuildingType());
    }

    @Test
    public void testListBuildingTypeByParam() {
        BuildingType buildingType = new BuildingType();
        buildingType.setBtRoomNumber(1);
        System.out.println("-->"+buildingTypeService.listBuildingTypeByParam(buildingType));
    }

    @Test
    public void testListBuildingTypeByPage() {
        PageInfoUtil<BuildingType> buildingTypeList = buildingTypeService.listBuildingTypeByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingTypeList));
    }

    @Test
    public void testListBuildingTypeByParamAndPage() {
        BuildingType buildingType = new BuildingType();
        buildingType.setBtRoomNumber(1);
        PageInfoUtil<BuildingType> buildingTypeList = buildingTypeService.listBuildingTypeByParamAndPage(buildingType, 1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingTypeList));
    }

    @Test
    public void testDeleteBuildingTypeByParam() {
        BuildingType buildingType = new BuildingType();
        buildingType.setBtRoomNumber(1);
        System.out.println("-->"+buildingTypeService.deleteBuildingTypeByParam(buildingType));
    }

    @Test
    public void testUpdateBuildingTypeByKey() {
        BuildingType buildingType = new BuildingType();
        buildingType.setId(1);
        buildingType.setBtRoomNumber(1);
        buildingType.setBtName("1");
        buildingType.setBtNote("1");
        System.out.println("-->"+buildingTypeService.updateBuildingTypeByKey(buildingType));
    }

    @Test
    public void testUpdateBatchBuildingTypeByKey() {
        List<BuildingType> buildingTypeList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            BuildingType buildingType = new BuildingType();
            buildingType.setId(i-5);
            buildingType.setBtRoomNumber(i);
            buildingType.setBtName(""+i);
            buildingType.setBtNote(""+i);
            buildingTypeList.add(buildingType);
        }
        System.out.println("-->"+buildingTypeService.updateBuildingTypeByKey(buildingTypeList));
    }


    @Test
    public void testGetBuildingTypeByKey() {
        int buildingTypePK = 1;
        System.out.println("-->"+buildingTypeService.getBuildingTypeByKey(buildingTypePK));
    }

    @Test
    public void testListBuildingTypeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingTypeService.listBuildingTypeByKey(keyList));
    }

    @Test
    public void testDeleteBuildingTypeByKey() {
        int buildingTypePK = 1;
        System.out.println("-->"+buildingTypeService.deleteBuildingTypeByKey(buildingTypePK));
    }

    @Test
    public void testDeleteBatchBuildingTypeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingTypeService.deleteBuildingTypeByKey(keyList));
    }

}
