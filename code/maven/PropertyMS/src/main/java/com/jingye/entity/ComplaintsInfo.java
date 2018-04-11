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
public class ComplaintsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * cpTime 投诉时间
	 */
    @JSONField(name="cp_time", format="yyyy-MM-dd HH:mm:ss")
	private Date cpTime;

    /**
	 * cpNote 备注
	 */
	@JSONField(name="cp_note")
	private String cpNote;

    /**
	 * cpYzId 业主id
	 */
	@JSONField(name="cp_yz_id")
	private Integer cpYzId;

    /**
	 * cpResult 处理结果
	 */
	@JSONField(name="cp_result")
	private String cpResult;

    /**
	 * id id
	 */
	@JSONField(name="id")
	private Integer id;

    /**
	 * cpContent 投诉内容
	 */
	@JSONField(name="cp_content")
	private String cpContent;

	public void setCpTime(Date cpTime) {
		this.cpTime = cpTime;
	}

	public Date getCpTime() {
	    return cpTime;
	}

	public void setCpNote(String cpNote) {
		this.cpNote = cpNote;
	}

	public String getCpNote() {
	    return cpNote;
	}

	public void setCpYzId(Integer cpYzId) {
		this.cpYzId = cpYzId;
	}

	public Integer getCpYzId() {
	    return cpYzId;
	}

	public void setCpResult(String cpResult) {
		this.cpResult = cpResult;
	}

	public String getCpResult() {
	    return cpResult;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	    return id;
	}

	public void setCpContent(String cpContent) {
		this.cpContent = cpContent;
	}

	public String getCpContent() {
	    return cpContent;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
