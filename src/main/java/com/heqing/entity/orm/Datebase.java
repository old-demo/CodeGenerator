package com.heqing.entity.orm;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据库连接信息实体类
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
public class Datebase implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * updateTime 修改时间
     */
    @JSONField(name="update_time", format="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

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
     * createTime 创建时间
     */
    @JSONField(name="create_time", format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

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

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
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
}
