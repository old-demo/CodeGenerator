package com.heqing.constants;

/**
 * 生成代码中所使用的代码模板
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/12
 */
public interface TemplateEnum {

    /**
     * 项目
     */
    enum Project implements TemplateEnum {

        POM("maven pom文件", "pom.xml.vm"),
        WEB("web项目配置文件", "web.xml.vm"),
        LOG("日志文件", "log4j.properties.vm");

        String desc;
        String vmPath;

        public String getDesc() {
            return desc;
        }

        public String getVmPath() {
            return vmPath;
        }

        Project(String desc, String vmPath) {
            this.desc = desc;
            this.vmPath = vmPath;
        }
    }

    /**
     * 业务层框架
     */
    enum Service implements TemplateEnum {

        UTIL_VALIDATE("入参校验工具类", "util/ValidateUtil.java.vm"),
        UTIL_PAGE("分页工具类", "util/PageInfoUtil.java.vm"),

        SERVICE("业务层接口", "spring/Service.java.vm"),
        SERVICE_IMPL("业务层实现类", "spring/ServiceImpl.java.vm"),
        SPRING_CONFIG("spring 配置文件", "spring/spring_config.xml.vm"),
        SPRINGBOOT_PROPERTIES("springBoot 配置文件", "spring/application.properties.vm"),
        SPRINGBOOT_APPLICATION("springBoot 启动类", "spring/application.java.vm"),
        TEST("测试类", "spring/Test.java.vm");

        String desc;
        String vmPath;

        public String getDesc() {
            return desc;
        }

        public String getVmPath() {
            return vmPath;
        }

        Service(String desc, String vmPath) {
            this.desc = desc;
            this.vmPath = vmPath;
        }
    }

    /**
     * 数据持久层
     */
    enum Dao implements TemplateEnum {
        ENTITY_PK("联合主键", "dao/EntityPK.java.vm"),
        ENTITY("实体类", "dao/Entity.java.vm"),

        MYBATIS_DAO("实体类", "mybatis/MybatisDao.java.vm"),
        MYBATIS_MAPPER("数据持久层映射文件", "mybatis/MybatisMapper.xml.vm"),
        MYBATIS_CONFIG("配置文件", "mybatis/mybatis_config.xml.vm"),

        HIBERNATE_SPRINGBOOT_DAO("springboot集成数据持久层接口", "hibernate/SpringBootDao.java.vm"),
        HIBERNATE_DAO_BASE("数据持久层基础接口", "hibernate/AbstractDao.java.vm"),
        HIBERNATE_DAO_BASE_IMPL("数据持久层基础接口实现类", "hibernate/AbstractDaoImpl.java.vm"),
        HIBERNATE_DAO("数据持久层接口", "hibernate/HibernateDao.java.vm"),
        HIBERNATE_DAO_IMPL("数据持久层实现类", "hibernate/HibernateDaoImpl.java.vm"),
        HIBERNATE_CONFIG("配置文件", "hibernate/hibernate_config.xml.vm");

        String desc;
        String vmPath;

        public String getDesc() {
            return desc;
        }

        public String getVmPath() {
            return vmPath;
        }

        Dao(String desc, String vmPath) {
            this.desc = desc;
            this.vmPath = vmPath;
        }
    }

    /**
     * 请求控制层
     */
    enum Controller implements TemplateEnum {

        SPRING_CONTROLLER("控制层Java类", "spring/Controller.java.vm"),
        SPRING_MVC("springMVC 配置文件", "spring/spring_mvc.xml.vm"),

        STRUTS2_CONTROLLER("strtus2控制层Java类", "struts/Controller.java.vm"),
        STRUTS2("struts_2 配置文件", "struts/struts2.xml.vm"),

        REQUEST("请求参数封装", "util/Request.java.vm"),
        RESPONSE("返回数据封装类", "util/Response.java.vm");

        String desc;
        String vmPath;

        public String getDesc() {
            return desc;
        }

        public String getVmPath() {
            return vmPath;
        }

        Controller(String desc, String vmPath) {
            this.desc = desc;
            this.vmPath = vmPath;
        }
    }

    /**
     * 显示层
     */
    enum Web implements FrameEnum {

        BOOTSTRAP_HTML("Bootstrap 样式文件", "view/Bootstrap.html.vm"),
        BOOTSTRAP_JS("Bootstrap 脚本文件", "view/Bootstrap.js.vm");

        String desc;
        String vmPath;

        public String getDesc() {
            return desc;
        }

        public String getVmPath() {
            return vmPath;
        }

