package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.RoomInfo;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class RoomInfoRequest implements Serializable {

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
     * ids 主键集合
     */
    List<Integer> idList = new ArrayList<>();

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    /**
     * id 
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * rmTypeId 房型id
     */
    @JSONField(name="rm_type_id")
    private Integer rmTypeId;

    /**
     * rmRent 出租否
     */
    @JSONField(name="rm_rent")
    private String rmRent;

    /**
     * rmYzId 业主id
     */
    @JSONField(name="rm_yz_id")
    private Integer rmYzId;

    /**
     * rmNote 备注
     */
    @JSONField(name="rm_note")
    private String rmNote;

    /**
     * rmArea 房间面积
     */
    @JSONField(name="rm_area")
    private String rmArea;

    /**
     * rmId 房间编号
     */
    @JSONField(name="rm_id")
    private String rmId;

    /**
     * rmBuildingId 所属楼栋
     */
    @JSONField(name="rm_building_id")
    private String rmBuildingId;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRmTypeId(Integer rmTypeId) {
        this.rmTypeId = rmTypeId;
    }

    public Integer getRmTypeId() {
        return rmTypeId;
    }

    public void setRmRent(String rmRent) {
        this.rmRent = rmRent;
    }

    public String getRmRent() {
        return rmRent;
    }

    public void setRmYzId(Integer rmYzId) {
        this.rmYzId = rmYzId;
    }

    public Integer getRmYzId() {
        return rmYzId;
    }

    public void setRmNote(String rmNote) {
        this.rmNote = rmNote;
    }

    public String getRmNote() {
        return rmNote;
    }

    public void setRmArea(String rmArea) {
        this.rmArea = rmArea;
    }

    public String getRmArea() {
        return rmArea;
    }

    public void setRmId(String rmId) {
        this.rmId = rmId;
    }

    public String getRmId() {
        return rmId;
    }

    public void setRmBuildingId(String rmBuildingId) {
        this.rmBuildingId = rmBuildingId;
    }

    public String getRmBuildingId() {
        return rmBuildingId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public RoomInfo getRoomInfo() {
        RoomInfo roomInfo = new RoomInfo();
        roomInfo.setId(this.getId());
        roomInfo.setRmTypeId(this.getRmTypeId());
        roomInfo.setRmRent(this.getRmRent());
        roomInfo.setRmYzId(this.getRmYzId());
        roomInfo.setRmNote(this.getRmNote());
        roomInfo.setRmArea(this.getRmArea());
        roomInfo.setRmId(this.getRmId());
        roomInfo.setRmBuildingId(this.getRmBuildingId());
        return roomInfo;
    }
}
