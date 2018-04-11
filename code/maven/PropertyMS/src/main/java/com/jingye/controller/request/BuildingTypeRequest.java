package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.BuildingType;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class BuildingTypeRequest implements Serializable {

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
     * id id
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * btNote 备注
     */
    @JSONField(name="bt_note")
    private String btNote;

    /**
     * btName 大楼类型
     */
    @JSONField(name="bt_name")
    private String btName;

    /**
     * btRoomNumber 住宅户数
     */
    @JSONField(name="bt_room_number")
    private Integer btRoomNumber;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBtNote(String btNote) {
        this.btNote = btNote;
    }

    public String getBtNote() {
        return btNote;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public String getBtName() {
        return btName;
    }

    public void setBtRoomNumber(Integer btRoomNumber) {
        this.btRoomNumber = btRoomNumber;
    }

    public Integer getBtRoomNumber() {
        return btRoomNumber;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public BuildingType getBuildingType() {
        BuildingType buildingType = new BuildingType();
        buildingType.setId(this.getId());
        buildingType.setBtNote(this.getBtNote());
        buildingType.setBtName(this.getBtName());
        buildingType.setBtRoomNumber(this.getBtRoomNumber());
        return buildingType;
    }
}
