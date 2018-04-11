package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.ComplaintsInfo;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class ComplaintsInfoRequest implements Serializable {

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
     * ids 主键集合
     */
    List<Integer> idList = new ArrayList<>();

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    /**
     * cpTime 投诉时间
     */
    @JSONField(name="cp_time")
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

    public ComplaintsInfo getComplaintsInfo() {
        ComplaintsInfo complaintsInfo = new ComplaintsInfo();
        complaintsInfo.setCpTime(this.getCpTime());
        complaintsInfo.setCpNote(this.getCpNote());
        complaintsInfo.setCpYzId(this.getCpYzId());
        complaintsInfo.setCpResult(this.getCpResult());
        complaintsInfo.setId(this.getId());
        complaintsInfo.setCpContent(this.getCpContent());
        return complaintsInfo;
    }
}
