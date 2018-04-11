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
public class PropertyCosts implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * pcBtId 大楼类型id
	 */
	@JSONField(name="pc_bt_id")
	private Integer pcBtId;

    /**
	 * pcCharge 收费标准
	 */
	@JSONField(name="pc_charge")
	private String pcCharge;

    /**
	 * pcNote 备注
	 */
	@JSONField(name="pc_note")
	private String pcNote;

    /**
	 * id id
	 */
	@JSONField(name="id")
	private Integer id;

	public void setPcBtId(Integer pcBtId) {
		this.pcBtId = pcBtId;
	}

	public Integer getPcBtId() {
	    return pcBtId;
	}

	public void setPcCharge(String pcCharge) {
		this.pcCharge = pcCharge;
	}

	public String getPcCharge() {
	    return pcCharge;
	}

	public void setPcNote(String pcNote) {
		this.pcNote = pcNote;
	}

	public String getPcNote() {
	    return pcNote;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	    return id;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
