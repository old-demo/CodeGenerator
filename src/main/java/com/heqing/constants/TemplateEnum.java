package com.heqing.constants;

import org.apache.commons.lang.StringUtils;

/**
 * 生成代码中所使用的代码模板
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public enum TemplateEnum {

    // maven项目pom文件
    POM("pom", "pom.xml.vm"),

    // 分页工具类
    UTIL_PAGE_INFO("pageInfoUtil", "util/PageInfoUtil.java.vm"),

    // 返回数据封装类
    UTIL_RESPONSE("responseUtil", "util/ResponseUtil.java.vm"),

    // springBoot 主类
    APPLICATION("application", "spring/Application.java.vm"),

    // springBoot 测试主类
    APPLICATION_TEST("applicationTest", "spring/Application.java.vm"),

    // springBoot 配置文件
    APPLICATION_PROPERTIES("applicationProperties", "spring/Application.properties.vm"),

    // springBoot 测试配置文件
    APPLICATION_PROPERTIES_TEST("applicationPropertiesTest", "spring/Application.properties.vm"),

    // spring 框架配置文件
    SPRING_CONFIG("springConfig", "spring/SpringConfig.xml.vm"),

    // spring 框架测试配置文件
    SPRING_CONFIG_TEST("springConfigTest", "spring/SpringConfig.xml.vm"),

    // spring 控制层
    SPRING_CONTROLLER("springController", "spring/SpringController.java.vm"),

    // springMVC 配置文件
    SPRING_MVC("springMVC", "spring/SpringMVC.xml.vm"),

    // 请求参数封装
    REQUEST("request", "Request.java.vm"),

    // struts2 控制层
    STRUTS2_CONTROLLER("strutsController", "StrutsController.java.vm"),

    // 主键封装类
    ENTITY_PK("entityPK", "EntityPK.java.vm"),

    // mybatis 实体类
    MYBATIS_ENTITY("MybatisEntity", "mybatis/MybatisEntity.java.vm"),

    // mybatis 持久层接口
    MYBATIS_DAO("mybatisDao", "mybatis/MybatisDao.java.vm"),

    //  mybatis 持久层映射文件
    MYBATIS_MAPPER("mybatisMapper", "mybatis/MybatisMapper.xml.vm"),

    // mybatis 业务逻辑层接口
    MYBATIS_SERVICE("mybatisService", "mybatis/MybatisService.java.vm"),

    // mybatis 业务逻辑层实现类
    MYBATIS_SERVICE_IMPL("mybatisServiceImpl", "mybatis/MybatisServiceImpl.java.vm"),

    // mybatis 测试类
    MYBATIS_TEST("mybatisTest", "mybatis/MybatisTest.java.vm"),

    // mybatis 配置文件
    MYBATIS_CONFIG("mybatisConfig", "mybatis/MybatisConfig.xml.vm"),

    // mybatis 测试配置文件
    MYBATIS_CONFIG_TEST("mybatisConfigTest", "mybatis/MybatisConfig.xml.vm"),

    // hibernate 实体类
    HIBERNATE_ENTITY("hibernateEntity", "hibernate/HibernateEntity.java.vm"),

    // hibernate 持久层接口
    HIBERNATE_DAO("hibernateDao", "hibernate/HibernateDao.java.vm"),

    // hibernate 持久层基础接口
    HIBERNATE_ABSTRACT("hibernateAbstract", "hibernate/AbstractRepository.java.vm"),

    // hibernate 持久层基础基础实现类
    HIBERNATE_ABSTRACT_IMPL("hibernateAbstractImpl", "hibernate/AbstractRepositoryImpl.java.vm"),

    // hibernate 数据访问层接口
    HIBERNATE_REPOSITORY("hibernateRepository", "hibernate/HibernateRepository.java.vm"),

    // hibernate 数据访问层实现类
    HIBERNATE_REPOSITORY_IMPL("hibernateRepositoryImpl", "hibernate/HibernateRepositoryImpl.java.vm"),

    // hibernate业务逻辑层接口
    HIBERNATE_SERVICE("hibernateService", "hibernate/HibernateService.java.vm"),

    // hibernate业务逻辑层实现类
    HIBERNATE_SERVICE_IMPL("hibernateServiceImpl", "hibernate/HibernateServiceImpl.java.vm"),

    // hibernate 测试类
    HIBERNATE_TEST("hibernateTest", "hibernate/HibernateTest.java.vm"),

    // hibernate 配置文件
    HIBERNATE_CONFIG("hibernateConfig", "hibernate/HibernateConfig.xml.vm"),

    // hibernate 测试配置文件
    HIBERNATE_CONFIG_TEST("hibernateConfigTest", "hibernate/HibernateConfig.xml.vm"),

    // web项目配置文件
    WEB("web", "Web.xml.vm"),

    // 列表页样式文件
    TABLE_HTML("tableHtml", "view/Table.html.vm"),

    // 列表页js文件
    TABLE_JS("tableJs", "view/Table.js.vm");

    public static String getFilePath(String projectName, TemplateEnum template, String packageName, String className) {
        String filePatch = projectName+"/";
        String packagePath = "";
        if(StringUtils.isNotBlank(packageName)){
            packagePath = packageName.replace(".", "/");
        }

        String mainCode = "src/main/java/", testCode = "src/test/java/";
        String mainConfig = "src/main/resources/", testConfig = "src/test/resources/";
        String viewFile = "src/main/resources/WEB-INF/";

        switch (template) {
            case POM:
                filePatch += "pom.xml";
                break;
            case UTIL_RESPONSE:
                filePatch += mainCode + packagePath + "/util/ResponseUtil.java";
                break;
            case UTIL_PAGE_INFO:
                filePatch += mainCode + packagePath + "/util/PageInfoUtil.java";
                break;
            case APPLICATION:
                filePatch += mainCode + packagePath+ "/" +projectName+"Application.java";
                break;
            case APPLICATION_TEST:
                filePatch += testCode + packagePath+ "/" +projectName+"Application.java";
                break;
            case APPLICATION_PROPERTIES:
                filePatch += mainConfig + "application.properties";
                break;
            case APPLICATION_PROPERTIES_TEST:
                filePatch += testConfig + "application.properties";
                break;
            case SPRING_CONFIG:
                filePatch += mainConfig + "spring_core.xml";
                break;
            case SPRING_CONFIG_TEST:
                filePatch += testConfig + "spring_core.xml";
                break;
            case SPRING_CONTROLLER:
            case STRUTS2_CONTROLLER:
                filePatch += mainCode + packagePath + "/controller/" + className + "Controller.java";
                break;
            case SPRING_MVC:
                filePatch += mainConfig + "spring_mvc.xml";
                break;
            case ENTITY_PK:
                filePatch += mainCode + packagePath + "/entity/" + className + "PK.java";
                break;
            case HIBERNATE_ENTITY:
            case MYBATIS_ENTITY:
                filePatch += mainCode + packagePath + "/entity/" + className + ".java";
                break;
            case HIBERNATE_DAO:
            case MYBATIS_DAO:
                filePatch += mainCode + packagePath + "/repository/" + className + "Repository.java";
                break;
            case MYBATIS_MAPPER:
                filePatch += mainConfig +packagePath + "/repository/mapper/" + className + "RepositoryMapper.xml";
                break;
            case HIBERNATE_SERVICE:
            case MYBATIS_SERVICE:
                filePatch += mainCode + packagePath + "/service/" + className + "Service.java";
                break;
            case HIBERNATE_SERVICE_IMPL:
            case MYBATIS_SERVICE_IMPL:
                filePatch += mainCode + packagePath + "/service/impl/" + className + "ServiceImpl.java";
                break;
            case HIBERNATE_TEST:
            case MYBATIS_TEST:
                filePatch += testCode + packagePath + "/test/" + className + "Test.java";
                break;
            case MYBATIS_CONFIG:
                filePatch += mainConfig + "spring_mybatis.xml";
                break;
            case MYBATIS_CONFIG_TEST:
                filePatch += testConfig + "spring_mybatis.xml";
                break;
            case HIBERNATE_ABSTRACT:
                filePatch += mainCode + packagePath + "/repository/AbstractRepository.java";
                break;
            case HIBERNATE_ABSTRACT_IMPL:
                filePatch += mainCode + packagePath + "/repository/impl/AbstractRepositoryImpl.java";
                break;
            case HIBERNATE_REPOSITORY:
                filePatch += mainCode + packagePath + "/repository/" + className + "Repository.java";
                break;
            case HIBERNATE_REPOSITORY_IMPL:
                filePatch += mainCode + packagePath + "/repository/impl/" + className + "RepositoryImpl.java";
                break;
            case HIBERNATE_CONFIG:
                filePatch += mainConfig + "spring_hibernate.xml";
                break;
            case HIBERNATE_CONFIG_TEST :
                filePatch += testConfig + "spring_hibernate.xml";
                break;
            case REQUEST:
                filePatch += mainCode + packagePath + "/controller/request/" + className + "Request.java";
                break;
            case WEB:
                filePatch += "src/main/webapp/WEB-INF/web.xml";
                break;
            case TABLE_HTML:
                filePatch += viewFile + className.toLowerCase() + ".html";
                break;
            case TABLE_JS:
                filePatch += viewFile + "/js/" +className.toLowerCase() + ".js";
                break;
            default: filePatch = "";
        }
        return filePatch;
    }

    String name;
    String file;

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }

    TemplateEnum(String name, String file) {
        this.name = name;
        this.file = file;
    }
}
