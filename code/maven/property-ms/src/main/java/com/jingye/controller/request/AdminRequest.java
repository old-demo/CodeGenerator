package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Admin;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
public class AdminRequest implements Serializable {

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
     * adIds 主键集合
     */
    List<Integer> adIdList = new ArrayList<>();

    public void setAdIdList(List<Integer> adIdList) {
        this.adIdList = adIdList;
    }

    public List<Integer> getAdIdList() {
        return adIdList;
    }

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

    public Admin getAdmin() {
        Admin admin = new Admin();
        admin.setAdInfo(this.getAdInfo());
        admin.setAdAge(this.getAdAge());
        admin.setAdName(this.getAdName());
        admin.setAdSex(this.getAdSex());
        admin.setAdId(this.getAdId());
        return admin;
    }
}
