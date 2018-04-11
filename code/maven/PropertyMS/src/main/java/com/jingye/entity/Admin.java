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
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * adName 姓名
	 */
	@JSONField(name="ad_name")
	private String adName;

    /**
	 * adSex 性别
	 */
	@JSONField(name="ad_sex")
	private String adSex;

    /**
	 * adId 管理员id
	 */
	@JSONField(name="ad_id")
	private Integer adId;

    /**
	 * adNote 备注
	 */
	@JSONField(name="ad_note")
	private String adNote;

    /**
	 * adBirthday 出生日期
	 */
    @JSONField(name="ad_birthday", format="yyyy-MM-dd HH:mm:ss")
	private Date adBirthday;

    /**
	 * adPassword 密码
	 */
	@JSONField(name="ad_password")
	private String adPassword;

    /**
	 * adLogin 登录账号
	 */
	@JSONField(name="ad_login")
	private String adLogin;

    /**
	 * adTel 联系电话
	 */
	@JSONField(name="ad_tel")
	private String adTel;

    /**
	 * adEntryTime 
	 */
    @JSONField(name="ad_entry_time", format="yyyy-MM-dd HH:mm:ss")
	private Date adEntryTime;

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

	public void setAdNote(String adNote) {
		this.adNote = adNote;
	}

	public String getAdNote() {
	    return adNote;
	}

	public void setAdBirthday(Date adBirthday) {
		this.adBirthday = adBirthday;
	}

	public Date getAdBirthday() {
	    return adBirthday;
	}

	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}

	public String getAdPassword() {
	    return adPassword;
	}

	public void setAdLogin(String adLogin) {
		this.adLogin = adLogin;
	}

	public String getAdLogin() {
	    return adLogin;
	}

	public void setAdTel(String adTel) {
		this.adTel = adTel;
	}

	public String getAdTel() {
	    return adTel;
	}

	public void setAdEntryTime(Date adEntryTime) {
		this.adEntryTime = adEntryTime;
	}

	public Date getAdEntryTime() {
	    return adEntryTime;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
