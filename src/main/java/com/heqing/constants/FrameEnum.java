package com.heqing.constants;

import com.heqing.entity.task.TaskEntity;

/**
 * 根据配置，添加需要的代码模板
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public enum FrameEnum {

    // 普通java项目
    JAR("jar"),

    // maven项目
    MAVEN("maven"),

    // Spring框架
    SPRING("spring"),

    // springBoot框架
    SPRING_BOOT("spring_Boot"),

    // hibernate框架
    HIBERNATE("hibernate"),

    // mybatis框架
    MYBATIS("mybatis"),

    // spring_mvc框架
    SPRING_MVC("spring_MVC"),

    // struts2框架
    STRUTS2("struts2"),

    // bootstrap框架
    BOOTSTRAP("bootstrap");

    public static void addTemplates(TaskEntity taskEntity) {
        taskEntity.getTemplates().clear();

        // 表中主键数量
        int keyNum = taskEntity.getFrame().getKeyNum();
        // 项目框架
        FrameEnum projectFrame = taskEntity.getFrame().getProjectFrame();
        // 底层框架
        FrameEnum serviceFrame = taskEntity.getFrame().getServiceFrame();
        // 数据访问层框架
        FrameEnum repositoryFrame = taskEntity.getFrame().getRepositoryFrame();
        // 控制层框架
        FrameEnum controllerFrame = taskEntity.getFrame().getControllerFrame();
        // 显示层框架
        FrameEnum h5Frame = taskEntity.getFrame().getH5Frame();

        if(keyNum > 1) {
            taskEntity.getTemplates().add(TemplateEnum.ENTITY_PK);
        } else if(keyNum < 1 && repositoryFrame == HIBERNATE) {
            return ;
        }

        if(projectFrame == MAVEN) {
            taskEntity.getTemplates().add(TemplateEnum.POM);
        }

        taskEntity.getTemplates().add(TemplateEnum.UTIL_PAGE_INFO);
        if(repositoryFrame == MYBATIS) {
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_ENTITY);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_DAO);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_MAPPER);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICE);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICE_IMPL);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_TEST);
        } else if(repositoryFrame == HIBERNATE) {
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ENTITY);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICE);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICE_IMPL);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_TEST);
        }

        if(serviceFrame == SPRING) {
            taskEntity.getTemplates().add(TemplateEnum.SPRING_CONFIG_TEST);
            if(repositoryFrame == MYBATIS) {
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_CONFIG_TEST);
            }else if(repositoryFrame == HIBERNATE) {
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_CONFIG_TEST);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ABSTRACT);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ABSTRACT_IMPL);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_REPOSITORY);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_REPOSITORY_IMPL);
            }
        } else if(serviceFrame == SPRING_BOOT) {
            if(repositoryFrame == HIBERNATE) {
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_DAO);
            }
            taskEntity.getTemplates().add(TemplateEnum.APPLICATION_TEST);
            taskEntity.getTemplates().add(TemplateEnum.APPLICATION_PROPERTIES_TEST);
        }

        if(controllerFrame != null) {
            taskEntity.getTemplates().add(TemplateEnum.REQUEST);
            taskEntity.getTemplates().add(TemplateEnum.UTIL_RESPONSE);
            if(serviceFrame == SPRING) {
                taskEntity.getTemplates().add(TemplateEnum.WEB);
                taskEntity.getTemplates().add(TemplateEnum.SPRING_CONFIG);
                if(repositoryFrame == MYBATIS) {
                    taskEntity.getTemplates().add(TemplateEnum.MYBATIS_CONFIG);
                }else if(repositoryFrame == HIBERNATE) {
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_CONFIG);
                }
            }else if(serviceFrame == SPRING_BOOT) {
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION);
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION_PROPERTIES);
            }
            if (controllerFrame == SPRING_MVC) {
                taskEntity.getTemplates().add(TemplateEnum.SPRING_CONTROLLER);
                if(serviceFrame == SPRING) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_MVC);
                }
            }
            if(h5Frame == BOOTSTRAP) {
                if(serviceFrame == SPRING) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_HTML);
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_JS);
                } else if(serviceFrame == SPRING_BOOT) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRINGBOOT_HTML);
                    taskEntity.getTemplates().add(TemplateEnum.SPRINGBOOT_JS);
                }
            }
        }
    }

    String frame;

    FrameEnum(String frame) {
        this.frame = frame;
    }

}
