package com.heqing.entity.task;

import com.heqing.constants.FrameNewEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 生成代码中所使用的框架
 * @author heqing
 * @date 2018/10/23 11:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrameNewEntity {

    /** 主键的数量 */
    private Integer keyNum;

    /** 项目打包框架 */
    private FrameNewEnum projectFrame;

    /** 项目框架 */
    private FrameNewEnum serviceFrame;

    /** 数据持久层框架 */
    private FrameNewEnum daoFrame;

    /** 显示控制层框架 */
    private FrameNewEnum controllerFrame;

    /** 页面展示层框架 */
    private FrameNewEnum web;

    /** 生产代码所需要的模板 */
    public void addTemplates() {

    }
}
