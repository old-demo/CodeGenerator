package com.heqing.entity.orm;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 数据库 列实体类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
public class Column implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * dbName 数据库名
     */
    private String dbName;

    /**
     * tableName 表名
     */
    private String tableName;

    /**
     * name 列名
     */
    private String columnName;

    /**
     * position 位置
     */
    private Integer position;

    /**
     * isNullAble 是否允许为null
     */
    private String isNullAble;

    /**
     * dateType 数据类型
     */
    private String dateType;

    /**
     * maximumLength 长度
     */
    private Double maximumLength;

    /**
     * precision 精度
     */
    private Double precision;

    /**
     * collation 编码
     */
    private String collation;

    /**
     * type 列类型
     */
    private String type;

    /**
     * key 约束 PRI主键约束； UNI唯一约束；MUL可以重复。
     */
    private String key;

    /**
     * comment 注解
     */
    private String comment;

    /**
     * comment 额外的
     */
    private String extra;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getIsNullAble() {
        return isNullAble;
    }

    public void setIsNullAble(String isNullAble) {
        this.isNullAble = isNullAble;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public Double getMaximumLength() {
        return maximumLength;
    }

    public void setMaximumLength(Double maximumLength) {
        this.maximumLength = maximumLength;
    }

    public Double getPrecision() {
        return precision;
    }

    public void setPrecision(Double precision) {
        this.precision = precision;
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
