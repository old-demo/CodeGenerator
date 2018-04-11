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

import com.jingye.entity.ComplaintsInfo;
import com.jingye.service.ComplaintsInfoService;

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
public class ComplaintsInfoTest {

    @Autowired
    ComplaintsInfoService complaintsInfoService;

    @Test
    public void testSaveComplaintsInfo() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setCpTime(new Date());
        complaintsInfo.setCpNote(""+1);
        complaintsInfo.setCpYzId(1);
        complaintsInfo.setCpResult(""+1);
        complaintsInfo.setId(1);
        complaintsInfo.setCpContent(""+1);
        System.out.println("-->"+complaintsInfoService.saveComplaintsInfo(complaintsInfo));
    }

    @Test
    public void testBatchSaveComplaintsInfo() {
        List<ComplaintsInfo> complaintsInfoList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            ComplaintsInfo complaintsInfo = new ComplaintsInfo();
            complaintsInfo.setCpTime(new Date());
            complaintsInfo.setCpNote(""+i);
            complaintsInfo.setCpYzId(i);
            complaintsInfo.setCpResult(""+i);
            complaintsInfo.setId(i);
            complaintsInfo.setCpContent(""+i);
            complaintsInfoList.add(complaintsInfo);
        }
        System.out.println("-->"+complaintsInfoService.saveComplaintsInfo(complaintsInfoList));
    }

    @Test
    public void testListComplaintsInfo() {
        System.out.println("-->"+complaintsInfoService.listComplaintsInfo());
    }

    @Test
    public void testListComplaintsInfoByParam() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setCpResult("1");
        System.out.println("-->"+complaintsInfoService.listComplaintsInfoByParam(complaintsInfo));
    }

    @Test
    public void testListComplaintsInfoByPage() {
        PageInfoUtil<ComplaintsInfo> complaintsInfoList = complaintsInfoService.listComplaintsInfoByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(complaintsInfoList));
    }

    @Test
    public void testListComplaintsInfoByParamAndPage() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setCpResult("1");
        PageInfoUtil<ComplaintsInfo> complaintsInfoList = complaintsInfoService.listComplaintsInfoByParamAndPage(complaintsInfo, 1, 2);
        System.out.println("-->"+JSON.toJSONString(complaintsInfoList));
    }

    @Test
    public void testDeleteComplaintsInfoByParam() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setCpResult("1");
        System.out.println("-->"+complaintsInfoService.deleteComplaintsInfoByParam(complaintsInfo));
    }

    @Test
    public void testUpdateComplaintsInfoByKey() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setId(1);
        complaintsInfo.setCpResult("1");
        complaintsInfo.setCpTime(new Date());
        complaintsInfo.setCpContent("1");
        complaintsInfo.setCpNote("1");
        complaintsInfo.setCpYzId(1);
        System.out.println("-->"+complaintsInfoService.updateComplaintsInfoByKey(complaintsInfo));
    }

    @Test
    public void testUpdateBatchComplaintsInfoByKey() {
        List<ComplaintsInfo> complaintsInfoList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            ComplaintsInfo complaintsInfo = new ComplaintsInfo();
            complaintsInfo.setId(i-5);
            complaintsInfo.setCpResult(""+i);
            complaintsInfo.setCpTime(new Date());
            complaintsInfo.setCpContent(""+i);
            complaintsInfo.setCpNote(""+i);
            complaintsInfo.setCpYzId(i);
            complaintsInfoList.add(complaintsInfo);
        }
        System.out.println("-->"+complaintsInfoService.updateComplaintsInfoByKey(complaintsInfoList));
    }


    @Test
    public void testGetComplaintsInfoByKey() {
        int complaintsInfoPK = 1;
        System.out.println("-->"+complaintsInfoService.getComplaintsInfoByKey(complaintsInfoPK));
    }

    @Test
    public void testListComplaintsInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+complaintsInfoService.listComplaintsInfoByKey(keyList));
    }

    @Test
    public void testDeleteComplaintsInfoByKey() {
        int complaintsInfoPK = 1;
        System.out.println("-->"+complaintsInfoService.deleteComplaintsInfoByKey(complaintsInfoPK));
    }

    @Test
    public void testDeleteBatchComplaintsInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+complaintsInfoService.deleteComplaintsInfoByKey(keyList));
    }

}
