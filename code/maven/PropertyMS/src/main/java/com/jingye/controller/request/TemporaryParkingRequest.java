package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.TemporaryParking;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class TemporaryParkingRequest implements Serializable {

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
     * tpNote 备注
     */
    @JSONField(name="tp_note")
    private String tpNote;

    /**
     * tpTime 停放时间
     */
    @JSONField(name="tp_time")
    private String tpTime;

    /**
     * tpCharge 收费标准
     */
    @JSONField(name="tp_charge")
    private String tpCharge;

    /**
     * id Id
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

    public void setTpNote(String tpNote) {
        this.tpNote = tpNote;
    }

    public String getTpNote() {
        return tpNote;
    }

    public void setTpTime(String tpTime) {
        this.tpTime = tpTime;
    }

    public String getTpTime() {
        return tpTime;
    }

    public void setTpCharge(String tpCharge) {
        this.tpCharge = tpCharge;
    }

    public String getTpCharge() {
        return tpCharge;
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

    public TemporaryParking getTemporaryParking() {
        TemporaryParking temporaryParking = new TemporaryParking();
        temporaryParking.setTpNote(this.getTpNote());
        temporaryParking.setTpTime(this.getTpTime());
        temporaryParking.setTpCharge(this.getTpCharge());
        temporaryParking.setId(this.getId());
        return temporaryParking;
    }
}
