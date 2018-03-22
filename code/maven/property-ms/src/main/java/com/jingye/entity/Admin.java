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
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * adInfo 备注
	 */
	@JSONField(name="ad_info")
	private String adInfo;

    /**
	 * adAge 年龄
	 */
	@JSONField(name="ad_age")
	private String adAge;

    /**
	 * adName 管理员姓名
	 */
	@JSONField(name="ad_name")
	private String adName;

    /**
	 * adSex 管理员性别
	 */
	@JSONField(name="ad_sex")
	private String adSex;

    /**
	 * adId 管理员编号
	 */
	@JSONField(name="ad_id")
	private Integer adId;

	public void setAdInfo(String adInfo) {
		this.adInfo = adInfo;
	}

	public String getAdInfo() {
	    return adInfo;
	}

	public void setAdAge(String adAge) {
		this.adAge = adAge;
	}

	public String getAdAge() {
	    return adAge;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdName() {
	    return adName;
	}

	public void setAdSex(String adSex) {
		this.adSex = adSex;
	}

	public String getAdSex() {
	    return adSex;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public Integer getAdId() {
	    return adId;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
