package com.heqing.service.task.impl;

import com.heqing.constants.FrameEnum;
import com.heqing.constants.TemplatesEnum;
import com.heqing.entity.task.FrameEntity;
import com.heqing.entity.task.TaskEntity;
import com.heqing.entity.task.ClassEntity;
import com.heqing.entity.orm.Column;
import com.heqing.entity.task.FieldEntity;
import com.heqing.entity.orm.Table;
import com.heqing.service.ColumnService;
import com.heqing.service.DatebaseServiceExt;
import com.heqing.service.TableService;
import com.heqing.service.task.BaseTaskService;
import com.heqing.util.FileUtil;
import com.heqing.util.ObjectUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 代码生成基础任务实现类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/06
 */
@Service
public abstract class BaseTaskServiceImpl<T extends TaskEntity> implements BaseTaskService<T> {

    private static final Logger LOGGER = Logger.getLogger(BaseTaskServiceImpl.class);

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("database");

    @Autowired
    DatebaseServiceExt datebaseServiceExt;

    @Autowired
    TableService tableService;

    @Autowired
    ColumnService columnService;

    protected Map<String, Object> taskMap;

    protected SqlSession sqlSession;

    @Override
    public void execute(T taskEntity) {
        try {
            LOGGER.info("开始检查数据！");
            checkParams(taskEntity);

            LOGGER.info("开始载入生成模板数据！");
            addMobile(taskEntity);

            for(String tableName : taskEntity.getTableNames()) {
                LOGGER.info("开始合成参数！");
                combileParams(taskEntity, tableName);

                LOGGER.info("开始生成代码！");
                work(taskEntity, tableName);
            }

            LOGGER.info("开始打包代码！");
            deploy(taskEntity);

            LOGGER.info("开始销毁无用参数！");
            destroy(taskEntity);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkParams(T taskEntity) {
        try {
            if (taskEntity == null) {
                throw new Exception("任务的参数信息不能为空！");
            }
            if (taskEntity.getTableNames().size() < 1) {
                throw new Exception("需求表名不能为空！");
            }
            if (taskEntity.getProjectName() == null || "".equals(taskEntity.getProjectName())) {
                throw new Exception("项目名不能为空！");
            }
            if (taskEntity.getPackageName() == null || "".equals(taskEntity.getPackageName())) {
                throw new Exception("代码存储不能为空！");
            }
            if (taskEntity.getZipPath() == null || "".equals(taskEntity.getZipPath())) {
                throw new Exception("输出路径不能为空！");
            }
            if (taskEntity.getFrame() == null) {
                FrameEntity frameEntity = new FrameEntity();
                frameEntity.setProjectFrame(FrameEnum.MAVEN);
                frameEntity.setServiceFrame(FrameEnum.SPRINGBOOT);
                frameEntity.setRepositoryFrame(FrameEnum.MYBATIS);
                taskEntity.setFrame(frameEntity);
            } else {
                FrameEntity frameEntity = taskEntity.getFrame();
                if(frameEntity.getProjectFrame() == null) {
                    frameEntity.setProjectFrame(FrameEnum.MAVEN);
                }
                if(frameEntity.getServiceFrame() == null) {
                    frameEntity.setServiceFrame(FrameEnum.SPRINGBOOT);
                }
                if(frameEntity.getRepositoryFrame() == null) {
                    frameEntity.setRepositoryFrame(FrameEnum.MYBATIS);
                }
            }
            if (taskEntity.getDatebase() == null) {
                throw new Exception("数据库信息不能为空！");
            } else {
                sqlSession = datebaseServiceExt.getSqlSession(taskEntity.getDatebase());
                if (sqlSession == null) {
                    throw new Exception("数据库连接失败！");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMobile(T taskEntity) {
        FrameEnum.addTemplates(taskEntity);
    }

    @Override
    public void combileParams(T taskEntity, String tableName) {
        ClassEntity classEntity = new ClassEntity();

        LOGGER.info("合成中 --> 获取表的信息！");
        Table Table = tableService.getTableByName(sqlSession, tableName);
        if(Table == null) {
            LOGGER.error("---> 找不到数据库中对应表的信息");
            return;
        }

        LOGGER.info("合成中 --> 获取表中列的信息！");
        List<Column> columnList = columnService.listColumnByTable(sqlSession, tableName);

        LOGGER.info("合成中 --> 将列的信息转为类属性");
        Set<FieldEntity> fields = new HashSet<>();
        Set<Map<String, Object>> keyFields = new HashSet<>();
        Set<Map<String, Object>> noKeyFields = new HashSet<>();
        Set<Map<String, Object>> notNullfields = new HashSet<>();
        for(Column column : columnList) {
            FieldEntity field = new FieldEntity();
            field.setColumnName(column.getColumnName());
            field.setFiledName(dbToJava(column.getColumnName()));
            field.setEntityName(StringUtils.uncapitalize(field.getFiledName()));
            String type = getJavaType(column.getType(), "(");
            try {
                field.setType(BUNDLE.getString(type));
            } catch(MissingResourceException e) {
                field.setType("Object");
            }
            field.setComment(column.getComment());
            fields.add(field);

            if("PRI".equals(column.getKey())) {
                Map<String, Object> keyField = ObjectUtil.objToMap(field);
                keyField.put("isAutoAdd", "");
                keyFields.add(keyField);
            } else {
                Map<String, Object> noKeyField = ObjectUtil.objToMap(field);
                noKeyFields.add(noKeyField);
            }
            if("NO".equals(column.getIsNullAble()) && "".equals(column.getExtra())) {
                Map<String, Object> notNullfield = ObjectUtil.objToMap(field);
                notNullfield.put("isNullAble", column.getIsNullAble());
                notNullfields.add(notNullfield);
            }
        }

         FrameEnum.addEntityPKTemplates(taskEntity, keyFields);

        LOGGER.info("合成中 --> 将表的信息转为类！");
        classEntity.setFields(new LinkedList<>(fields));
        classEntity.setClassPackage(taskEntity.getPackageName());
        classEntity.setClassName(dbToJava(tableName));
        classEntity.setEntityName(StringUtils.uncapitalize(classEntity.getClassName()));
        classEntity.setComment(Table.getComment()==null ? "" : Table.getComment());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        classEntity.setCreateTime(sdf.format(new Date()));
        classEntity.setAuthorName(taskEntity.getAuthorName()==null ? "" : taskEntity.getAuthorName());
        classEntity.setAuthorEmail(taskEntity.getAuthorEmail()==null ? "" : taskEntity.getAuthorEmail());

        LOGGER.info("生成中 --> 将Object转化map格式数据！");
        taskMap =  ObjectUtil.objToMap(taskEntity);
        taskMap.putAll(ObjectUtil.objToMap(classEntity));
        taskMap.put("tableName", tableName);
        taskMap.put("repositoryMapper", taskEntity.getPackageName().replace(".","/"));
        taskMap.put("keyFields", new LinkedList<>(keyFields));
        taskMap.put("noKeyFields", new LinkedList<>(noKeyFields));
        taskMap.put("notNullfields", new LinkedList<>(notNullfields));
        taskMap.put("isAutoIncr", Table.getAutoIncrement());

//        System.out.println("------------------------------------------");
//        Iterator entries = taskMap.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry entry = (Map.Entry) entries.next();
//            String key = (String) entry.getKey();
//            Object value = (Object) entry.getValue();
//            System.out.println("Key = " + key + ", Value = " + value);
//        }
//        System.out.println("------------------------------------------");
    }

    @Override
    public void work(T taskEntity, String tableName) {
        LOGGER.info("生成中 --> 设置velocity资源加载器！");
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        VelocityContext context = new VelocityContext(taskMap);

        LOGGER.info("生成中 --> 渲染模板！");
        for(TemplatesEnum template : taskEntity.getTemplates()){
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate("templates/"+template.getFile(), "UTF-8");
            tpl.merge(context, sw);
            String fileName = TemplatesEnum.getFilePath(taskEntity.getProjectName(), template, (String)taskMap.get("classPackage"), (String)taskMap.get("className"));

//            System.out.println("------------------------------------------");
//            System.out.println(sw.toString());
//            System.out.println("------------------------------------------");

            FileUtil.outputFile(taskEntity.getZipPath(), fileName, sw.toString());
        }
    }

    @Override
    public void deploy(T taskEntity) {
//        FileUtil.zipFile(taskEntity.getProjectName());
    }

    @Override
    public void destroy(T taskEntity) {
        if(sqlSession != null) {
            sqlSession.clearCache();
            sqlSession.close();
        }
    }

    /**
     * 数据库命名格式 转化成 java 命名格式
     *
     * @param tableName 表名
     * @return String java驼峰命名
     */
    public String dbToJava(String tableName){
        char[] delimiters = new char[]{'_'};
        int delimLen = (delimiters == null ? -1 : delimiters.length);
        if (tableName == null || tableName.length() == 0 || delimLen == 0) {
            return tableName;
        }
        tableName = tableName.toLowerCase();
        int strLen = tableName.length();
        StringBuffer buffer = new StringBuffer(strLen);
        boolean capitalizeNext = true;
        for (int i = 0; i < strLen; i++) {
            char ch = tableName.charAt(i);
            if (isDelimiter(ch, delimiters)) {
                buffer.append(ch);
                capitalizeNext = true;
            } else if (capitalizeNext) {
                buffer.append(Character.toTitleCase(ch));
                capitalizeNext = false;
            } else {
                buffer.append(ch);
            }
        }
        return buffer.toString().replaceAll("_","");
    }

    /**
     * 表列类型 转成 java 类型
     *
     * @param dbType 表中字段类型
     * @param special  特殊符号
     * @return String java类型
     */
    public String getJavaType(String dbType, String special) {
        if(dbType.indexOf(special) < 1) {
            return dbType;
        }
        return dbType.substring(0, dbType.indexOf(special));
    }

    /**
     * 是否有特殊字符
     */
    public boolean isDelimiter(char ch, char[] delimiters) {
        if (delimiters == null) {
            return Character.isWhitespace(ch);
        }
        for (int i = 0, isize = delimiters.length; i < isize; i++) {
            if (ch == delimiters[i]) {
                return true;
            }
        }
        return false;
    }

}
