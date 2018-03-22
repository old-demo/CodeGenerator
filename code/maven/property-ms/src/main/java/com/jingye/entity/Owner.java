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
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * yzInfo 备注
	 */
	@JSONField(name="yz_info")
	private String yzInfo;

    /**
	 * yzPhone 联系方式
	 */
	@JSONField(name="yz_phone")
	private String yzPhone;

    /**
	 * yzName 业主姓名
	 */
	@JSONField(name="yz_name")
	private String yzName;

    /**
	 * yzSex 业主性别
	 */
	@JSONField(name="yz_sex")
	private String yzSex;

    /**
	 * yzId 业主id
	 */
	@JSONField(name="yz_id")
	private Integer yzId;

	public void setYzInfo(String yzInfo) {
		this.yzInfo = yzInfo;
	}

	public String getYzInfo() {
	    return yzInfo;
	}

	public void setYzPhone(String yzPhone) {
		this.yzPhone = yzPhone;
	}

	public String getYzPhone() {
	    return yzPhone;
	}

	public void setYzName(String yzName) {
		this.yzName = yzName;
	}

	public String getYzName() {
	    return yzName;
	}

	public void setYzSex(String yzSex) {
		this.yzSex = yzSex;
	}

	public String getYzSex() {
	    return yzSex;
	}

	public void setYzId(Integer yzId) {
		this.yzId = yzId;
	}

	public Integer getYzId() {
	    return yzId;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
