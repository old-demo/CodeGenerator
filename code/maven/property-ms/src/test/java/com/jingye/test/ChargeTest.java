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

import com.jingye.entity.Charge;
import com.jingye.service.ChargeService;

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
public class ChargeTest {

    @Autowired
    ChargeService chargeService;

    @Test
    public void testSaveCharge() {
        Charge charge = new Charge();
        charge.setChargeId(1);
        charge.setChargeName(""+1);
        charge.setChargeInfo(""+1);
        charge.setChargeMoney(""+1);
        charge.setChargeKind(""+1);
        System.out.println("-->"+chargeService.saveCharge(charge));
    }

    @Test
    public void testBatchSaveCharge() {
        List<Charge> chargeList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Charge charge = new Charge();
            charge.setChargeId(i);
            charge.setChargeName(""+i);
            charge.setChargeInfo(""+i);
            charge.setChargeMoney(""+i);
            charge.setChargeKind(""+i);
            chargeList.add(charge);
        }
        System.out.println("-->"+chargeService.saveCharge(chargeList));
    }

    @Test
    public void testListCharge() {
        System.out.println("-->"+chargeService.listCharge());
    }

    @Test
    public void testListChargeByParam() {
        Charge charge = new Charge();
        charge.setChargeKind("1");
        System.out.println("-->"+chargeService.listChargeByParam(charge));
    }

    @Test
    public void testListChargeByPage() {
        PageInfoUtil<Charge> chargeList = chargeService.listChargeByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(chargeList));
    }

    @Test
    public void testListChargeByParamAndPage() {
        Charge charge = new Charge();
        charge.setChargeKind("1");
        PageInfoUtil<Charge> chargeList = chargeService.listChargeByParamAndPage(charge, 1, 2);
        System.out.println("-->"+JSON.toJSONString(chargeList));
    }

    @Test
    public void testDeleteChargeByParam() {
        Charge charge = new Charge();
        charge.setChargeKind("1");
        System.out.println("-->"+chargeService.deleteChargeByParam(charge));
    }

    @Test
    public void testUpdateChargeByKey() {
        Charge charge = new Charge();
        charge.setChargeId(1);
        charge.setChargeKind("1");
        charge.setChargeMoney("1");
        charge.setChargeInfo("1");
        charge.setChargeName("1");
        System.out.println("-->"+chargeService.updateChargeByKey(charge));
    }

    @Test
    public void testUpdateBatchChargeByKey() {
        List<Charge> chargeList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Charge charge = new Charge();
            charge.setChargeId(i-5);
            charge.setChargeKind(""+i);
            charge.setChargeMoney(""+i);
            charge.setChargeInfo(""+i);
            charge.setChargeName(""+i);
            chargeList.add(charge);
        }
        System.out.println("-->"+chargeService.updateChargeByKey(chargeList));
    }


    @Test
    public void testGetChargeByKey() {
        int chargePK = 1;
        System.out.println("-->"+chargeService.getChargeByKey(chargePK));
    }

    @Test
    public void testListChargeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+chargeService.listChargeByKey(keyList));
    }

    @Test
    public void testDeleteChargeByKey() {
        int chargePK = 1;
        System.out.println("-->"+chargeService.deleteChargeByKey(chargePK));
    }

    @Test
    public void testDeleteBatchChargeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+chargeService.deleteChargeByKey(keyList));
    }

}
