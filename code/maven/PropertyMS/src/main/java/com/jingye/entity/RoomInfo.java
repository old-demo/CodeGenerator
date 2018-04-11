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
 * @date   2018-04-11 12:14:50
 */
public class RoomInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
