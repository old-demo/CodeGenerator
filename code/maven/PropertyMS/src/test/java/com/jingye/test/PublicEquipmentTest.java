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

import com.jingye.entity.PublicEquipment;
import com.jingye.service.PublicEquipmentService;

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
public class PublicEquipmentTest {

    @Autowired
    PublicEquipmentService publicEquipmentService;

    @Test
    public void testSavePublicEquipment() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setEqpName(""+1);
        publicEquipment.setEqpOpenDate(new Date());
        publicEquipment.setEqpStatus(""+1);
        publicEquipment.setId(1);
        publicEquipment.setEqpBdId(""+1);
        publicEquipment.setEqpId(""+1);
        publicEquipment.setEqpSpecification(""+1);
        publicEquipment.setEqpNote(""+1);
        publicEquipment.setEqpFloor(""+1);
        publicEquipment.setEqpValue(""+1);
        publicEquipment.setEqpAdminId(1);
        System.out.println("-->"+publicEquipmentService.savePublicEquipment(publicEquipment));
    }

    @Test
    public void testBatchSavePublicEquipment() {
        List<PublicEquipment> publicEquipmentList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            PublicEquipment publicEquipment = new PublicEquipment();
            publicEquipment.setEqpName(""+i);
            publicEquipment.setEqpOpenDate(new Date());
            publicEquipment.setEqpStatus(""+i);
            publicEquipment.setId(i);
            publicEquipment.setEqpBdId(""+i);
            publicEquipment.setEqpId(""+i);
            publicEquipment.setEqpSpecification(""+i);
            publicEquipment.setEqpNote(""+i);
            publicEquipment.setEqpFloor(""+i);
            publicEquipment.setEqpValue(""+i);
            publicEquipment.setEqpAdminId(i);
            publicEquipmentList.add(publicEquipment);
        }
        System.out.println("-->"+publicEquipmentService.savePublicEquipment(publicEquipmentList));
    }

    @Test
    public void testListPublicEquipment() {
        System.out.println("-->"+publicEquipmentService.listPublicEquipment());
    }

    @Test
    public void testListPublicEquipmentByParam() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setEqpId("1");
        System.out.println("-->"+publicEquipmentService.listPublicEquipmentByParam(publicEquipment));
    }

    @Test
    public void testListPublicEquipmentByPage() {
        PageInfoUtil<PublicEquipment> publicEquipmentList = publicEquipmentService.listPublicEquipmentByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(publicEquipmentList));
    }

    @Test
    public void testListPublicEquipmentByParamAndPage() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setEqpId("1");
        PageInfoUtil<PublicEquipment> publicEquipmentList = publicEquipmentService.listPublicEquipmentByParamAndPage(publicEquipment, 1, 2);
        System.out.println("-->"+JSON.toJSONString(publicEquipmentList));
    }

    @Test
    public void testDeletePublicEquipmentByParam() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setEqpId("1");
        System.out.println("-->"+publicEquipmentService.deletePublicEquipmentByParam(publicEquipment));
    }

    @Test
    public void testUpdatePublicEquipmentByKey() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setId(1);
        publicEquipment.setEqpId("1");
        publicEquipment.setEqpName("1");
        publicEquipment.setEqpSpecification("1");
        publicEquipment.setEqpFloor("1");
        publicEquipment.setEqpOpenDate(new Date());
        publicEquipment.setEqpNote("1");
        publicEquipment.setEqpStatus("1");
        publicEquipment.setEqpAdminId(1);
        publicEquipment.setEqpBdId("1");
        publicEquipment.setEqpValue("1");
        System.out.println("-->"+publicEquipmentService.updatePublicEquipmentByKey(publicEquipment));
    }

    @Test
    public void testUpdateBatchPublicEquipmentByKey() {
        List<PublicEquipment> publicEquipmentList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            PublicEquipment publicEquipment = new PublicEquipment();
            publicEquipment.setId(i-5);
            publicEquipment.setEqpId(""+i);
            publicEquipment.setEqpName(""+i);
            publicEquipment.setEqpSpecification(""+i);
            publicEquipment.setEqpFloor(""+i);
            publicEquipment.setEqpOpenDate(new Date());
            publicEquipment.setEqpNote(""+i);
            publicEquipment.setEqpStatus(""+i);
            publicEquipment.setEqpAdminId(i);
            publicEquipment.setEqpBdId(""+i);
            publicEquipment.setEqpValue(""+i);
            publicEquipmentList.add(publicEquipment);
        }
        System.out.println("-->"+publicEquipmentService.updatePublicEquipmentByKey(publicEquipmentList));
    }


    @Test
    public void testGetPublicEquipmentByKey() {
        int publicEquipmentPK = 1;
        System.out.println("-->"+publicEquipmentService.getPublicEquipmentByKey(publicEquipmentPK));
    }

    @Test
    public void testListPublicEquipmentByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+publicEquipmentService.listPublicEquipmentByKey(keyList));
    }

    @Test
    public void testDeletePublicEquipmentByKey() {
        int publicEquipmentPK = 1;
        System.out.println("-->"+publicEquipmentService.deletePublicEquipmentByKey(publicEquipmentPK));
    }

    @Test
    public void testDeleteBatchPublicEquipmentByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+publicEquipmentService.deletePublicEquipmentByKey(keyList));
    }

}
