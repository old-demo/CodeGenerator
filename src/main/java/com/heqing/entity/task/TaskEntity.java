package com.heqing.entity.task;

import com.heqing.entity.Datebase;
import org.apache.ibatis.session.SqlSession;

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

    public final static String SPRING = "spring";
    public final static String SPRINGBOOT = "springboot";

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
    private List<String> templates = new ArrayList<>();

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

    private String serviceFrame;

    private String daoFrame;

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

    public List<String> getTemplates() {
        return templates;
    }

    public void setTemplates(List<String> templates) {
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

    public String getServiceFrame() {
        return serviceFrame;
    }

    public void setServiceFrame(String serviceFrame) {
        this.serviceFrame = serviceFrame;
    }

    public String getDaoFrame() {
        return daoFrame;
    }

    public void setDaoFrame(String daoFrame) {
        this.daoFrame = daoFrame;
    }

    @Override
    public String toString() {
        StringBuilder tableNamesBuilder = new StringBuilder();
        if(tableNames != null && tableNames.size()>0) {
            tableNamesBuilder.append("tableNames [ ");
            for (String tableName : tableNames) {
                tableNamesBuilder.append(tableName + ", ");
            }
            tableNamesBuilder.append("] ");
        }
        StringBuilder templateBuilder = new StringBuilder();
        if(templates != null && templates.size()>0) {
            templateBuilder.append("templates [ ");
            for (String template : templates) {
                templateBuilder.append(template + ", ");
            }
            templateBuilder.append("] ");
        }
        return "TaskEntity [ datebase = "+datebase +", tableNames = "+tableNamesBuilder.toString()+", packageName = "+packageName+", templates = "+templateBuilder.toString()+
                ", zipPath = "+zipPath+", authorName = "+authorName+", authorEmail = "+authorEmail+", projectName = "+projectName+", serviceFrame = "+serviceFrame+
                ", daoFrame = "+daoFrame+"]";
    }
}
