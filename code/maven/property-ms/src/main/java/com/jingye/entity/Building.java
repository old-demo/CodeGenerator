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
 * @date   2018-03-22 11:51:09
 */
public class Building implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * buildingId 大楼编号
	 */
	@JSONField(name="building_id")
	private Integer buildingId;

    /**
	 * buildingKind 类型
	 */
	@JSONField(name="building_kind")
	private String buildingKind;

    /**
	 * bulidingLevel 层数
	 */
	@JSONField(name="buliding_level")
	private String bulidingLevel;

    /**
	 * buildingHead 朝向
	 */
	@JSONField(name="building_head")
	private String buildingHead;

    /**
	 * bulidingArea 面积
	 */
	@JSONField(name="buliding_area")
	private String bulidingArea;

    /**
	 * buildingInfo 备注
	 */
	@JSONField(name="building_info")
	private String buildingInfo;

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Integer getBuildingId() {
	    return buildingId;
	}

	public void setBuildingKind(String buildingKind) {
		this.buildingKind = buildingKind;
	}

	public String getBuildingKind() {
	    return buildingKind;
	}

	public void setBulidingLevel(String bulidingLevel) {
		this.bulidingLevel = bulidingLevel;
	}

	public String getBulidingLevel() {
	    return bulidingLevel;
	}

	public void setBuildingHead(String buildingHead) {
		this.buildingHead = buildingHead;
	}

	public String getBuildingHead() {
	    return buildingHead;
	}

	public void setBulidingArea(String bulidingArea) {
		this.bulidingArea = bulidingArea;
	}

	public String getBulidingArea() {
	    return bulidingArea;
	}

	public void setBuildingInfo(String buildingInfo) {
		this.buildingInfo = buildingInfo;
	}

	public String getBuildingInfo() {
	    return buildingInfo;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
