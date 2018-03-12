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
     * entity   实体类
     */
    MYBATIS_ENTITY("mybatisEntity", "MybatisEntity.java.vm"),
    /*
     * mybatis   持久层mybatis接口
     */
    MYBATIS_DAO("mybatisDao", "MybatisDao.java.vm"),
    /*
     * mapper   mybatis映射文件
     */
    MYBATIS_MAPPER("mybatisMapper", "MybatisMapper.xml.vm"),
    /*
     * service  业务逻辑层接口
     */
    MYBATIS_SERVICE("mybatisService", "MybatisService.java.vm"),
    /*
     * serviceImpl  业务逻辑层实现类
     */
    MYBATIS_SERVICEIMPL("mybatisServiceImpl", "MybatisServiceImpl.java.vm"),
    /*
         * test 测试类
         */
    MYBATIS_TEST("mybatisTest", "MybatisTest.java.vm"),
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
    SPRING_CONFIG("springConfig", "SpringConfig.xml.vm"),
    /*
     * Spring_mybatis mybatis配置
     */
    MYBATIS_CONFIG("mybatisConfig", "MybatisConfig.xml.vm");

    public static String getFilePath(String projectName, TemplatesEnum template, String packageName, String className) {
        String filePatch = projectName+"/";
        String packagePath = "";
        if(StringUtils.isNotBlank(packageName)){
            packagePath = packageName.replace(".", "/");
        }

        switch (template) {
            case MYBATIS_ENTITY:
                filePatch += "src/main/java/" + packagePath + "/entity/" + className + ".java";
                break;
            case MYBATIS_DAO:
                filePatch += "src/main/java/" + packagePath + "/repository/" + className + "Repository.java";
                break;
            case MYBATIS_MAPPER:
                filePatch += "src/main/resources/" +packagePath + "/repository/mapper/" + className + "RepositoryMapper.xml";
                break;
            case MYBATIS_SERVICE:
                filePatch += "src/main/java/" + packagePath + "/service/" + className + "Service.java";
                break;
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
