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

import com.jingye.entity.Owner;
import com.jingye.service.OwnerService;

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
public class OwnerTest {

    @Autowired
    OwnerService ownerService;

    @Test
    public void testSaveOwner() {
        Owner owner = new Owner();
        owner.setYzInfo(""+1);
        owner.setYzPhone(""+1);
        owner.setYzName(""+1);
        owner.setYzSex(""+1);
        owner.setYzId(1);
        System.out.println("-->"+ownerService.saveOwner(owner));
    }

    @Test
    public void testBatchSaveOwner() {
        List<Owner> ownerList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Owner owner = new Owner();
            owner.setYzInfo(""+i);
            owner.setYzPhone(""+i);
            owner.setYzName(""+i);
            owner.setYzSex(""+i);
            owner.setYzId(i);
            ownerList.add(owner);
        }
        System.out.println("-->"+ownerService.saveOwner(ownerList));
    }

    @Test
    public void testListOwner() {
        System.out.println("-->"+ownerService.listOwner());
    }

    @Test
    public void testListOwnerByParam() {
        Owner owner = new Owner();
        owner.setYzSex("1");
        System.out.println("-->"+ownerService.listOwnerByParam(owner));
    }

    @Test
    public void testListOwnerByPage() {
        PageInfoUtil<Owner> ownerList = ownerService.listOwnerByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(ownerList));
    }

    @Test
    public void testListOwnerByParamAndPage() {
        Owner owner = new Owner();
        owner.setYzSex("1");
        PageInfoUtil<Owner> ownerList = ownerService.listOwnerByParamAndPage(owner, 1, 2);
        System.out.println("-->"+JSON.toJSONString(ownerList));
    }

    @Test
    public void testDeleteOwnerByParam() {
        Owner owner = new Owner();
        owner.setYzSex("1");
        System.out.println("-->"+ownerService.deleteOwnerByParam(owner));
    }

    @Test
    public void testUpdateOwnerByKey() {
        Owner owner = new Owner();
        owner.setYzId(1);
        owner.setYzSex("1");
        owner.setYzName("1");
        owner.setYzInfo("1");
        owner.setYzPhone("1");
        System.out.println("-->"+ownerService.updateOwnerByKey(owner));
    }

    @Test
    public void testUpdateBatchOwnerByKey() {
        List<Owner> ownerList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Owner owner = new Owner();
            owner.setYzId(i-5);
            owner.setYzSex(""+i);
            owner.setYzName(""+i);
            owner.setYzInfo(""+i);
            owner.setYzPhone(""+i);
            ownerList.add(owner);
        }
        System.out.println("-->"+ownerService.updateOwnerByKey(ownerList));
    }


    @Test
    public void testGetOwnerByKey() {
        int ownerPK = 1;
        System.out.println("-->"+ownerService.getOwnerByKey(ownerPK));
    }

    @Test
    public void testListOwnerByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+ownerService.listOwnerByKey(keyList));
    }

    @Test
    public void testDeleteOwnerByKey() {
        int ownerPK = 1;
        System.out.println("-->"+ownerService.deleteOwnerByKey(ownerPK));
    }

    @Test
    public void testDeleteBatchOwnerByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+ownerService.deleteOwnerByKey(keyList));
    }

}
