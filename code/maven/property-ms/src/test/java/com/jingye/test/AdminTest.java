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

import com.jingye.entity.Admin;
import com.jingye.service.AdminService;

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
public class AdminTest {

    @Autowired
    AdminService adminService;

    @Test
    public void testSaveAdmin() {
        Admin admin = new Admin();
        admin.setAdInfo(""+1);
        admin.setAdAge(""+1);
        admin.setAdName(""+1);
        admin.setAdSex(""+1);
        admin.setAdId(1);
        System.out.println("-->"+adminService.saveAdmin(admin));
    }

    @Test
    public void testBatchSaveAdmin() {
        List<Admin> adminList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Admin admin = new Admin();
            admin.setAdInfo(""+i);
            admin.setAdAge(""+i);
            admin.setAdName(""+i);
            admin.setAdSex(""+i);
            admin.setAdId(i);
            adminList.add(admin);
        }
        System.out.println("-->"+adminService.saveAdmin(adminList));
    }

    @Test
    public void testListAdmin() {
        System.out.println("-->"+adminService.listAdmin());
    }

    @Test
    public void testListAdminByParam() {
        Admin admin = new Admin();
        admin.setAdInfo("1");
        System.out.println("-->"+adminService.listAdminByParam(admin));
    }

    @Test
    public void testListAdminByPage() {
        PageInfoUtil<Admin> adminList = adminService.listAdminByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(adminList));
    }

    @Test
    public void testListAdminByParamAndPage() {
        Admin admin = new Admin();
        admin.setAdInfo("1");
        PageInfoUtil<Admin> adminList = adminService.listAdminByParamAndPage(admin, 1, 2);
        System.out.println("-->"+JSON.toJSONString(adminList));
    }

    @Test
    public void testDeleteAdminByParam() {
        Admin admin = new Admin();
        admin.setAdInfo("1");
        System.out.println("-->"+adminService.deleteAdminByParam(admin));
    }

    @Test
    public void testUpdateAdminByKey() {
        Admin admin = new Admin();
        admin.setAdId(1);
        admin.setAdInfo("1");
        admin.setAdSex("1");
        admin.setAdAge("1");
        admin.setAdName("1");
        System.out.println("-->"+adminService.updateAdminByKey(admin));
    }

    @Test
    public void testUpdateBatchAdminByKey() {
        List<Admin> adminList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Admin admin = new Admin();
            admin.setAdId(i-5);
            admin.setAdInfo(""+i);
            admin.setAdSex(""+i);
            admin.setAdAge(""+i);
            admin.setAdName(""+i);
            adminList.add(admin);
        }
        System.out.println("-->"+adminService.updateAdminByKey(adminList));
    }


    @Test
    public void testGetAdminByKey() {
        int adminPK = 1;
        System.out.println("-->"+adminService.getAdminByKey(adminPK));
    }

    @Test
    public void testListAdminByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+adminService.listAdminByKey(keyList));
    }

    @Test
    public void testDeleteAdminByKey() {
        int adminPK = 1;
        System.out.println("-->"+adminService.deleteAdminByKey(adminPK));
    }

    @Test
    public void testDeleteBatchAdminByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+adminService.deleteAdminByKey(keyList));
    }

}
