package com.jingye.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 实体类
 * 
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class ParkingSpaces implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * cwOpen 启用日期
	 */
    @JSONField(name="cw_open", format="yyyy-MM-dd HH:mm:ss")
	private Date cwOpen;

    /**
	 * cwClose 停用日期
	 */
    @JSONField(name="cw_close", format="yyyy-MM-dd HH:mm:ss")
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
}
