package com.heqing.controller.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.entity.orm.Column;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库列信息请求参数
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
public class ColumnRequest implements Serializable {

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
     * columnNameList 列名集合
     */
    @JSONField(name="column_name_list")
    private List<String> columnNameList = new ArrayList<>();

    /**
     * dbId 数据库id
     */
    @JSONField(name="db_id")
    private Integer dbId;

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
     * comment 额外的
     */
    @JSONField(name="extra")
    private String extra;

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

    public List<String> getColumnNameList() {
        return columnNameList;
    }

    public void setColumnNameList(List<String> columnNameList) {
        this.columnNameList = columnNameList;
    }

    public Integer getDbId() {
        return dbId;
    }

    public void setDbId(Integer dbId) {
        this.dbId = dbId;
    }

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

    public Column getColumn() {
        Column column = new Column();
        column.setDbName(this.getDbName());
        column.setTableName(this.getTableName());
        column.setColumnName(this.getColumnName());
        column.setPosition(this.getPosition());
        column.setIsNullAble(this.getIsNullAble());
        column.setDateType(this.getDateType());
        column.setMaximumLength(this.getMaximumLength());
        column.setPrecision(this.getPrecision());
        column.setCollation(this.getCollation());
        column.setType(this.getType());
        column.setKey(this.getKey());
        column.setComment(this.getComment());
        column.setExtra(this.getExtra());
        return column;
    }
}