        Web(String desc, String vmPath) {
            this.desc = desc;
            this.vmPath = vmPath;
        }
    }


//    public static String getFilePath(String projectName, TemplateEnum template, String packageName, String className) {
//        String filePatch = projectName+"/";
//        String packagePath = "";
//        if(StringUtils.isNotBlank(packageName)){
//            packagePath = packageName.replace(".", "/");
//        }
//
//        String mainCode = "src/main/java/", testCode = "src/test/java/";
//        String mainConfig = "src/main/resources/", testConfig = "src/test/resources/";
//        String viewFile = "src/main/resources/WEB-INF/";
//
//        switch (template) {
//            case POM:
//                filePatch += "pom.xml";
//                break;
//            case LOG:
//                filePatch += mainConfig + "/log4j.properties";
//                break;
//            case UTIL_VALIDATE:
//                filePatch += mainCode + packagePath + "/util/ValidateUtil.java";
//                break;
//            case UTIL_RESPONSE:
//                filePatch += mainCode + packagePath + "/util/ResponseUtil.java";
//                break;
//            case UTIL_PAGE_INFO:
//                filePatch += mainCode + packagePath + "/util/PageInfoUtil.java";
//                break;
//            case APPLICATION:
//                filePatch += mainCode + packagePath+ "/" +projectName+"Application.java";
//                break;
//            case APPLICATION_TEST:
//                filePatch += testCode + packagePath+ "/" +projectName+"Application.java";
//                break;
//            case APPLICATION_PROPERTIES:
//                filePatch += mainConfig + "application.properties";
//                break;
//            case APPLICATION_PROPERTIES_TEST:
//                filePatch += testConfig + "application.properties";
//                break;
//            case SPRING_CONFIG:
//                filePatch += mainConfig + "spring_core.xml";
//                break;
//            case SPRING_CONFIG_TEST:
//                filePatch += testConfig + "spring_core.xml";
//                break;
//            case SPRING_CONTROLLER:
//            case STRUTS2_CONTROLLER:
//                filePatch += mainCode + packagePath + "/controller/" + className + "Controller.java";
//                break;
//            case SPRING_MVC:
//                filePatch += mainConfig + "spring_mvc.xml";
//                break;
//            case ENTITY_PK:
//                filePatch += mainCode + packagePath + "/entity/" + className + "PK.java";
//                break;
//            case HIBERNATE_ENTITY:
//            case MYBATIS_ENTITY:
//                filePatch += mainCode + packagePath + "/entity/" + className + ".java";
//                break;
//            case HIBERNATE_DAO:
//            case MYBATIS_DAO:
//                filePatch += mainCode + packagePath + "/repository/" + className + "Repository.java";
//                break;
//            case MYBATIS_MAPPER:
//                filePatch += mainConfig +packagePath + "/repository/mapper/" + className + "RepositoryMapper.xml";
//                break;
//            case HIBERNATE_SERVICE:
//            case MYBATIS_SERVICE:
//                filePatch += mainCode + packagePath + "/service/" + className + "Service.java";
//                break;
//            case HIBERNATE_SERVICE_IMPL:
//            case MYBATIS_SERVICE_IMPL:
//                filePatch += mainCode + packagePath + "/service/impl/" + className + "ServiceImpl.java";
//                break;
//            case HIBERNATE_TEST:
//            case MYBATIS_TEST:
//                filePatch += testCode + packagePath + "/test/" + className + "Test.java";
//                break;
//            case MYBATIS_CONFIG:
//                filePatch += mainConfig + "spring_mybatis.xml";
//                break;
//            case MYBATIS_CONFIG_TEST:
//                filePatch += testConfig + "spring_mybatis.xml";
//                break;
//            case HIBERNATE_ABSTRACT:
//                filePatch += mainCode + packagePath + "/repository/AbstractRepository.java";
//                break;
//            case HIBERNATE_ABSTRACT_IMPL:
//                filePatch += mainCode + packagePath + "/repository/impl/AbstractRepositoryImpl.java";
//                break;
//            case HIBERNATE_REPOSITORY:
//                filePatch += mainCode + packagePath + "/repository/" + className + "Repository.java";
//                break;
//            case HIBERNATE_REPOSITORY_IMPL:
//                filePatch += mainCode + packagePath + "/repository/impl/" + className + "RepositoryImpl.java";
//                break;
//            case HIBERNATE_CONFIG:
//                filePatch += mainConfig + "spring_hibernate.xml";
//                break;
//            case HIBERNATE_CONFIG_TEST :
//                filePatch += testConfig + "spring_hibernate.xml";
//                break;
//            case REQUEST:
//                filePatch += mainCode + packagePath + "/controller/request/" + className + "Request.java";
//                break;
//            case WEB:
//                filePatch += "src/main/webapp/WEB-INF/web.xml";
//                break;
//            case SPRING_HTML:
//                filePatch += "src/main/webapp/WEB-INF/" + className + ".html";
//                break;
//            case SPRING_JS:
//                filePatch += "src/main/webapp/WEB-INF/js/" +className + ".js";
//                break;
//            case SPRINGBOOT_HTML:
//                filePatch += viewFile + className + ".html";
//                break;
//            case SPRINGBOOT_JS:
//                filePatch += viewFile + "/js/" +className + ".js";
//                break;
//            default: filePatch = "";
//        }
//        return filePatch;
//    }

}
