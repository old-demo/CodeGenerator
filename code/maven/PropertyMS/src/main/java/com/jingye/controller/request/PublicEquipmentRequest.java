package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.PublicEquipment;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class PublicEquipmentRequest implements Serializable {

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
     * eqpName 设备名称
     */
    @JSONField(name="eqp_name")
    private String eqpName;

    /**
     * eqpOpenDate 启用日期
     */
    @JSONField(name="eqp_open_date")
    private Date eqpOpenDate;

    /**
     * eqpStatus 当前状态
     */
    @JSONField(name="eqp_status")
    private String eqpStatus;

    /**
     * id Id
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * eqpBdId 所属大楼
     */
    @JSONField(name="eqp_bd_id")
    private String eqpBdId;

    /**
     * eqpId 设备编号
     */
    @JSONField(name="eqp_id")
    private String eqpId;

    /**
     * eqpSpecification 规格型号
     */
    @JSONField(name="eqp_specification")
    private String eqpSpecification;

    /**
     * eqpNote 备注
     */
    @JSONField(name="eqp_note")
    private String eqpNote;

    /**
     * eqpFloor 所在楼层
     */
    @JSONField(name="eqp_floor")
    private String eqpFloor;

    /**
     * eqpValue 设备原值
     */
    @JSONField(name="eqp_value")
    private String eqpValue;

    /**
     * eqpAdminId 负责人员
     */
    @JSONField(name="eqp_admin_id")
    private Integer eqpAdminId;

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

    public void setEqpName(String eqpName) {
        this.eqpName = eqpName;
    }

    public String getEqpName() {
        return eqpName;
    }

    public void setEqpOpenDate(Date eqpOpenDate) {
        this.eqpOpenDate = eqpOpenDate;
    }

    public Date getEqpOpenDate() {
        return eqpOpenDate;
    }

    public void setEqpStatus(String eqpStatus) {
        this.eqpStatus = eqpStatus;
    }

    public String getEqpStatus() {
        return eqpStatus;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setEqpBdId(String eqpBdId) {
        this.eqpBdId = eqpBdId;
    }

    public String getEqpBdId() {
        return eqpBdId;
    }

    public void setEqpId(String eqpId) {
        this.eqpId = eqpId;
    }

    public String getEqpId() {
        return eqpId;
    }

    public void setEqpSpecification(String eqpSpecification) {
        this.eqpSpecification = eqpSpecification;
    }

    public String getEqpSpecification() {
        return eqpSpecification;
    }

    public void setEqpNote(String eqpNote) {
        this.eqpNote = eqpNote;
    }

    public String getEqpNote() {
        return eqpNote;
    }

    public void setEqpFloor(String eqpFloor) {
        this.eqpFloor = eqpFloor;
    }

    public String getEqpFloor() {
        return eqpFloor;
    }

    public void setEqpValue(String eqpValue) {
        this.eqpValue = eqpValue;
    }

    public String getEqpValue() {
        return eqpValue;
    }

    public void setEqpAdminId(Integer eqpAdminId) {
        this.eqpAdminId = eqpAdminId;
    }

    public Integer getEqpAdminId() {
        return eqpAdminId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public PublicEquipment getPublicEquipment() {
        PublicEquipment publicEquipment = new PublicEquipment();
        publicEquipment.setEqpName(this.getEqpName());
        publicEquipment.setEqpOpenDate(this.getEqpOpenDate());
        publicEquipment.setEqpStatus(this.getEqpStatus());
        publicEquipment.setId(this.getId());
        publicEquipment.setEqpBdId(this.getEqpBdId());
        publicEquipment.setEqpId(this.getEqpId());
        publicEquipment.setEqpSpecification(this.getEqpSpecification());
        publicEquipment.setEqpNote(this.getEqpNote());
        publicEquipment.setEqpFloor(this.getEqpFloor());
        publicEquipment.setEqpValue(this.getEqpValue());
        publicEquipment.setEqpAdminId(this.getEqpAdminId());
        return publicEquipment;
    }
}
