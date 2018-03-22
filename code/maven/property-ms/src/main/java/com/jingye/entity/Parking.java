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
public class Parking implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * parkingId 车位id
	 */
	@JSONField(name="parking_id")
	private Integer parkingId;

    /**
	 * parkingArea 车位面积
	 */
	@JSONField(name="parking_area")
	private String parkingArea;

    /**
	 * parkingOwnerId 业主id
	 */
	@JSONField(name="parking_owner_id")
	private Integer parkingOwnerId;

    /**
	 * parkingCarNumber 车牌号
	 */
	@JSONField(name="parking_car_number")
	private String parkingCarNumber;

    /**
	 * parkingInfo 备注
	 */
	@JSONField(name="parking_info")
	private String parkingInfo;

    /**
	 * parkingCarKind 联系电话
	 */
	@JSONField(name="parking_car_kind")
	private String parkingCarKind;

	public void setParkingId(Integer parkingId) {
		this.parkingId = parkingId;
	}

	public Integer getParkingId() {
	    return parkingId;
	}

	public void setParkingArea(String parkingArea) {
		this.parkingArea = parkingArea;
	}

	public String getParkingArea() {
	    return parkingArea;
	}

	public void setParkingOwnerId(Integer parkingOwnerId) {
		this.parkingOwnerId = parkingOwnerId;
	}

	public Integer getParkingOwnerId() {
	    return parkingOwnerId;
	}

	public void setParkingCarNumber(String parkingCarNumber) {
		this.parkingCarNumber = parkingCarNumber;
	}

	public String getParkingCarNumber() {
	    return parkingCarNumber;
	}

	public void setParkingInfo(String parkingInfo) {
		this.parkingInfo = parkingInfo;
	}

	public String getParkingInfo() {
	    return parkingInfo;
	}

	public void setParkingCarKind(String parkingCarKind) {
		this.parkingCarKind = parkingCarKind;
	}

	public String getParkingCarKind() {
	    return parkingCarKind;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
