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

import com.jingye.entity.RoomType;
import com.jingye.service.RoomTypeService;

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
public class RoomTypeTest {

    @Autowired
    RoomTypeService roomTypeService;

    @Test
    public void testSaveRoomType() {
        RoomType roomType = new RoomType();
        roomType.setRtName(""+1);
        roomType.setRtNote(""+1);
        roomType.setRtId(1);
        System.out.println("-->"+roomTypeService.saveRoomType(roomType));
    }

    @Test
    public void testBatchSaveRoomType() {
        List<RoomType> roomTypeList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            RoomType roomType = new RoomType();
            roomType.setRtName(""+i);
            roomType.setRtNote(""+i);
            roomType.setRtId(i);
            roomTypeList.add(roomType);
        }
        System.out.println("-->"+roomTypeService.saveRoomType(roomTypeList));
    }

    @Test
    public void testListRoomType() {
        System.out.println("-->"+roomTypeService.listRoomType());
    }

    @Test
    public void testListRoomTypeByParam() {
        RoomType roomType = new RoomType();
        roomType.setRtNote("1");
        System.out.println("-->"+roomTypeService.listRoomTypeByParam(roomType));
    }

    @Test
    public void testListRoomTypeByPage() {
        PageInfoUtil<RoomType> roomTypeList = roomTypeService.listRoomTypeByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(roomTypeList));
    }

    @Test
    public void testListRoomTypeByParamAndPage() {
        RoomType roomType = new RoomType();
        roomType.setRtNote("1");
        PageInfoUtil<RoomType> roomTypeList = roomTypeService.listRoomTypeByParamAndPage(roomType, 1, 2);
        System.out.println("-->"+JSON.toJSONString(roomTypeList));
    }

    @Test
    public void testDeleteRoomTypeByParam() {
        RoomType roomType = new RoomType();
        roomType.setRtNote("1");
        System.out.println("-->"+roomTypeService.deleteRoomTypeByParam(roomType));
    }

    @Test
    public void testUpdateRoomTypeByKey() {
        RoomType roomType = new RoomType();
        roomType.setRtId(1);
        roomType.setRtNote("1");
        roomType.setRtName("1");
        System.out.println("-->"+roomTypeService.updateRoomTypeByKey(roomType));
    }

    @Test
    public void testUpdateBatchRoomTypeByKey() {
        List<RoomType> roomTypeList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            RoomType roomType = new RoomType();
            roomType.setRtId(i-5);
            roomType.setRtNote(""+i);
            roomType.setRtName(""+i);
            roomTypeList.add(roomType);
        }
        System.out.println("-->"+roomTypeService.updateRoomTypeByKey(roomTypeList));
    }


    @Test
    public void testGetRoomTypeByKey() {
        int roomTypePK = 1;
        System.out.println("-->"+roomTypeService.getRoomTypeByKey(roomTypePK));
    }

    @Test
    public void testListRoomTypeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomTypeService.listRoomTypeByKey(keyList));
    }

    @Test
    public void testDeleteRoomTypeByKey() {
        int roomTypePK = 1;
        System.out.println("-->"+roomTypeService.deleteRoomTypeByKey(roomTypePK));
    }

    @Test
    public void testDeleteBatchRoomTypeByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomTypeService.deleteRoomTypeByKey(keyList));
    }

}
