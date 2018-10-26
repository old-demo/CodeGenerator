package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;
import com.heqing.constants.FrameEnum;
import com.heqing.constants.TemplateEnum;

/**
 * 项目框架
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public class FrameEntity {

    private Integer keyNum;

    /**
     * projectFrame   项目框架
     */
    private FrameEnum projectFrame;

    /**
     * projectFrame   服务层框架
     */
    private FrameEnum serviceFrame;

    /**
     * projectFrame   持久层框架
     */
    private FrameEnum repositoryFrame;

    /**
     * projectFrame   显示控制层框架
     */
    private FrameEnum controllerFrame;

    /**
     * projectFrame   前端框架
     */
    private FrameEnum h5Frame;

    public Integer getKeyNum() {
        return keyNum;
    }

    public void setKeyNum(Integer keyNum) {
        this.keyNum = keyNum;
    }

    public FrameEnum getProjectFrame() {
        return projectFrame;
    }

    public void setProjectFrame(FrameEnum projectFrame) {
        this.projectFrame = projectFrame;
    }

    public FrameEnum getServiceFrame() {
        return serviceFrame;
    }

    public void setServiceFrame(FrameEnum serviceFrame) {
        this.serviceFrame = serviceFrame;
    }

    public FrameEnum getRepositoryFrame() {
        return repositoryFrame;
    }

    public void setRepositoryFrame(FrameEnum repositoryFrame) {
        this.repositoryFrame = repositoryFrame;
    }

    public FrameEnum getControllerFrame() {
        return controllerFrame;
    }

    public void setControllerFrame(FrameEnum controllerFrame) {
        this.controllerFrame = controllerFrame;
    }

    public FrameEnum getH5Frame() {
        return h5Frame;
    }

    public void setH5Frame(FrameEnum h5Frame) {
        this.h5Frame = h5Frame;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

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
        } else if(keyNum < 1 && repositoryFrame == FrameEnum.Dao.HIBERNATE) {
            return ;
        }

        taskEntity.getTemplates().add(TemplateEnum.LOG);
        if(projectFrame == FrameEnum.Project.MAVEN) {
            taskEntity.getTemplates().add(TemplateEnum.POM);
        }

        taskEntity.getTemplates().add(TemplateEnum.UTIL_VALIDATE);
        taskEntity.getTemplates().add(TemplateEnum.UTIL_PAGE_INFO);
        if(repositoryFrame == FrameEnum.Dao.MYBATIS) {
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_ENTITY);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_DAO);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_MAPPER);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICE);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_SERVICE_IMPL);
            taskEntity.getTemplates().add(TemplateEnum.MYBATIS_TEST);
        } else if(repositoryFrame == FrameEnum.Dao.HIBERNATE) {
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ENTITY);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICE);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_SERVICE_IMPL);
            taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_TEST);
        }

        if(serviceFrame == FrameEnum.Service.SPRING) {
            taskEntity.getTemplates().add(TemplateEnum.SPRING_CONFIG_TEST);
            if(repositoryFrame == FrameEnum.Dao.MYBATIS) {
                taskEntity.getTemplates().add(TemplateEnum.MYBATIS_CONFIG_TEST);
            }else if(repositoryFrame == FrameEnum.Dao.HIBERNATE) {
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_CONFIG_TEST);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ABSTRACT);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_ABSTRACT_IMPL);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_REPOSITORY);
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_REPOSITORY_IMPL);
            }
        } else if(serviceFrame == FrameEnum.Service.SPRING_BOOT) {
            if(repositoryFrame == FrameEnum.Dao.HIBERNATE) {
                taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_DAO);
            }
            taskEntity.getTemplates().add(TemplateEnum.APPLICATION_TEST);
            taskEntity.getTemplates().add(TemplateEnum.APPLICATION_PROPERTIES_TEST);
        }

        if(controllerFrame != null) {
            taskEntity.getTemplates().add(TemplateEnum.REQUEST);
            taskEntity.getTemplates().add(TemplateEnum.UTIL_RESPONSE);
            if(serviceFrame == FrameEnum.Service.SPRING) {
                taskEntity.getTemplates().add(TemplateEnum.WEB);
                taskEntity.getTemplates().add(TemplateEnum.SPRING_CONFIG);
                if(repositoryFrame == FrameEnum.Dao.MYBATIS) {
                    taskEntity.getTemplates().add(TemplateEnum.MYBATIS_CONFIG);
                }else if(repositoryFrame == FrameEnum.Dao.HIBERNATE) {
                    taskEntity.getTemplates().add(TemplateEnum.HIBERNATE_CONFIG);
                }
            }else if(serviceFrame == FrameEnum.Service.SPRING_BOOT) {
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION);
                taskEntity.getTemplates().add(TemplateEnum.APPLICATION_PROPERTIES);
            }
            if (controllerFrame == FrameEnum.Controller.SPRING_MVC) {
                taskEntity.getTemplates().add(TemplateEnum.SPRING_CONTROLLER);
                if(serviceFrame == FrameEnum.Service.SPRING) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_MVC);
                }
            }
            if(h5Frame == FrameEnum.Web.BOOTSTRAP) {
                if(serviceFrame == FrameEnum.Service.SPRING) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_HTML);
                    taskEntity.getTemplates().add(TemplateEnum.SPRING_JS);
                } else if(serviceFrame == FrameEnum.Service.SPRING_BOOT) {
                    taskEntity.getTemplates().add(TemplateEnum.SPRINGBOOT_HTML);
                    taskEntity.getTemplates().add(TemplateEnum.SPRINGBOOT_JS);
                }
            }
        }
    }

}
