package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Equipment;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class EquipmentRequest implements Serializable {

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
     * equipmentIds 主键集合
     */
    List<Integer> equipmentIdList = new ArrayList<>();

    public void setEquipmentIdList(List<Integer> equipmentIdList) {
        this.equipmentIdList = equipmentIdList;
    }

    public List<Integer> getEquipmentIdList() {
        return equipmentIdList;
    }

    /**
     * equipmentInfo 备注
     */
    @JSONField(name="equipment_info")
    private String equipmentInfo;

    /**
     * equipmentName 名称
     */
    @JSONField(name="equipment_name")
    private String equipmentName;

    /**
     * equipmentId 编号
     */
    @JSONField(name="equipment_id")
    private Integer equipmentId;

    /**
     * equipmentNumber 数量
     */
    @JSONField(name="equipment_number")
    private Integer equipmentNumber;

    /**
     * equipmentCycle 检修周期
     */
    @JSONField(name="equipment_cycle")
    private String equipmentCycle;

    /**
     * equipmentProduce 生产日期
     */
    @JSONField(name="equipment_produce")
    private String equipmentProduce;

    /**
     * equipmentVendor 生产厂商
     */
    @JSONField(name="equipment_vendor")
    private String equipmentVendor;

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

    public void setEquipmentInfo(String equipmentInfo) {
        this.equipmentInfo = equipmentInfo;
    }

    public String getEquipmentInfo() {
        return equipmentInfo;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentNumber(Integer equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Integer getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentCycle(String equipmentCycle) {
        this.equipmentCycle = equipmentCycle;
    }

    public String getEquipmentCycle() {
        return equipmentCycle;
    }

    public void setEquipmentProduce(String equipmentProduce) {
        this.equipmentProduce = equipmentProduce;
    }

    public String getEquipmentProduce() {
        return equipmentProduce;
    }

    public void setEquipmentVendor(String equipmentVendor) {
        this.equipmentVendor = equipmentVendor;
    }

    public String getEquipmentVendor() {
        return equipmentVendor;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Equipment getEquipment() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentInfo(this.getEquipmentInfo());
        equipment.setEquipmentName(this.getEquipmentName());
        equipment.setEquipmentId(this.getEquipmentId());
        equipment.setEquipmentNumber(this.getEquipmentNumber());
        equipment.setEquipmentCycle(this.getEquipmentCycle());
        equipment.setEquipmentProduce(this.getEquipmentProduce());
        equipment.setEquipmentVendor(this.getEquipmentVendor());
        return equipment;
    }
}
