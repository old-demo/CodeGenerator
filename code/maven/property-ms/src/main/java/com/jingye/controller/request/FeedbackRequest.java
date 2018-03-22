package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Feedback;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class FeedbackRequest implements Serializable {

private static final long serialVersionUID = 1L;

    /**
     * pageNum 当前页
     */
    @JSONField(name="page_num")
    private int pageNum;

    /**
     * pageSize 每页的数量
     */
    @JSONField(name="page_size")
    private int pageSize;

    /**
     * feedbackIds 主键集合
     */
    List<Integer> feedbackIdList = new ArrayList<>();

    public void setFeedbackIdList(List<Integer> feedbackIdList) {
        this.feedbackIdList = feedbackIdList;
    }

    public List<Integer> getFeedbackIdList() {
        return feedbackIdList;
    }

    /**
     * feedbackTime 反馈时间
     */
    @JSONField(name="feedback_time")
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

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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

    public Feedback getFeedback() {
        Feedback feedback = new Feedback();
        feedback.setFeedbackTime(this.getFeedbackTime());
        feedback.setFeedbackId(this.getFeedbackId());
        feedback.setFeedbackOwnerId(this.getFeedbackOwnerId());
        feedback.setFeedbackInfo(this.getFeedbackInfo());
        feedback.setFeedbackNote(this.getFeedbackNote());
        return feedback;
    }
}
