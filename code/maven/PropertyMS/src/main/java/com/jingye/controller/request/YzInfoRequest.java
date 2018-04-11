package com.jingye.controller.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.jingye.entity.YzInfo;

/**
 * 请求参数
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class YzInfoRequest implements Serializable {

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
     * yzPassword 密码
     */
    @JSONField(name="yz_password")
    private String yzPassword;

    /**
     * yzBuildingId 所在楼栋id
     */
    @JSONField(name="yz_building_id")
    private String yzBuildingId;

    /**
     * yzNote 备注
     */
    @JSONField(name="yz_note")
    private String yzNote;

    /**
     * yzId 业主id
     */
    @JSONField(name="yz_id")
    private Integer yzId;

    /**
     * yzBirthday 出生日期
     */
    @JSONField(name="yz_birthday")
    private Date yzBirthday;

    /**
     * yzName 姓名
     */
    @JSONField(name="yz_name")
    private String yzName;

    /**
     * yzSex 性别
     */
    @JSONField(name="yz_sex")
    private String yzSex;

    /**
     * yzRoomId 房间号id
     */
    @JSONField(name="yz_room_id")
    private String yzRoomId;

    /**
     * yzLogin 登录账号
     */
    @JSONField(name="yz_login")
    private String yzLogin;

    /**
     * yzTel 联系电话
     */
    @JSONField(name="yz_tel")
    private String yzTel;

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

    public void setYzPassword(String yzPassword) {
        this.yzPassword = yzPassword;
    }

    public String getYzPassword() {
        return yzPassword;
    }

    public void setYzBuildingId(String yzBuildingId) {
        this.yzBuildingId = yzBuildingId;
    }

    public String getYzBuildingId() {
        return yzBuildingId;
    }

    public void setYzNote(String yzNote) {
        this.yzNote = yzNote;
    }

    public String getYzNote() {
        return yzNote;
    }

    public void setYzId(Integer yzId) {
        this.yzId = yzId;
    }

    public Integer getYzId() {
        return yzId;
    }

    public void setYzBirthday(Date yzBirthday) {
        this.yzBirthday = yzBirthday;
    }

    public Date getYzBirthday() {
        return yzBirthday;
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

    public void setYzRoomId(String yzRoomId) {
        this.yzRoomId = yzRoomId;
    }

    public String getYzRoomId() {
        return yzRoomId;
    }

    public void setYzLogin(String yzLogin) {
        this.yzLogin = yzLogin;
    }

    public String getYzLogin() {
        return yzLogin;
    }

    public void setYzTel(String yzTel) {
        this.yzTel = yzTel;
    }

    public String getYzTel() {
        return yzTel;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public YzInfo getYzInfo() {
        YzInfo yzInfo = new YzInfo();
        yzInfo.setYzPassword(this.getYzPassword());
        yzInfo.setYzBuildingId(this.getYzBuildingId());
        yzInfo.setYzNote(this.getYzNote());
        yzInfo.setYzId(this.getYzId());
        yzInfo.setYzBirthday(this.getYzBirthday());
        yzInfo.setYzName(this.getYzName());
        yzInfo.setYzSex(this.getYzSex());
        yzInfo.setYzRoomId(this.getYzRoomId());
        yzInfo.setYzLogin(this.getYzLogin());
        yzInfo.setYzTel(this.getYzTel());
        return yzInfo;
    }
}
