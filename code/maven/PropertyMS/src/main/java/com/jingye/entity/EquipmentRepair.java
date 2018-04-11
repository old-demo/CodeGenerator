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
public class EquipmentRepair implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * warContent 报修内容
	 */
	@JSONField(name="war_content")
	private String warContent;

    /**
	 * warYzId 报修业主id
	 */
	@JSONField(name="war_yz_id")
	private Integer warYzId;

    /**
	 * warTime 报修时间
	 */
    @JSONField(name="war_time", format="yyyy-MM-dd HH:mm:ss")
	private Date warTime;

    /**
	 * warStatus 处理状态
	 */
	@JSONField(name="war_status")
	private String warStatus;

    /**
	 * id 
	 */
	@JSONField(name="id")
	private Integer id;

    /**
	 * warNote 备注
	 */
	@JSONField(name="war_note")
	private String warNote;

	public void setWarContent(String warContent) {
		this.warContent = warContent;
	}

	public String getWarContent() {
	    return warContent;
	}

	public void setWarYzId(Integer warYzId) {
		this.warYzId = warYzId;
	}

	public Integer getWarYzId() {
	    return warYzId;
	}

	public void setWarTime(Date warTime) {
		this.warTime = warTime;
	}

	public Date getWarTime() {
	    return warTime;
	}

	public void setWarStatus(String warStatus) {
		this.warStatus = warStatus;
	}

	public String getWarStatus() {
	    return warStatus;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	    return id;
	}

	public void setWarNote(String warNote) {
		this.warNote = warNote;
	}

	public String getWarNote() {
	    return warNote;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
