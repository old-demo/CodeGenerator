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
public class Charge implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * chargeId 收费标准id
	 */
	@JSONField(name="charge_id")
	private Integer chargeId;

    /**
	 * chargeName 收费标准名
	 */
	@JSONField(name="charge_name")
	private String chargeName;

    /**
	 * chargeInfo 备注
	 */
	@JSONField(name="charge_info")
	private String chargeInfo;

    /**
	 * chargeMoney 收费金额
	 */
	@JSONField(name="charge_money")
	private String chargeMoney;

    /**
	 * chargeKind 收费标准类别
	 */
	@JSONField(name="charge_kind")
	private String chargeKind;

	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getChargeId() {
	    return chargeId;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChargeName() {
	    return chargeName;
	}

	public void setChargeInfo(String chargeInfo) {
		this.chargeInfo = chargeInfo;
	}

	public String getChargeInfo() {
	    return chargeInfo;
	}

	public void setChargeMoney(String chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public String getChargeMoney() {
	    return chargeMoney;
	}

	public void setChargeKind(String chargeKind) {
		this.chargeKind = chargeKind;
	}

	public String getChargeKind() {
	    return chargeKind;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
