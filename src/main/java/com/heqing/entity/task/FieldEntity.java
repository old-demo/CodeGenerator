package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;

/**
 * 字段信息的实体
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/06
 */
public class FieldEntity {

    /**
     * filedName   字段名
     */
    private String filedName;

    /**
     * entityName   字段实例名
     */
    private String entityName;

    /**
     * type   字段类型
     */
    private String type;

    /**
     * comment   注解
     */
    private String comment;

    /**
     * columnName   表中列名
     */
    private String columnName;

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

}
