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
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * feedbackTime 反馈时间
	 */
    @JSONField(name="feedback_time", format="yyyy-MM-dd HH:mm:ss")
	private Date feedbackTime;

    /**
	 * feedbackId 问题反馈id
	 */
	@JSONField(name="feedback_id")
	private Integer feedbackId;

    /**
	 * feedbackOwnerId 业主id
	 */
	@JSONField(name="feedback_owner_id")
	private Integer feedbackOwnerId;

    /**
	 * feedbackInfo 反馈信息
	 */
	@JSONField(name="feedback_info")
	private String feedbackInfo;

    /**
	 * feedbackNote 备注
	 */
	@JSONField(name="feedback_note")
	private String feedbackNote;

	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

	public Date getFeedbackTime() {
	    return feedbackTime;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getFeedbackId() {
	    return feedbackId;
	}

	public void setFeedbackOwnerId(Integer feedbackOwnerId) {
		this.feedbackOwnerId = feedbackOwnerId;
	}

	public Integer getFeedbackOwnerId() {
	    return feedbackOwnerId;
	}

	public void setFeedbackInfo(String feedbackInfo) {
		this.feedbackInfo = feedbackInfo;
	}

	public String getFeedbackInfo() {
	    return feedbackInfo;
	}

	public void setFeedbackNote(String feedbackNote) {
		this.feedbackNote = feedbackNote;
	}

	public String getFeedbackNote() {
	    return feedbackNote;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
