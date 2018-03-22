package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Parking;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class ParkingRequest implements Serializable {

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
     * parkingIds 主键集合
     */
    List<Integer> parkingIdList = new ArrayList<>();

    public void setParkingIdList(List<Integer> parkingIdList) {
        this.parkingIdList = parkingIdList;
    }

    public List<Integer> getParkingIdList() {
        return parkingIdList;
    }

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

    public Parking getParking() {
        Parking parking = new Parking();
        parking.setParkingId(this.getParkingId());
        parking.setParkingArea(this.getParkingArea());
        parking.setParkingOwnerId(this.getParkingOwnerId());
        parking.setParkingCarNumber(this.getParkingCarNumber());
        parking.setParkingInfo(this.getParkingInfo());
        parking.setParkingCarKind(this.getParkingCarKind());
        return parking;
    }
}
