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

import com.jingye.entity.RoomInfo;
import com.jingye.service.RoomInfoService;

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
public class RoomInfoTest {

    @Autowired
    RoomInfoService roomInfoService;

    @Test
    public void testSaveRoomInfo() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setId(1);
        roomInfo.setRmTypeId(1);
        roomInfo.setRmRent(""+1);
        roomInfo.setRmYzId(1);
        roomInfo.setRmNote(""+1);
        roomInfo.setRmArea(""+1);
        roomInfo.setRmId(""+1);
        roomInfo.setRmBuildingId(""+1);
        System.out.println("-->"+roomInfoService.saveRoomInfo(roomInfo));
    }

    @Test
    public void testBatchSaveRoomInfo() {
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setId(i);
            roomInfo.setRmTypeId(i);
            roomInfo.setRmRent(""+i);
            roomInfo.setRmYzId(i);
            roomInfo.setRmNote(""+i);
            roomInfo.setRmArea(""+i);
            roomInfo.setRmId(""+i);
            roomInfo.setRmBuildingId(""+i);
            roomInfoList.add(roomInfo);
        }
        System.out.println("-->"+roomInfoService.saveRoomInfo(roomInfoList));
    }

    @Test
    public void testListRoomInfo() {
        System.out.println("-->"+roomInfoService.listRoomInfo());
    }

    @Test
    public void testListRoomInfoByParam() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRmArea("1");
        System.out.println("-->"+roomInfoService.listRoomInfoByParam(roomInfo));
    }

    @Test
    public void testListRoomInfoByPage() {
        PageInfoUtil<RoomInfo> roomInfoList = roomInfoService.listRoomInfoByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(roomInfoList));
    }

    @Test
    public void testListRoomInfoByParamAndPage() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRmArea("1");
        PageInfoUtil<RoomInfo> roomInfoList = roomInfoService.listRoomInfoByParamAndPage(roomInfo, 1, 2);
        System.out.println("-->"+JSON.toJSONString(roomInfoList));
    }

    @Test
    public void testDeleteRoomInfoByParam() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setRmArea("1");
        System.out.println("-->"+roomInfoService.deleteRoomInfoByParam(roomInfo));
    }

    @Test
    public void testUpdateRoomInfoByKey() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setId(1);
        roomInfo.setRmArea("1");
        roomInfo.setRmYzId(1);
        roomInfo.setRmId("1");
        roomInfo.setRmBuildingId("1");
        roomInfo.setRmTypeId(1);
        roomInfo.setRmRent("1");
        roomInfo.setRmNote("1");
        System.out.println("-->"+roomInfoService.updateRoomInfoByKey(roomInfo));
    }

    @Test
    public void testUpdateBatchRoomInfoByKey() {
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            RoomInfo roomInfo = new RoomInfo();
            roomInfo.setId(i-5);
            roomInfo.setRmArea(""+i);
            roomInfo.setRmYzId(i);
            roomInfo.setRmId(""+i);
            roomInfo.setRmBuildingId(""+i);
            roomInfo.setRmTypeId(i);
            roomInfo.setRmRent(""+i);
            roomInfo.setRmNote(""+i);
            roomInfoList.add(roomInfo);
        }
        System.out.println("-->"+roomInfoService.updateRoomInfoByKey(roomInfoList));
    }


    @Test
    public void testGetRoomInfoByKey() {
        int roomInfoPK = 1;
        System.out.println("-->"+roomInfoService.getRoomInfoByKey(roomInfoPK));
    }

    @Test
    public void testListRoomInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomInfoService.listRoomInfoByKey(keyList));
    }

    @Test
    public void testDeleteRoomInfoByKey() {
        int roomInfoPK = 1;
        System.out.println("-->"+roomInfoService.deleteRoomInfoByKey(roomInfoPK));
    }

    @Test
    public void testDeleteBatchRoomInfoByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomInfoService.deleteRoomInfoByKey(keyList));
    }

}
