package com.heqing.service.task;

import com.heqing.entity.task.TaskEntity;

/**
 * 代码生成基础任务接口
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/06
 */
public interface BaseTaskService<T extends TaskEntity> {

    /**
     * 检查生成参数
     *
     * @param taskEntity 生成参数信息
     */
    void checkParams(T taskEntity);

    /**
     * 增加模板
     *
     * @param taskEntity 生成参数信息
     */
    void addMobile(T taskEntity);

    /**
     * 合成单个表信息
     *
     * @param taskEntity 生成参数信息
     * @param tableName  表名
     */
    void combileParams(T taskEntity, String tableName);

    /**
     * 生成单个表代码信息
     *
     * @param taskEntity 生成参数信息
     * @param tableName  表名
     */
    void work(T taskEntity, String tableName);

    /**
     * 打包合成的代码
     *
     * @param taskEntity 生成参数信息
     */
    void deploy(T taskEntity);

    /**
     * 销毁无用信息
     *
     * @param taskEntity 生成参数信息
     */
    void destroy(T taskEntity);

    /**
     * 执行生成方法
     *
     * @param taskEntity 生成参数信息
     */
    void execute(T taskEntity);

}
