package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.LinkedList;

/**
 * 类信息的实体
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/06
 */
public class ClassEntity {

    /**
     * classPackage   包名
     */
    private String classPackage;

    /**
     * className   类名
     */
    private String className;

    /**
     * entityName   实例名
     */
    private String entityName;

    /**
     * comment   注解
     */
    private String comment;

    /**
     * authorName   作者名
     */
    private String authorName;

    /**
     * authorEmail   邮件名
     */
    private String authorEmail;

    /**
     * createTime   创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private String createTime;

    /**
     * fields 一般列表
     */
    private LinkedList<FieldEntity> fields;

    /**
     * keyFields 主键列表
     */
    private LinkedList<FieldEntity> keyFields;

    /**
     * noKeyFields 非主键列表
     */
    private LinkedList<FieldEntity> noKeyFields;

    /**
     * notNullfields 不能为空的列表
     */
    private LinkedList<FieldEntity> notNullfields;

    public String getClassPackage() {
        return classPackage;
    }

    public void setClassPackage(String classPackage) {
        this.classPackage = classPackage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public LinkedList<FieldEntity> getFields() {
        return fields;
    }

    public void setFields(LinkedList<FieldEntity> fields) {
        this.fields = fields;
    }

    public LinkedList<FieldEntity> getKeyFields() {
        return keyFields;
    }

    public void setKeyFields(LinkedList<FieldEntity> keyFields) {
        this.keyFields = keyFields;
    }

    public LinkedList<FieldEntity> getNoKeyFields() {
        return noKeyFields;
    }

    public void setNoKeyFields(LinkedList<FieldEntity> noKeyFields) {
        this.noKeyFields = noKeyFields;
    }

    public LinkedList<FieldEntity> getNotNullfields() {
        return notNullfields;
    }

    public void setNotNullfields(LinkedList<FieldEntity> notNullfields) {
        this.notNullfields = notNullfields;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
