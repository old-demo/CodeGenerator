package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.BuildingInfo;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class BuildingInfoRequest implements Serializable {

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
     * bdAdminId 大楼管理员id
     */
    @JSONField(name="bd_admin_id")
    private Integer bdAdminId;

    /**
     * bdId 大楼编号
     */
    @JSONField(name="bd_id")
    private String bdId;

    /**
     * bdKindId 大楼类型
     */
    @JSONField(name="bd_kind_id")
    private Integer bdKindId;

    /**
     * bdHead 朝向
     */
    @JSONField(name="bd_head")
    private String bdHead;

    /**
     * id id
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * bdArea 占地面积
     */
    @JSONField(name="bd_area")
    private String bdArea;

    /**
     * bdNote 备注
     */
    @JSONField(name="bd_note")
    private String bdNote;

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

    public void setBdAdminId(Integer bdAdminId) {
        this.bdAdminId = bdAdminId;
    }

    public Integer getBdAdminId() {
        return bdAdminId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    public String getBdId() {
        return bdId;
    }

    public void setBdKindId(Integer bdKindId) {
        this.bdKindId = bdKindId;
    }

    public Integer getBdKindId() {
        return bdKindId;
    }

    public void setBdHead(String bdHead) {
        this.bdHead = bdHead;
    }

    public String getBdHead() {
        return bdHead;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBdArea(String bdArea) {
        this.bdArea = bdArea;
    }

    public String getBdArea() {
        return bdArea;
    }

    public void setBdNote(String bdNote) {
        this.bdNote = bdNote;
    }

    public String getBdNote() {
        return bdNote;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public BuildingInfo getBuildingInfo() {
        BuildingInfo buildingInfo = new BuildingInfo();
        buildingInfo.setBdAdminId(this.getBdAdminId());
        buildingInfo.setBdId(this.getBdId());
        buildingInfo.setBdKindId(this.getBdKindId());
        buildingInfo.setBdHead(this.getBdHead());
        buildingInfo.setId(this.getId());
        buildingInfo.setBdArea(this.getBdArea());
        buildingInfo.setBdNote(this.getBdNote());
        return buildingInfo;
    }
}
