package com.heqing.controller.request;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.heqing.entity.orm.Column;
import com.heqing.entity.orm.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库 表请求参数
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
public class TableRequest  implements Serializable {

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
     * tableNameList 表名集合
     */
    @JSONField(name="table_name_list")
    private List<String> tableNameList = new ArrayList<>();

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
     * name 表名
     */
    @JSONField(name="table_name")
    private String tableName;

    /**
     * type 表类型
     */
    @JSONField(name="type")
    private String type;

    /**
     * engine 数据库引擎
     */
    @JSONField(name="engine")
    private String engine;

    /**
     * rowFormat 行格式
     */
    @JSONField(name="row_format")
    private String rowFormat;

    /**
     * rowsNum 行数
     */
    @JSONField(name="rows_num")
    private Integer rowsNum;

    /**
     * collation 编码
     */
    @JSONField(name="collation")
    private String collation;

    /**
     * comment 注解
     */
    @JSONField(name="comment")
    private String comment;

    /**
     * autoIncrement 自动递增
     */
    @JSONField(name="auto_increment")
    private Integer autoIncrement;

    /**
     * indexLength 索引长度
     */
    @JSONField(name="index_length")
    private Double indexLength;

    /**
     * dateLength 数据长度
     */
    @JSONField(name="date_length")
    private Double dateLength;

    /**
     * maxDateLength 最大数据长度
     */
    @JSONField(name="max_date_length")
    private Double maxDateLength;

    /**
     * columns 列信息列表
     */
    @JSONField(name="column_list")
    private List<Column> columnList;

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

    public List<String> getTableNameList() {
        return tableNameList;
    }

    public void setTableNameList(List<String> tableNameList) {
        this.tableNameList = tableNameList;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getRowFormat() {
        return rowFormat;
    }

    public void setRowFormat(String rowFormat) {
        this.rowFormat = rowFormat;
    }

    public Integer getRowsNum() {
        return rowsNum;
    }

    public void setRowsNum(Integer rowsNum) {
        this.rowsNum = rowsNum;
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(Integer autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public Double getIndexLength() {
        return indexLength;
    }

    public void setIndexLength(Double indexLength) {
        this.indexLength = indexLength;
    }

    public Double getDateLength() {
        return dateLength;
    }

    public void setDateLength(Double dateLength) {
        this.dateLength = dateLength;
    }

    public Double getMaxDateLength() {
        return maxDateLength;
    }

    public void setMaxDateLength(Double maxDateLength) {
        this.maxDateLength = maxDateLength;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public Table getTable() {
        Table table = new Table();
        table.setDbName(this.getDbName());
        table.setTableName(this.getTableName());
        table.setType(this.getType());
        table.setEngine(this.getEngine());
        table.setRowFormat(this.getRowFormat());
        table.setRowsNum(this.getRowsNum());
        table.setCollation(this.getCollation());
        table.setComment(this.getComment());
        table.setAutoIncrement(this.getAutoIncrement());
        table.setIndexLength(this.getIndexLength());
        table.setDateLength(this.getDateLength());
        table.setMaxDateLength(this.getMaxDateLength());
        table.setColumnList(this.getColumnList());
        return table;
    }
}
