package com.heqing.constants;

import com.heqing.entity.task.TaskEntity;

import java.util.Map;
import java.util.Set;

/**
 * 生成代码中所包含的框架
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public enum FrameEnum {

    /*
     * jar jar项目
     */
    JAR("jar"),
    /*
     * maven maven项目
     */
    MAVEN("maven"),
    /*
     * spring Spring框架
     */
    SPRING("spring"),
    /*
     * springboot springboot框架
     */
    SPRINGBOOT("springboot"),
    /*
     * hibernate hibernate框架
     */
    HIBERNATE("hibernate"),
    /*
     * mybatis mybatis框架
     */
    MYBATIS("mybatis"),
    /*
     * springmvc springmvc框架
     */
    SPRINGMVC("springmvc"),
    /*
     * strtus2 strtus2框架
     */
    STRUTS2("struts2");

    private final String frame;

    private FrameEnum(String frame) {
        this.frame = frame;
    }

    public static void addTemplates(TaskEntity taskEntity) {
        taskEntity.getTemplates().clear();
        int keyNum = taskEntity.getFrame().getKeyNum();

        FrameEnum projectFrame = taskEntity.getFrame().getProjectFrame();
        switch (projectFrame) {
            case MAVEN:
                taskEntity.getTemplates().add(TemplateEnum.POM);
                break;
            case JAR:
                break;
            default:;
        }

        FrameEnum serviceFrame = taskEntity.getFrame().getServiceFrame();
        switch (serviceFrame) {
            case SPRING:
                taskEntity.getTemplates().add(TemplateEnum.SPRING_CONFIG);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_CONFIG);
                break;
            case SPRINGBOOT:
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION);
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION_PROPERTIES);
                break;
            default:;
        }

        FrameEnum repositoryFrame = taskEntity.getFrame().getRepositoryFrame();
        switch (repositoryFrame) {
            case MYBATIS:
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_ENTITY);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_DAO);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_MAPPER);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICE);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICEIMPL);
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_TEST);
                break;
            case HIBERNATE:
                if(keyNum > 0) {
                    if (keyNum > 1) {
                        taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ENTITY_PK);
                    }
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ENTITY);
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_DAO);
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICE);
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICEIMPL);
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_TEST);
                    taskEntity.getTemplates().add(TemplateEnum.UTIL_PAGEINFO);
                } else {
                    taskEntity.getTemplates().clear();
                }
                break;
            default:;
        }
    }

}
