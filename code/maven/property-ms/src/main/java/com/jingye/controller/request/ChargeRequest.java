package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.Charge;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
public class ChargeRequest implements Serializable {

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
     * chargeIds 主键集合
     */
    List<Integer> chargeIdList = new ArrayList<>();

    public void setChargeIdList(List<Integer> chargeIdList) {
        this.chargeIdList = chargeIdList;
    }

    public List<Integer> getChargeIdList() {
        return chargeIdList;
    }

    /**
     * chargeId 收费标准id
     */
    @JSONField(name="charge_id")
    private Integer chargeId;

    /**
     * chargeName 收费标准名
     */
    @JSONField(name="charge_name")
    private String chargeName;

    /**
     * chargeInfo 备注
     */
    @JSONField(name="charge_info")
    private String chargeInfo;

    /**
     * chargeMoney 收费金额
     */
    @JSONField(name="charge_money")
    private String chargeMoney;

    /**
     * chargeKind 收费标准类别
     */
    @JSONField(name="charge_kind")
    private String chargeKind;

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

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeInfo(String chargeInfo) {
        this.chargeInfo = chargeInfo;
    }

    public String getChargeInfo() {
        return chargeInfo;
    }

    public void setChargeMoney(String chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public String getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeKind(String chargeKind) {
        this.chargeKind = chargeKind;
    }

    public String getChargeKind() {
        return chargeKind;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Charge getCharge() {
        Charge charge = new Charge();
        charge.setChargeId(this.getChargeId());
        charge.setChargeName(this.getChargeName());
        charge.setChargeInfo(this.getChargeInfo());
        charge.setChargeMoney(this.getChargeMoney());
        charge.setChargeKind(this.getChargeKind());
        return charge;
    }
}
