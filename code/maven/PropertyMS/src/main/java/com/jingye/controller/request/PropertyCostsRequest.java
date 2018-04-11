package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.PropertyCosts;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public class PropertyCostsRequest implements Serializable {

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
     * pcBtId 大楼类型id
     */
    @JSONField(name="pc_bt_id")
    private Integer pcBtId;

    /**
     * pcCharge 收费标准
     */
    @JSONField(name="pc_charge")
    private String pcCharge;

    /**
     * pcNote 备注
     */
    @JSONField(name="pc_note")
    private String pcNote;

    /**
     * id id
     */
    @JSONField(name="id")
    private Integer id;

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

    public void setPcBtId(Integer pcBtId) {
        this.pcBtId = pcBtId;
    }

    public Integer getPcBtId() {
        return pcBtId;
    }

    public void setPcCharge(String pcCharge) {
        this.pcCharge = pcCharge;
    }

    public String getPcCharge() {
        return pcCharge;
    }

    public void setPcNote(String pcNote) {
        this.pcNote = pcNote;
    }

    public String getPcNote() {
        return pcNote;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public PropertyCosts getPropertyCosts() {
        PropertyCosts propertyCosts = new PropertyCosts();
        propertyCosts.setPcBtId(this.getPcBtId());
        propertyCosts.setPcCharge(this.getPcCharge());
        propertyCosts.setPcNote(this.getPcNote());
        propertyCosts.setId(this.getId());
        return propertyCosts;
    }
}
