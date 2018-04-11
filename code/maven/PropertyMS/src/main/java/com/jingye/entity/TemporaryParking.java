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
public class TemporaryParking implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * tpNote 备注
	 */
	@JSONField(name="tp_note")
	private String tpNote;

    /**
	 * tpTime 停放时间
	 */
	@JSONField(name="tp_time")
	private String tpTime;

    /**
	 * tpCharge 收费标准
	 */
	@JSONField(name="tp_charge")
	private String tpCharge;

    /**
	 * id Id
	 */
	@JSONField(name="id")
	private Integer id;

	public void setTpNote(String tpNote) {
		this.tpNote = tpNote;
	}

	public String getTpNote() {
	    return tpNote;
	}

	public void setTpTime(String tpTime) {
		this.tpTime = tpTime;
	}

	public String getTpTime() {
	    return tpTime;
	}

	public void setTpCharge(String tpCharge) {
		this.tpCharge = tpCharge;
	}

	public String getTpCharge() {
	    return tpCharge;
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
