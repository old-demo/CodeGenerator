package com.heqing.service.task.impl;

import com.heqing.entity.task.MavenTaskEntity;
import com.heqing.entity.task.TaskEntity;
import com.heqing.service.task.MavenTaskService;
import com.heqing.util.TemplatesUtil;
import org.springframework.stereotype.Service;

/**
 * 生成任务的参数信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/02/09
 */
@Service
public class MavenTaskServiceImpl extends BaseTaskServiceImpl<MavenTaskEntity> implements MavenTaskService {

    @Override
    public void addMobile(MavenTaskEntity taskEntity) {
        super.addMobile(taskEntity);
        taskEntity.getTemplates().add(TemplatesUtil.POM);
    }

    @Override
    public void combileParams(MavenTaskEntity taskEntity, String tableName) {
        super.combileParams(taskEntity, tableName);
        taskMap.put("groupId", taskEntity.getGroupId());
        taskMap.put("artifactId", taskEntity.getArtifactId());
        taskMap.put("version", taskEntity.getVersion());
        taskMap.put("description", taskEntity.getDescription());
    }
}
