package com.heqing.constants;

/**
 * 项目框架
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public interface FrameEnum {

    /**
     * 构建工具
     */
    enum Project implements FrameEnum {
        // 普通引用jar包方式。
        JAR,
        // 以project object model (POM)概念来管理项目。
        MAVEN,
        // Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软件。
        GRADLE;
    }

    /**
     * 设计层面框架
     */
    enum Service implements FrameEnum {
        // 解决的是业务逻辑层和其他各层的松耦合问题。
        SPRING,
        // 简化新Spring应用的初始搭建以及开发过程。
        SPRING_BOOT;
    }

    /**
     * 数据层框架
     */
    enum Dao implements FrameEnum {
        // 对象关系映射框架，自动生成SQL。
        HIBERNATE,
        // 使用简单的 XML 或注解来配置和映射原生信息。
        MYBATIS;
    }

    /**
     * 页面控制层框架
     */
    enum Controller implements FrameEnum {
        // 构建 Web 应用程序的全功能 MVC 模块。
        SPRING_MVC,
        // 建立模型与视图的数据交互，本质上相当于一个servlet。
        STRUTS_2;
    }

    /**
     * 页面展示层框架
     */
    enum Web implements FrameEnum {
        // 基于HTML、CSS、JavaScript 开发的简洁、直观、强悍的前端开发框架。
        BOOTSTRAP,
        // 最为核心的是：MVW（Model-View-Whatever）、模块化、自动化双向数据绑定、语义化标签、依赖注入等等。
        ANGULAR,
        // 特点：声明式设计、高效、灵活等等。
        REACT,
        // 构建用户界面的渐进式框架。通过尽可能简单的 API 实现响应的数据绑定和组合的视图组件。
        VUE;
    }

}
