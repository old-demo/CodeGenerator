package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.EquipmentRepair;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class EquipmentRepairRequest implements Serializable {

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
     * warContent 报修内容
     */
    @JSONField(name="war_content")
    private String warContent;

    /**
     * warYzId 报修业主id
     */
    @JSONField(name="war_yz_id")
    private Integer warYzId;

    /**
     * warTime 报修时间
     */
    @JSONField(name="war_time")
    private Date warTime;

    /**
     * warStatus 处理状态
     */
    @JSONField(name="war_status")
    private String warStatus;

    /**
     * id 
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * warNote 备注
     */
    @JSONField(name="war_note")
    private String warNote;

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

    public void setWarContent(String warContent) {
        this.warContent = warContent;
    }

    public String getWarContent() {
        return warContent;
    }

    public void setWarYzId(Integer warYzId) {
        this.warYzId = warYzId;
    }

    public Integer getWarYzId() {
        return warYzId;
    }

    public void setWarTime(Date warTime) {
        this.warTime = warTime;
    }

    public Date getWarTime() {
        return warTime;
    }

    public void setWarStatus(String warStatus) {
        this.warStatus = warStatus;
    }

    public String getWarStatus() {
        return warStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setWarNote(String warNote) {
        this.warNote = warNote;
    }

    public String getWarNote() {
        return warNote;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public EquipmentRepair getEquipmentRepair() {
        EquipmentRepair equipmentRepair = new EquipmentRepair();
        equipmentRepair.setWarContent(this.getWarContent());
        equipmentRepair.setWarYzId(this.getWarYzId());
        equipmentRepair.setWarTime(this.getWarTime());
        equipmentRepair.setWarStatus(this.getWarStatus());
        equipmentRepair.setId(this.getId());
        equipmentRepair.setWarNote(this.getWarNote());
        return equipmentRepair;
    }
}
