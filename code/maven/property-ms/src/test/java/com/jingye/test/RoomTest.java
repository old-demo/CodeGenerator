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

import com.jingye.entity.Room;
import com.jingye.service.RoomService;

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
public class RoomTest {

    @Autowired
    RoomService roomService;

    @Test
    public void testSaveRoom() {
        Room room = new Room();
        room.setRoomUnitId(1);
        room.setRoomOwnerId(1);
        room.setRoomInfo(""+1);
        room.setRoomId(1);
        room.setRoomShape(""+1);
        room.setRoomArea(""+1);
        System.out.println("-->"+roomService.saveRoom(room));
    }

    @Test
    public void testBatchSaveRoom() {
        List<Room> roomList = new ArrayList<>();
        for(int i=2;i<5;i++) {
            Room room = new Room();
            room.setRoomUnitId(i);
            room.setRoomOwnerId(i);
            room.setRoomInfo(""+i);
            room.setRoomId(i);
            room.setRoomShape(""+i);
            room.setRoomArea(""+i);
            roomList.add(room);
        }
        System.out.println("-->"+roomService.saveRoom(roomList));
    }

    @Test
    public void testListRoom() {
        System.out.println("-->"+roomService.listRoom());
    }

    @Test
    public void testListRoomByParam() {
        Room room = new Room();
        room.setRoomOwnerId(1);
        System.out.println("-->"+roomService.listRoomByParam(room));
    }

    @Test
    public void testListRoomByPage() {
        PageInfoUtil<Room> roomList = roomService.listRoomByPage(1, 2);
        System.out.println("-->"+JSON.toJSONString(roomList));
    }

    @Test
    public void testListRoomByParamAndPage() {
        Room room = new Room();
        room.setRoomOwnerId(1);
        PageInfoUtil<Room> roomList = roomService.listRoomByParamAndPage(room, 1, 2);
        System.out.println("-->"+JSON.toJSONString(roomList));
    }

    @Test
    public void testDeleteRoomByParam() {
        Room room = new Room();
        room.setRoomOwnerId(1);
        System.out.println("-->"+roomService.deleteRoomByParam(room));
    }

    @Test
    public void testUpdateRoomByKey() {
        Room room = new Room();
        room.setRoomId(1);
        room.setRoomOwnerId(1);
        room.setRoomUnitId(1);
        room.setRoomShape("1");
        room.setRoomInfo("1");
        room.setRoomArea("1");
        System.out.println("-->"+roomService.updateRoomByKey(room));
    }

    @Test
    public void testUpdateBatchRoomByKey() {
        List<Room> roomList = new ArrayList<>();
        for(int i=6;i<10;i++) {
            Room room = new Room();
            room.setRoomId(i-5);
            room.setRoomOwnerId(i);
            room.setRoomUnitId(i);
            room.setRoomShape(""+i);
            room.setRoomInfo(""+i);
            room.setRoomArea(""+i);
            roomList.add(room);
        }
        System.out.println("-->"+roomService.updateRoomByKey(roomList));
    }


    @Test
    public void testGetRoomByKey() {
        int roomPK = 1;
        System.out.println("-->"+roomService.getRoomByKey(roomPK));
    }

    @Test
    public void testListRoomByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomService.listRoomByKey(keyList));
    }

    @Test
    public void testDeleteRoomByKey() {
        int roomPK = 1;
        System.out.println("-->"+roomService.deleteRoomByKey(roomPK));
    }

    @Test
    public void testDeleteBatchRoomByKey() {
        List<Integer> keyList = new ArrayList<>();
        keyList.add(1);
        keyList.add(2);
        System.out.println("-->"+roomService.deleteRoomByKey(keyList));
    }

}
