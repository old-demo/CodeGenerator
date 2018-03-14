package com.heqing.constants;

import org.apache.commons.lang.StringUtils;

/**
 * 生成代码中所使用的代码模板
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public enum TemplatesEnum {

    /*
     * mybatis实体类
     */
    MYBATIS_ENTITY("mybatisEntity", "mybatis/MybatisEntity.java.vm"),
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
     * hibernate实体类
     */
    HIBERNATE_ENTITY("hibernateEntity", "hibernate/HibernateEntity.java.vm"),
    /*
     * hibernate实体类
     */
    HIBERNATE_ENTITY_PK("hibernateEntityPK", "hibernate/HibernateEntityPK.java.vm"),
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
     * hibernatec测试类
     */
    HIBERNATE_TEST("hibernateTest", "hibernate/HibernateTest.java.vm"),
    /*
     * 分页工具类
     */
    UTIL_PAGEINFO("pageInfoUtil", "util/PageInfoUtil.java.vm"),
    /*
     * controller   显示控制层
     */
    CONTROLLER("controller", "Controller.java.vm"),
    /*
     * pom  maven项目pom文件
     */
    POM("pom", "pom.xml.vm"),
    /*
     * application springboot主类
     */
    APPLICATION("application", "Application.java.vm"),
    /*
     * application_properties springboot配置文件
     */
    APPLICATION_PROPERTIES("application_properties", "Application.properties.vm"),
    /*
     * spring_core  spring框架配置
     */
    SPRING_CONFIG("springConfig", "SpringConfig.xml.vm");

    public static String getFilePath(String projectName, TemplatesEnum template, String packageName, String className) {
        String filePatch = projectName+"/";
        String packagePath = "";
        if(StringUtils.isNotBlank(packageName)){
            packagePath = packageName.replace(".", "/");
        }

        switch (template) {
            case HIBERNATE_ENTITY_PK:
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
            case HIBERNATE_SERVICE:
            case MYBATIS_SERVICE:
                filePatch += "src/main/java/" + packagePath + "/service/" + className + "Service.java";
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
            case CONTROLLER:
                filePatch += "src/main/java/" + packagePath + "/controller/" + className + "Controller.java";
                break;
            case HIBERNATE_TEST:
            case MYBATIS_TEST:
                filePatch += "src/test/java/" + packagePath + "/test/" + className + "Test.java";
                break;
            case APPLICATION_PROPERTIES:
                filePatch += "src/test/resources/application.properties";
                break;
            case SPRING_CONFIG:
                filePatch += "src/test/resources/spring_core.xml";
                break;
            case MYBATIS_CONFIG:
                filePatch += "src/test/resources/spring_mybatis.xml";
                break;
            case UTIL_PAGEINFO:
                filePatch += "src/main/java/" + packagePath + "/util/PageInfoUtil.java";
                break;
            default: filePatch = "";
        }
        return filePatch;
    }

    private final String name;
    private final String file;

    private TemplatesEnum(String name, String file) {
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
