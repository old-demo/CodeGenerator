package com.heqing.entity.task;

import com.alibaba.fastjson.JSONObject;
import com.heqing.constants.FrameEnum;

/**
 * 项目框架
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public class FrameEntity {

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
}
