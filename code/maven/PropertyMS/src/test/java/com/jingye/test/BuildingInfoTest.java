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

import com.jingye.entity.BuildingInfo;
import com.jingye.service.BuildingInfoService;

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
public class BuildingInfoTest {

    @Autowired
    BuildingInfoService buildingInfoService;

    @Test
    public void testSaveBuildingInfo() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setBdAdminId(1);
        buildingInfo.setBdId(""+1);
        buildingInfo.setBdKindId(1);
        buildingInfo.setBdHead(""+1);
        buildingInfo.setId(1);
        buildingInfo.setBdArea(""+1);
        buildingInfo.setBdNote(""+1);
        System.out.println("-->"+buildingInfoService.saveBuildingInfo(buildingInfo));
    }

    @Test
    public void testBatchSaveBuildingInfo() {
        List<BuildingInfo> buildingInfoList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            BuildingInfo buildingInfo = new BuildingInfo();
            buildingInfo.setBdAdminId(i);
            buildingInfo.setBdId(""+i);
            buildingInfo.setBdKindId(i);
            buildingInfo.setBdHead(""+i);
            buildingInfo.setId(i);
            buildingInfo.setBdArea(""+i);
            buildingInfo.setBdNote(""+i);
            buildingInfoList.add(buildingInfo);
        }
        System.out.println("-->"+buildingInfoService.saveBuildingInfo(buildingInfoList));
    }

    @Test
    public void testListBuildingInfo() {
        System.out.println("-->"+buildingInfoService.listBuildingInfo());
    }

    @Test
    public void testListBuildingInfoByParam() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setBdNote("1");
        System.out.println("-->"+buildingInfoService.listBuildingInfoByParam(buildingInfo));
    }

    @Test
    public void testListBuildingInfoByPage() {
        PageInfoUtil<BuildingInfo> buildingInfoList = buildingInfoService.listBuildingInfoByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingInfoList));
    }

    @Test
    public void testListBuildingInfoByParamAndPage() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setBdNote("1");
        PageInfoUtil<BuildingInfo> buildingInfoList = buildingInfoService.listBuildingInfoByParamAndPage(buildingInfo, 1, 2);
        System.out.println("-->"+JSON.toJSONString(buildingInfoList));
    }

    @Test
    public void testDeleteBuildingInfoByParam() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setBdNote("1");
        System.out.println("-->"+buildingInfoService.deleteBuildingInfoByParam(buildingInfo));
    }

    @Test
    public void testUpdateBuildingInfoByKey() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setId(1);
        buildingInfo.setBdNote("1");
        buildingInfo.setBdHead("1");
        buildingInfo.setBdId("1");
        buildingInfo.setBdArea("1");
        buildingInfo.setBdKindId(1);
        buildingInfo.setBdAdminId(1);
        System.out.println("-->"+buildingInfoService.updateBuildingInfoByKey(buildingInfo));
    }

    @Test
    public void testUpdateBatchBuildingInfoByKey() {
        List<BuildingInfo> buildingInfoList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            BuildingInfo buildingInfo = new BuildingInfo();
            buildingInfo.setId(i-5);
            buildingInfo.setBdNote(""+i);
            buildingInfo.setBdHead(""+i);
            buildingInfo.setBdId(""+i);
            buildingInfo.setBdArea(""+i);
            buildingInfo.setBdKindId(i);
            buildingInfo.setBdAdminId(i);
            buildingInfoList.add(buildingInfo);
        }
        System.out.println("-->"+buildingInfoService.updateBuildingInfoByKey(buildingInfoList));
    }


    @Test
    public void testGetBuildingInfoByKey() {
        int buildingInfoPK = 1;
        System.out.println("-->"+buildingInfoService.getBuildingInfoByKey(buildingInfoPK));
    }

    @Test
    public void testListBuildingInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingInfoService.listBuildingInfoByKey(keyList));
    }

    @Test
    public void testDeleteBuildingInfoByKey() {
        int buildingInfoPK = 1;
        System.out.println("-->"+buildingInfoService.deleteBuildingInfoByKey(buildingInfoPK));
    }

    @Test
    public void testDeleteBatchBuildingInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+buildingInfoService.deleteBuildingInfoByKey(keyList));
    }

}
