package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Owner;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public class OwnerRequest implements Serializable {

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
     * yzIds 主键集合
     */
    List<Integer> yzIdList = new ArrayList<>();

    public void setYzIdList(List<Integer> yzIdList) {
        this.yzIdList = yzIdList;
    }

    public List<Integer> getYzIdList() {
        return yzIdList;
    }

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

    public Owner getOwner() {
        Owner owner = new Owner();
        owner.setYzInfo(this.getYzInfo());
        owner.setYzPhone(this.getYzPhone());
        owner.setYzName(this.getYzName());
        owner.setYzSex(this.getYzSex());
        owner.setYzId(this.getYzId());
        return owner;
    }
}
