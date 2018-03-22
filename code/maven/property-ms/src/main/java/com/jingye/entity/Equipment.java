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
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
