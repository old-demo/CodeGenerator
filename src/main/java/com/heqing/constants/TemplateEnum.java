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

    /*
     * mybatis实体类
     */
    MYBATIS_ENTITY("MybatisEntity", "mybatis/MybatisEntity.java.vm"),
    /*
     * 持久层mybatis接口
     */
    MYBATIS_DAO("mybatisDao", "mybatis/MybatisDao.java.vm"),
    /*
     * mybatis映射文件
     */
    MYBATIS_MAPPER("mybatisMapper", "mybatis/MybatisMapper.xml.vm"),
    /*
     * mybatis业务逻辑层接口
     */
    MYBATIS_SERVICE("mybatisService", "mybatis/MybatisService.java.vm"),
    /*
     * mybatis业务逻辑层实现类
     */
    MYBATIS_SERVICEIMPL("mybatisServiceImpl", "mybatis/MybatisServiceImpl.java.vm"),
    /*
     * mybatis测试类
     */
    MYBATIS_TEST("mybatisTest", "mybatis/MybatisTest.java.vm"),
    /*
     * mybatis配置
     */
    MYBATIS_CONFIG("mybatisConfig", "mybatis/MybatisConfig.xml.vm"),
    /*
     * mybatis配置
     */
    MYBATIS_CONFIG_TEST("mybatisConfigTest", "mybatis/MybatisConfig.xml.vm"),
    /*
     * hibernate实体类
     */
    HIBERNATE_ENTITY("hibernateEntity", "hibernate/HibernateEntity.java.vm"),
    /*
     * hibernate实体类
     */
    ENTITY_PK("entityPK", "EntityPK.java.vm"),
    /*
     * hibernate持久层接口
     */
    HIBERNATE_DAO("hibernateDao", "hibernate/HibernateDao.java.vm"),
    /*
     * hibernate业务逻辑层接口
     */
    HIBERNATE_SERVICE("hibernateService", "hibernate/HibernateService.java.vm"),
    /*
     * hibernate业务逻辑层接口
     */
    HIBERNATE_SERVICEIMPL("hibernateServiceImpl", "hibernate/HibernateServiceImpl.java.vm"),
    /*
     * hibernate 数据访问层接口
     */
    HBERNATE_REPOSITORY("hibernateRepository", "hibernate/HibernateRepository.java.vm"),
    /*
     * hibernate 数据访问层实现类
     */
    HBERNATE_REPOSITORY_IMPL("hibernateRepositoryImpl", "hibernate/HibernateRepositoryImpl.java.vm"),
    /*
     * hibernate 数据访问层基础接口
     */
    HBERNATE_ABSTRACT("hibernateAbstract", "hibernate/AbstractRepository.java.vm"),
    /*
     * hibernate 数据访问层基础实现类
     */
    HBERNATE_ABSTRACT_IMPL("hibernateAbstractImpl", "hibernate/AbstractRepositoryImpl.java.vm"),
    /*
     * hibernate数据访问层基础接口
     */
    HBERNATE_CONFIG("hibernateConfig", "hibernate/HibernateConfig.xml.vm"),
    /*
     * hibernate测试类
     */
    HIBERNATE_TEST("hibernateTest", "hibernate/HibernateTest.java.vm"),
    /*
     * 分页工具类
     */
    UTIL_PAGEINFO("pageInfoUtil", "util/PageInfoUtil.java.vm"),
    /*
     * 返回数据封装类
     */
    UTIL_RESPONSE("responseUtil", "util/ResponseUtil.java.vm"),
    /*
     * springController   spring显示控制层
     */
    REQUEST("Request", "Request.java.vm"),
    /*
     * springController   spring显示控制层
     */
    SPRING_CONTROLLER("springController", "spring/SpringController.java.vm"),
    /*
     * strutsControllre   struts2显示控制层
     */
    STRUTS2_CONTROLLER("strutsController", "StrutsController.java.vm"),
    /*
     * pom  maven项目pom文件
     */
    POM("pom", "pom.xml.vm"),
    /*
     * web  web项目
     */
    WEB("web", "Web.xml.vm"),
    /*
     * application springboot主类
     */
    APPLICATION("application", "spring/Application.java.vm"),
    /*
     * application_properties springboot配置文件
     */
    APPLICATION_PROPERTIES("application_properties", "spring/Application.properties.vm"),
    /*
     * application_properties_test springboot配置文件
     */
    APPLICATION_PROPERTIES_TEST("application_properties_test", "spring/Application.properties.vm"),
    /*
     * springmvc spring框架配置
     */
    SPRING_MVC("springMVC", "spring/SpringMVC.xml.vm"),
    /*
     * spring_core  spring框架配置
     */
    SPRING_CONFIG("springConfig", "spring/SpringConfig.xml.vm"),
    /*
     * spring_core  spring框架配置
     */
    SPRING_CONFIG_TEST("springConfigTest", "spring/SpringConfig.xml.vm");

    public static String getFilePath(String projectName, TemplateEnum template, String packageName, String className) {
        String filePatch = projectName+"/";
        String packagePath = "";
        if(StringUtils.isNotBlank(packageName)){
            packagePath = packageName.replace(".", "/");
        }

        switch (template) {
            case ENTITY_PK:
                filePatch += "src/main/java/" + packagePath + "/entity/" + className + "PK.java";
                break;
            case HIBERNATE_ENTITY:
            case MYBATIS_ENTITY:
                filePatch += "src/main/java/" + packagePath + "/entity/" + className + ".java";
                break;
            case HIBERNATE_DAO:
            case MYBATIS_DAO:
                filePatch += "src/main/java/" + packagePath + "/repository/" + className + "Repository.java";
                break;
            case MYBATIS_MAPPER:
                filePatch += "src/main/resources/" +packagePath + "/repository/mapper/" + className + "RepositoryMapper.xml";
                break;
            case HBERNATE_ABSTRACT:
                filePatch += "src/main/java/" + packagePath + "/repository/AbstractRepository.java";
                break;
            case HBERNATE_ABSTRACT_IMPL:
                filePatch += "src/main/java/" + packagePath + "/repository/impl/AbstractRepositoryImpl.java";
                break;
            case HIBERNATE_SERVICE:
            case MYBATIS_SERVICE:
                filePatch += "src/main/java/" + packagePath + "/service/" + className + "Service.java";
                break;
            case HBERNATE_REPOSITORY:
                filePatch += "src/main/java/" + packagePath + "/repository/" + className + "Repository.java";
                break;
            case HBERNATE_REPOSITORY_IMPL:
                filePatch += "src/main/java/" + packagePath + "/repository/impl/" + className + "RepositoryImpl.java";
                break;
            case HIBERNATE_SERVICEIMPL:
            case MYBATIS_SERVICEIMPL:
                filePatch += "src/main/java/" + packagePath + "/service/impl/" + className + "ServiceImpl.java";
                break;
            case POM:
                filePatch += "pom.xml";
                break;
            case APPLICATION:
                filePatch += "src/main/java/" + packagePath+ "/" +projectName+"Application.java";
                break;
            case REQUEST:
                filePatch += "src/main/java/" + packagePath + "/controller/request/" + className + "Request.java";
                break;
            case STRUTS2_CONTROLLER:
            case SPRING_CONTROLLER:
                filePatch += "src/main/java/" + packagePath + "/controller/" + className + "Controller.java";
                break;
            case HIBERNATE_TEST:
            case MYBATIS_TEST:
                filePatch += "src/test/java/" + packagePath + "/test/" + className + "Test.java";
                break;
            case APPLICATION_PROPERTIES:
                filePatch += "src/main/resources/application.properties";
                break;
            case APPLICATION_PROPERTIES_TEST:
                filePatch += "src/test/resources/application.properties";
                break;
            case SPRING_MVC:
                filePatch += "src/main/resources/spring_mvc.xml";
                break;
            case SPRING_CONFIG:
                filePatch += "src/main/resources/spring_core.xml";
                break;
            case SPRING_CONFIG_TEST:
                filePatch += "src/test/resources/spring_core.xml";
                break;
            case MYBATIS_CONFIG:
                filePatch += "src/main/resources/spring_mybatis.xml";
                break;
            case HBERNATE_CONFIG:
                filePatch += "src/test/resources/spring_hibernate.xml";
                break;
            case MYBATIS_CONFIG_TEST:
                filePatch += "src/test/resources/spring_mybatis.xml";
                break;
            case UTIL_RESPONSE:
                filePatch += "src/main/java/" + packagePath + "/util/ResponseUtil.java";
                break;
            case UTIL_PAGEINFO:
                filePatch += "src/main/java/" + packagePath + "/util/PageInfoUtil.java";
                break;
            case WEB:
                filePatch += "src/main/webapp/WEB-INF/web.xml";
                break;
            default: filePatch = "";
        }
        return filePatch;
    }

    private final String name;
    private final String file;

    private TemplateEnum(String name, String file) {
        this.name = name;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }
}
