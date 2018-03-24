package com.heqing.controller.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.entity.orm.Datebase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库连接信息请求参数
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
public class DatebaseRequest implements Serializable {

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
    List<Integer> ids = new ArrayList<>();

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public List<Integer> getIds() {
        return ids;
    }

    /**
     * connectName 连接名
     */
    @JSONField(name="connect_name")
    private String connectName;

    /**
     * driver （方言）数据库类型
     */
    @JSONField(name="driver")
    private String driver;

    /**
     * id id
     */
    @JSONField(name="id")
    private Integer id;

    /**
     * remark 描述
     */
    @JSONField(name="remark")
    private String remark;

    /**
     * url 主机或ip地址
     */
    @JSONField(name="url")
    private String url;

    /**
     * username 登陆用户
     */
    @JSONField(name="username")
    private String username;

    /**
     * dbName 数据库名
     */
    @JSONField(name="db_name")
    private String dbName;

    /**
     * createUser 创建人
     */
    @JSONField(name="create_user")
    private String createUser;

    /**
     * port 端口号
     */
    @JSONField(name="port")
    private Integer port;

    /**
     * password 登陆密码
     */
    @JSONField(name="password")
    private String password;

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

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return port;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Datebase getDatebase() {
        Datebase datebase = new Datebase();
        datebase.setConnectName(this.getConnectName());
        datebase.setDriver(this.getDriver());
        datebase.setId(this.getId());
        datebase.setRemark(this.getRemark());
        datebase.setUrl(this.getUrl());
        datebase.setUsername(this.getUsername());
        datebase.setDbName(this.getDbName());
        datebase.setCreateUser(this.getCreateUser());
        datebase.setPort(this.getPort());
        datebase.setPassword(this.getPassword());
        return datebase;
    }
}
