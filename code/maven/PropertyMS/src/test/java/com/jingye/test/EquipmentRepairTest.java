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

import com.jingye.entity.EquipmentRepair;
import com.jingye.service.EquipmentRepairService;

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
public class EquipmentRepairTest {

    @Autowired
    EquipmentRepairService equipmentRepairService;

    @Test
    public void testSaveEquipmentRepair() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setWarContent(""+1);
        equipmentRepair.setWarYzId(1);
        equipmentRepair.setWarTime(new Date());
        equipmentRepair.setWarStatus(""+1);
        equipmentRepair.setId(1);
        equipmentRepair.setWarNote(""+1);
        System.out.println("-->"+equipmentRepairService.saveEquipmentRepair(equipmentRepair));
    }

    @Test
    public void testBatchSaveEquipmentRepair() {
        List<EquipmentRepair> equipmentRepairList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            EquipmentRepair equipmentRepair = new EquipmentRepair();
            equipmentRepair.setWarContent(""+i);
            equipmentRepair.setWarYzId(i);
            equipmentRepair.setWarTime(new Date());
            equipmentRepair.setWarStatus(""+i);
            equipmentRepair.setId(i);
            equipmentRepair.setWarNote(""+i);
            equipmentRepairList.add(equipmentRepair);
        }
        System.out.println("-->"+equipmentRepairService.saveEquipmentRepair(equipmentRepairList));
    }

    @Test
    public void testListEquipmentRepair() {
        System.out.println("-->"+equipmentRepairService.listEquipmentRepair());
    }

    @Test
    public void testListEquipmentRepairByParam() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setWarNote("1");
        System.out.println("-->"+equipmentRepairService.listEquipmentRepairByParam(equipmentRepair));
    }

    @Test
    public void testListEquipmentRepairByPage() {
        PageInfoUtil<EquipmentRepair> equipmentRepairList = equipmentRepairService.listEquipmentRepairByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(equipmentRepairList));
    }

    @Test
    public void testListEquipmentRepairByParamAndPage() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setWarNote("1");
        PageInfoUtil<EquipmentRepair> equipmentRepairList = equipmentRepairService.listEquipmentRepairByParamAndPage(equipmentRepair, 1, 2);
        System.out.println("-->"+JSON.toJSONString(equipmentRepairList));
    }

    @Test
    public void testDeleteEquipmentRepairByParam() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setWarNote("1");
        System.out.println("-->"+equipmentRepairService.deleteEquipmentRepairByParam(equipmentRepair));
    }

    @Test
    public void testUpdateEquipmentRepairByKey() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setId(1);
        equipmentRepair.setWarNote("1");
        equipmentRepair.setWarTime(new Date());
        equipmentRepair.setWarYzId(1);
        equipmentRepair.setWarContent("1");
        equipmentRepair.setWarStatus("1");
        System.out.println("-->"+equipmentRepairService.updateEquipmentRepairByKey(equipmentRepair));
    }

    @Test
    public void testUpdateBatchEquipmentRepairByKey() {
        List<EquipmentRepair> equipmentRepairList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            EquipmentRepair equipmentRepair = new EquipmentRepair();
            equipmentRepair.setId(i-5);
            equipmentRepair.setWarNote(""+i);
            equipmentRepair.setWarTime(new Date());
            equipmentRepair.setWarYzId(i);
            equipmentRepair.setWarContent(""+i);
            equipmentRepair.setWarStatus(""+i);
            equipmentRepairList.add(equipmentRepair);
        }
        System.out.println("-->"+equipmentRepairService.updateEquipmentRepairByKey(equipmentRepairList));
    }


    @Test
    public void testGetEquipmentRepairByKey() {
        int equipmentRepairPK = 1;
        System.out.println("-->"+equipmentRepairService.getEquipmentRepairByKey(equipmentRepairPK));
    }

    @Test
    public void testListEquipmentRepairByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+equipmentRepairService.listEquipmentRepairByKey(keyList));
    }

    @Test
    public void testDeleteEquipmentRepairByKey() {
        int equipmentRepairPK = 1;
        System.out.println("-->"+equipmentRepairService.deleteEquipmentRepairByKey(equipmentRepairPK));
    }

    @Test
    public void testDeleteBatchEquipmentRepairByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+equipmentRepairService.deleteEquipmentRepairByKey(keyList));
    }

}
