package com.heqing.entity.orm;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

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
    @JSONField(name="db_name")
    private String dbName;

    /**
     * tableName 表名
     */
    @JSONField(name="table_name")
    private String tableName;

    /**
     * name 列名
     */
    @JSONField(name="column_name")
    private String columnName;

    /**
     * position 位置
     */
    @JSONField(name="position")
    private Integer position;

    /**
     * isNullAble 是否允许为null
     */
    @JSONField(name="is_null_able")
    private String isNullAble;

    /**
     * dateType 数据类型
     */
    @JSONField(name="date_type")
    private String dateType;

    /**
     * maximumLength 长度
     */
    @JSONField(name="maximum_length")
    private Double maximumLength;

    /**
     * precision 精度
     */
    @JSONField(name="precision")
    private Double precision;

    /**
     * collation 编码
     */
    @JSONField(name="collation")
    private String collation;

    /**
     * type 列类型
     */
    @JSONField(name="type")
    private String type;

    /**
     * key 约束 PRI主键约束； UNI唯一约束；MUL可以重复。
     */
    @JSONField(name="key")
    private String key;

    /**
     * comment 注解
     */
    @JSONField(name="comment")
    private String comment;

    /**
     * extra 额外的
     */
    @JSONField(name="extra")
    private String extra;

    /**
     * column_default 默认值
     */
    @JSONField(name="column_default")
    private String columnDefault;

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

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
