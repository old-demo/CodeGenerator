package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.RoomType;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class RoomTypeRequest implements Serializable {

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
     * rtIds 主键集合
     */
    List<Integer> rtIdList = new ArrayList<>();

    public void setRtIdList(List<Integer> rtIdList) {
        this.rtIdList = rtIdList;
    }

    public List<Integer> getRtIdList() {
        return rtIdList;
    }

    /**
     * rtName 房型
     */
    @JSONField(name="rt_name")
    private String rtName;

    /**
     * rtNote 备注
     */
    @JSONField(name="rt_note")
    private String rtNote;

    /**
     * rtId 房型id
     */
    @JSONField(name="rt_id")
    private Integer rtId;

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

    public void setRtName(String rtName) {
        this.rtName = rtName;
    }

    public String getRtName() {
        return rtName;
    }

    public void setRtNote(String rtNote) {
        this.rtNote = rtNote;
    }

    public String getRtNote() {
        return rtNote;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
    }

    public Integer getRtId() {
        return rtId;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public RoomType getRoomType() {
        RoomType roomType = new RoomType();
        roomType.setRtName(this.getRtName());
        roomType.setRtNote(this.getRtNote());
        roomType.setRtId(this.getRtId());
        return roomType;
    }
}
