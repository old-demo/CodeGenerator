package com.heqing.entity.orm;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 数据库连接信息实体类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-13 18:06:50
 */
public class Datebase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id id
     */
    private Integer id;

    /**
     * dbName 数据库名
     */
    private String dbName;

    /**
     * port 端口号
     */
    private Integer port;

    /**
     * url 主机或ip地址
     */
    private String url;

    /**
     * password 登陆密码
     */
    private String password;

    /**
     * remark 描述
     */
    private String remark;

    /**
     * updateTime 修改时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * username 登陆用户
     */
    private String username;

    /**
     * connectName 连接名
     */
    private String connectName;

    /**
     * createTime 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * driver （方言）数据库类型
     */
    private String driver;

    /**
     * createUser 创建人
     */
    private String createUser;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getPort() {
        return port;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setConnectName(String connectName) {
        this.connectName = connectName;
    }

    public String getConnectName() {
        return connectName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return driver;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}