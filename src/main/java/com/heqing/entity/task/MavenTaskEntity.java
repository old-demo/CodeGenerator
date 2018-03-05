package com.heqing.entity.task;

/**
 * 生成任务的参数信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/02/05
 */
public class MavenTaskEntity extends TaskEntity {

    private String groupId;
    private String artifactId;
    private String version;
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
        return "MavenTaskEntity [ "+super.toString()+" groupId = "+groupId+", artifactId = "+artifactId+
                ", version = "+version+", description = "+description+"]";
    }
}
