package com.jingye.entity;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 实体类
 * 
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
