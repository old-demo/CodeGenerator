package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;

/**
 * 生成任务的参数信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/02/05
 */
public class MavenTaskEntity extends TaskEntity {

    /**
     * groupId 项目组织唯一的标识符
     */
    private String groupId;

    /**
     *  artifactId 项目的唯一的标识符
     */
    private String artifactId;

    /**
     * version 版本号
     */
    private String version;

    /**
     * description 描述
     */
    private String description;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
