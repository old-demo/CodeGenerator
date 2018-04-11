package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.ParkingSpaces;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class ParkingSpacesRequest implements Serializable {

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
     * cwOpen 启用日期
     */
    @JSONField(name="cw_open")
    private Date cwOpen;

    /**
     * cwClose 停用日期
     */
    @JSONField(name="cw_close")
    private Date cwClose;

    /**
     * cwCost 费用金额
     */
    @JSONField(name="cw_cost")
    private String cwCost;

    /**
     * cwYzId 业主id
     */
    @JSONField(name="cw_yz_id")
    private Integer cwYzId;

    /**
     * cwNote 备注
     */
    @JSONField(name="cw_note")
    private String cwNote;

    /**
     * id id
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * cwId 车位编号
     */
    @JSONField(name="cw_id")
    private String cwId;

    /**
     * cwBuildingId 楼栋id
     */
    @JSONField(name="cw_building_id")
    private String cwBuildingId;

    /**
     * cwArea 车位面积
     */
    @JSONField(name="cw_area")
    private String cwArea;

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

    public void setCwOpen(Date cwOpen) {
        this.cwOpen = cwOpen;
    }

    public Date getCwOpen() {
        return cwOpen;
    }

    public void setCwClose(Date cwClose) {
        this.cwClose = cwClose;
    }

    public Date getCwClose() {
        return cwClose;
    }

    public void setCwCost(String cwCost) {
        this.cwCost = cwCost;
    }

    public String getCwCost() {
        return cwCost;
    }

    public void setCwYzId(Integer cwYzId) {
        this.cwYzId = cwYzId;
    }

    public Integer getCwYzId() {
        return cwYzId;
    }

    public void setCwNote(String cwNote) {
        this.cwNote = cwNote;
    }

    public String getCwNote() {
        return cwNote;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setCwId(String cwId) {
        this.cwId = cwId;
    }

    public String getCwId() {
        return cwId;
    }

    public void setCwBuildingId(String cwBuildingId) {
        this.cwBuildingId = cwBuildingId;
    }

    public String getCwBuildingId() {
        return cwBuildingId;
    }

    public void setCwArea(String cwArea) {
        this.cwArea = cwArea;
    }

    public String getCwArea() {
        return cwArea;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public ParkingSpaces getParkingSpaces() {
        ParkingSpaces parkingSpaces = new ParkingSpaces();
        parkingSpaces.setCwOpen(this.getCwOpen());
        parkingSpaces.setCwClose(this.getCwClose());
        parkingSpaces.setCwCost(this.getCwCost());
        parkingSpaces.setCwYzId(this.getCwYzId());
        parkingSpaces.setCwNote(this.getCwNote());
        parkingSpaces.setId(this.getId());
        parkingSpaces.setCwId(this.getCwId());
        parkingSpaces.setCwBuildingId(this.getCwBuildingId());
        parkingSpaces.setCwArea(this.getCwArea());
        return parkingSpaces;
    }
}
