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

import com.jingye.entity.PropertyCosts;
import com.jingye.service.PropertyCostsService;

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
public class PropertyCostsTest {

    @Autowired
    PropertyCostsService propertyCostsService;

    @Test
    public void testSavePropertyCosts() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setPcBtId(1);
        propertyCosts.setPcCharge(""+1);
        propertyCosts.setPcNote(""+1);
        propertyCosts.setId(1);
        System.out.println("-->"+propertyCostsService.savePropertyCosts(propertyCosts));
    }

    @Test
    public void testBatchSavePropertyCosts() {
        List<PropertyCosts> propertyCostsList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            PropertyCosts propertyCosts = new PropertyCosts();
            propertyCosts.setPcBtId(i);
            propertyCosts.setPcCharge(""+i);
            propertyCosts.setPcNote(""+i);
            propertyCosts.setId(i);
            propertyCostsList.add(propertyCosts);
        }
        System.out.println("-->"+propertyCostsService.savePropertyCosts(propertyCostsList));
    }

    @Test
    public void testListPropertyCosts() {
        System.out.println("-->"+propertyCostsService.listPropertyCosts());
    }

    @Test
    public void testListPropertyCostsByParam() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setPcBtId(1);
        System.out.println("-->"+propertyCostsService.listPropertyCostsByParam(propertyCosts));
    }

    @Test
    public void testListPropertyCostsByPage() {
        PageInfoUtil<PropertyCosts> propertyCostsList = propertyCostsService.listPropertyCostsByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(propertyCostsList));
    }

    @Test
    public void testListPropertyCostsByParamAndPage() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setPcBtId(1);
        PageInfoUtil<PropertyCosts> propertyCostsList = propertyCostsService.listPropertyCostsByParamAndPage(propertyCosts, 1, 2);
        System.out.println("-->"+JSON.toJSONString(propertyCostsList));
    }

    @Test
    public void testDeletePropertyCostsByParam() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setPcBtId(1);
        System.out.println("-->"+propertyCostsService.deletePropertyCostsByParam(propertyCosts));
    }

    @Test
    public void testUpdatePropertyCostsByKey() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setId(1);
        propertyCosts.setPcBtId(1);
        propertyCosts.setPcNote("1");
        propertyCosts.setPcCharge("1");
        System.out.println("-->"+propertyCostsService.updatePropertyCostsByKey(propertyCosts));
    }

    @Test
    public void testUpdateBatchPropertyCostsByKey() {
        List<PropertyCosts> propertyCostsList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            PropertyCosts propertyCosts = new PropertyCosts();
            propertyCosts.setId(i-5);
            propertyCosts.setPcBtId(i);
            propertyCosts.setPcNote(""+i);
            propertyCosts.setPcCharge(""+i);
            propertyCostsList.add(propertyCosts);
        }
        System.out.println("-->"+propertyCostsService.updatePropertyCostsByKey(propertyCostsList));
    }


    @Test
    public void testGetPropertyCostsByKey() {
        int propertyCostsPK = 1;
        System.out.println("-->"+propertyCostsService.getPropertyCostsByKey(propertyCostsPK));
    }

    @Test
    public void testListPropertyCostsByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+propertyCostsService.listPropertyCostsByKey(keyList));
    }

    @Test
    public void testDeletePropertyCostsByKey() {
        int propertyCostsPK = 1;
        System.out.println("-->"+propertyCostsService.deletePropertyCostsByKey(propertyCostsPK));
    }

    @Test
    public void testDeleteBatchPropertyCostsByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+propertyCostsService.deletePropertyCostsByKey(keyList));
    }

}
