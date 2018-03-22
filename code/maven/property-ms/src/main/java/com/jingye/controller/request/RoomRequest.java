package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Room;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class RoomRequest implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * pageNum 当前页
     */
    @JSONField(name="page_num")
    private int pageNum;

    /**
     * pageSize 每页的数量
     */
    @JSONField(name="page_size")
    private int pageSize;

    /**
     * roomIds 主键集合
     */
    List<Integer> roomIdList = new ArrayList<>();

    public void setRoomIdList(List<Integer> roomIdList) {
        this.roomIdList = roomIdList;
    }

    public List<Integer> getRoomIdList() {
        return roomIdList;
    }

    /**
     * roomUnitId 单元号
     */
    @JSONField(name="room_unit_id")
    private Integer roomUnitId;

    /**
     * roomOwnerId 业主id
     */
    @JSONField(name="room_owner_id")
    private Integer roomOwnerId;

    /**
     * roomInfo 备注
     */
    @JSONField(name="room_info")
    private String roomInfo;

    /**
     * roomId 房间号
     */
    @JSONField(name="room_id")
    private Integer roomId;

    /**
     * roomShape 房型
     */
    @JSONField(name="room_shape")
    private String roomShape;

    /**
     * roomArea 房间面积
     */
    @JSONField(name="room_area")
    private String roomArea;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRoomUnitId(Integer roomUnitId) {
        this.roomUnitId = roomUnitId;
    }

    public Integer getRoomUnitId() {
        return roomUnitId;
    }

    public void setRoomOwnerId(Integer roomOwnerId) {
        this.roomOwnerId = roomOwnerId;
    }

    public Integer getRoomOwnerId() {
        return roomOwnerId;
    }

    public void setRoomInfo(String roomInfo) {
        this.roomInfo = roomInfo;
    }

    public String getRoomInfo() {
        return roomInfo;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomShape(String roomShape) {
        this.roomShape = roomShape;
    }

    public String getRoomShape() {
        return roomShape;
    }

    public void setRoomArea(String roomArea) {
        this.roomArea = roomArea;
    }

    public String getRoomArea() {
        return roomArea;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Room getRoom() {
        Room room = new Room();
        room.setRoomUnitId(this.getRoomUnitId());
        room.setRoomOwnerId(this.getRoomOwnerId());
        room.setRoomInfo(this.getRoomInfo());
        room.setRoomId(this.getRoomId());
        room.setRoomShape(this.getRoomShape());
        room.setRoomArea(this.getRoomArea());
        return room;
    }
}
