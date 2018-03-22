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

import com.jingye.entity.Equipment;
import com.jingye.service.EquipmentService;

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
public class EquipmentTest {

    @Autowired
    EquipmentService equipmentService;

    @Test
    public void testSaveEquipment() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentInfo(""+1);
        equipment.setEquipmentName(""+1);
        equipment.setEquipmentId(1);
        equipment.setEquipmentNumber(1);
        equipment.setEquipmentCycle(""+1);
        equipment.setEquipmentProduce(""+1);
        equipment.setEquipmentVendor(""+1);
        System.out.println("-->"+equipmentService.saveEquipment(equipment));
    }

    @Test
    public void testBatchSaveEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Equipment equipment = new Equipment();
            equipment.setEquipmentInfo(""+i);
            equipment.setEquipmentName(""+i);
            equipment.setEquipmentId(i);
            equipment.setEquipmentNumber(i);
            equipment.setEquipmentCycle(""+i);
            equipment.setEquipmentProduce(""+i);
            equipment.setEquipmentVendor(""+i);
            equipmentList.add(equipment);
        }
        System.out.println("-->"+equipmentService.saveEquipment(equipmentList));
    }

    @Test
    public void testListEquipment() {
        System.out.println("-->"+equipmentService.listEquipment());
    }

    @Test
    public void testListEquipmentByParam() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentCycle("1");
        System.out.println("-->"+equipmentService.listEquipmentByParam(equipment));
    }

    @Test
    public void testListEquipmentByPage() {
        PageInfoUtil<Equipment> equipmentList = equipmentService.listEquipmentByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(equipmentList));
    }

    @Test
    public void testListEquipmentByParamAndPage() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentCycle("1");
        PageInfoUtil<Equipment> equipmentList = equipmentService.listEquipmentByParamAndPage(equipment, 1, 2);
        System.out.println("-->"+JSON.toJSONString(equipmentList));
    }

    @Test
    public void testDeleteEquipmentByParam() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentCycle("1");
        System.out.println("-->"+equipmentService.deleteEquipmentByParam(equipment));
    }

    @Test
    public void testUpdateEquipmentByKey() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentId(1);
        equipment.setEquipmentCycle("1");
        equipment.setEquipmentInfo("1");
        equipment.setEquipmentName("1");
        equipment.setEquipmentNumber(1);
        equipment.setEquipmentVendor("1");
        equipment.setEquipmentProduce("1");
        System.out.println("-->"+equipmentService.updateEquipmentByKey(equipment));
    }

    @Test
    public void testUpdateBatchEquipmentByKey() {
        List<Equipment> equipmentList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Equipment equipment = new Equipment();
            equipment.setEquipmentId(i-5);
            equipment.setEquipmentCycle(""+i);
            equipment.setEquipmentInfo(""+i);
            equipment.setEquipmentName(""+i);
            equipment.setEquipmentNumber(i);
            equipment.setEquipmentVendor(""+i);
            equipment.setEquipmentProduce(""+i);
            equipmentList.add(equipment);
        }
        System.out.println("-->"+equipmentService.updateEquipmentByKey(equipmentList));
    }


    @Test
    public void testGetEquipmentByKey() {
        int equipmentPK = 1;
        System.out.println("-->"+equipmentService.getEquipmentByKey(equipmentPK));
    }

    @Test
    public void testListEquipmentByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+equipmentService.listEquipmentByKey(keyList));
    }

    @Test
    public void testDeleteEquipmentByKey() {
        int equipmentPK = 1;
        System.out.println("-->"+equipmentService.deleteEquipmentByKey(equipmentPK));
    }

    @Test
    public void testDeleteBatchEquipmentByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+equipmentService.deleteEquipmentByKey(keyList));
    }

}
