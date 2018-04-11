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

import com.jingye.entity.YzInfo;
import com.jingye.service.YzInfoService;

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
public class YzInfoTest {

    @Autowired
    YzInfoService yzInfoService;

    @Test
    public void testSaveYzInfo() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzPassword(""+1);
        yzInfo.setYzBuildingId(""+1);
        yzInfo.setYzNote(""+1);
        yzInfo.setYzId(1);
        yzInfo.setYzBirthday(new Date());
        yzInfo.setYzName(""+1);
        yzInfo.setYzSex(""+1);
        yzInfo.setYzRoomId(""+1);
        yzInfo.setYzLogin(""+1);
        yzInfo.setYzTel(""+1);
        System.out.println("-->"+yzInfoService.saveYzInfo(yzInfo));
    }

    @Test
    public void testBatchSaveYzInfo() {
        List<YzInfo> yzInfoList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            YzInfo yzInfo = new YzInfo();
            yzInfo.setYzPassword(""+i);
            yzInfo.setYzBuildingId(""+i);
            yzInfo.setYzNote(""+i);
            yzInfo.setYzId(i);
            yzInfo.setYzBirthday(new Date());
            yzInfo.setYzName(""+i);
            yzInfo.setYzSex(""+i);
            yzInfo.setYzRoomId(""+i);
            yzInfo.setYzLogin(""+i);
            yzInfo.setYzTel(""+i);
            yzInfoList.add(yzInfo);
        }
        System.out.println("-->"+yzInfoService.saveYzInfo(yzInfoList));
    }

    @Test
    public void testListYzInfo() {
        System.out.println("-->"+yzInfoService.listYzInfo());
    }

    @Test
    public void testListYzInfoByParam() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzBirthday(new Date());
        System.out.println("-->"+yzInfoService.listYzInfoByParam(yzInfo));
    }

    @Test
    public void testListYzInfoByPage() {
        PageInfoUtil<YzInfo> yzInfoList = yzInfoService.listYzInfoByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(yzInfoList));
    }

    @Test
    public void testListYzInfoByParamAndPage() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzBirthday(new Date());
        PageInfoUtil<YzInfo> yzInfoList = yzInfoService.listYzInfoByParamAndPage(yzInfo, 1, 2);
        System.out.println("-->"+JSON.toJSONString(yzInfoList));
    }

    @Test
    public void testDeleteYzInfoByParam() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzBirthday(new Date());
        System.out.println("-->"+yzInfoService.deleteYzInfoByParam(yzInfo));
    }

    @Test
    public void testUpdateYzInfoByKey() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzId(1);
        yzInfo.setYzBirthday(new Date());
        yzInfo.setYzTel("1");
        yzInfo.setYzRoomId("1");
        yzInfo.setYzPassword("1");
        yzInfo.setYzSex("1");
        yzInfo.setYzLogin("1");
        yzInfo.setYzNote("1");
        yzInfo.setYzBuildingId("1");
        yzInfo.setYzName("1");
        System.out.println("-->"+yzInfoService.updateYzInfoByKey(yzInfo));
    }

    @Test
    public void testUpdateBatchYzInfoByKey() {
        List<YzInfo> yzInfoList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            YzInfo yzInfo = new YzInfo();
            yzInfo.setYzId(i-5);
            yzInfo.setYzBirthday(new Date());
            yzInfo.setYzTel(""+i);
            yzInfo.setYzRoomId(""+i);
            yzInfo.setYzPassword(""+i);
            yzInfo.setYzSex(""+i);
            yzInfo.setYzLogin(""+i);
            yzInfo.setYzNote(""+i);
            yzInfo.setYzBuildingId(""+i);
            yzInfo.setYzName(""+i);
            yzInfoList.add(yzInfo);
        }
        System.out.println("-->"+yzInfoService.updateYzInfoByKey(yzInfoList));
    }


    @Test
    public void testGetYzInfoByKey() {
        int yzInfoPK = 1;
        System.out.println("-->"+yzInfoService.getYzInfoByKey(yzInfoPK));
    }

    @Test
    public void testListYzInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+yzInfoService.listYzInfoByKey(keyList));
    }

    @Test
    public void testDeleteYzInfoByKey() {
        int yzInfoPK = 1;
        System.out.println("-->"+yzInfoService.deleteYzInfoByKey(yzInfoPK));
    }

    @Test
    public void testDeleteBatchYzInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+yzInfoService.deleteYzInfoByKey(keyList));
    }

}
