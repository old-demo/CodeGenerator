package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;
import com.heqing.constants.TemplateEnum;
import com.heqing.entity.orm.Datebase;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成任务的参数信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/08
 */
public class TaskEntity {

    /**
     * datebase 数据操作
     */
    private Datebase datebase;

    /**
     * tableName 表名
     */
    private List<String> tableNames;

    /**
     * classPackage   包名
     */
    private String packageName;

    /**
     * templates 模板名
     */
    private List<TemplateEnum> templates = new ArrayList<>();

    /**
     * zip输出路径
     */
    private String zipPath;

    /**
     * authorName   作者名
     */
    private String authorName;

    /**
     * authorEmail   邮件名
     */
    private String authorEmail;

    /**
     * projectName   项目名
     */
    private String projectName;

    /**
     * frame    项目框架
     */
    private FrameEntity frame;

    public Datebase getDatebase() {
        return datebase;
    }

    public void setDatebase(Datebase datebase) {
        this.datebase = datebase;
    }

    public List<String> getTableNames() {
        return tableNames;
    }

    public void setTableNames(List<String> tableNames) {
        this.tableNames = tableNames;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<TemplateEnum> getTemplates() {
        return templates;
    }

    public void setTemplates(List<TemplateEnum> templates) {
        this.templates = templates;
    }

    public String getZipPath() {
        return zipPath;
    }

    public void setZipPath(String zipPath) {
        this.zipPath = zipPath;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public FrameEntity getFrame() {
        return frame;
    }

    public void setFrame(FrameEntity frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
