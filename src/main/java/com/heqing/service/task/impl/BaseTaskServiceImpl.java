package com.heqing.service.task.impl;

import com.heqing.constants.FrameEnum;
import com.heqing.constants.TemplateEnum;
import com.heqing.entity.orm.Column;
import com.heqing.entity.orm.Table;
import com.heqing.entity.task.ClassEntity;
import com.heqing.entity.task.FieldEntity;
import com.heqing.entity.task.FrameEntity;
import com.heqing.entity.task.TaskEntity;
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

import java.io.StringWriter;
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

    protected Map<String, Object> taskMap = new HashMap<>();

    protected SqlSession sqlSession;

    StringBuilder li = new StringBuilder();

    @Override
    public void execute(T taskEntity) {
        try {
            LOGGER.info("开始检查数据！");
            if(!checkParams(taskEntity)) {
                return;
            }

            for(String tableName : taskEntity.getTableNames()) {
                LOGGER.info("开始合成参数！");
                if(!combileParams(taskEntity, tableName)) {
                    continue;
                }

                LOGGER.info("开始载入生成模板数据！");
                addMobile(taskEntity);

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
    public Boolean checkParams(T taskEntity) {
        try {
            if (taskEntity == null) {
                taskEntity.getErrorMap().put("task", "任务的参数信息不能为空");
                LOGGER.error("---> 任务的参数信息不能为空！");
                return false;
            }
            if (taskEntity.getTableNames().size() < 1) {
                taskEntity.getErrorMap().put("task", "需求表名不能为空");
                LOGGER.error("---> 需求表名不能为空！");
                return false;
            }
            if (taskEntity.getProjectName() == null || "".equals(taskEntity.getProjectName())) {
                taskEntity.getErrorMap().put("task", "项目名不能为空");
                LOGGER.error("---> 项目名不能为空！");
                return false;
            }
            if (taskEntity.getPackageName() == null || "".equals(taskEntity.getPackageName())) {
                taskEntity.getErrorMap().put("task", "代码存储不能为空");
                LOGGER.error("---> 代码存储不能为空！");
                return false;
            }
            if (taskEntity.getZipPath() == null || "".equals(taskEntity.getZipPath())) {
                taskEntity.getErrorMap().put("task", "输出路径不能为空");
                LOGGER.error("---> 输出路径不能为空！");
                return false;
            }
            if (taskEntity.getFrame() == null) {
                FrameEntity frameEntity = new FrameEntity();
                frameEntity.setProjectFrame(FrameEnum.Project.MAVEN);
                frameEntity.setServiceFrame(FrameEnum.Service.SPRING_BOOT);
                frameEntity.setRepositoryFrame(FrameEnum.Dao.MYBATIS);
                taskEntity.setFrame(frameEntity);
            } else {
                FrameEntity frameEntity = taskEntity.getFrame();
                if(frameEntity.getProjectFrame() == null) {
                    frameEntity.setProjectFrame(FrameEnum.Project.MAVEN);
                }
                if(frameEntity.getServiceFrame() == null) {
                    frameEntity.setServiceFrame(FrameEnum.Service.SPRING_BOOT);
                }
                if(frameEntity.getRepositoryFrame() == null) {
                    frameEntity.setRepositoryFrame(FrameEnum.Dao.MYBATIS);
                }
            }
            if (taskEntity.getDatebase() == null) {
                taskEntity.getErrorMap().put("task", "数据库信息不能为空");
                LOGGER.error("---> 数据库信息不能为空！");
                return false;
            } else {
                sqlSession = datebaseServiceExt.getSqlSession(taskEntity.getDatebase());
                if (sqlSession == null) {
                    taskEntity.getErrorMap().put("task", "数据库连接失败");
                    LOGGER.error("---> 数据库连接失败！");
                    return false;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Boolean addMobile(T taskEntity) {
        FrameEntity.addTemplates(taskEntity);
        return true;
    }

    @Override
    public Boolean combileParams(T taskEntity, String tableName) {
        ClassEntity classEntity = new ClassEntity();

        LOGGER.info("合成中 --> 获取表的信息！"+tableName);
        Table table = tableService.getTableByName(sqlSession, tableName);
        if(table == null) {
            taskEntity.getErrorMap().put(tableName, "找不到数据库中对应表的信息");
            LOGGER.error("---> 找不到数据库中对应表的信息");
            return false;
        }

        LOGGER.info("合成中 --> 获取表中列的信息！");
        List<Column> columnList = columnService.listColumnByTable(sqlSession, tableName);

        LOGGER.info("合成中 --> 将列的信息转为类属性");
        LinkedList<FieldEntity> fields = new LinkedList<>();
        LinkedList<Map<String, Object>> keyFields = new LinkedList<>();
        LinkedList<Map<String, Object>> noKeyFields = new LinkedList<>();
        LinkedList<Map<String, Object>> notNullfields = new LinkedList<>();
        for(Column column : columnList) {
            if(!checkWord(taskEntity, tableName, column.getColumnName())) {
                return false;
            }
            FieldEntity field = new FieldEntity();
            field.setColumnName(column.getColumnName());
            field.setEntityName(specialWord(column.getColumnName()));
            field.setFiledName(StringUtils.capitalize(field.getEntityName()));
            field.setFiledDefault(column.getColumnDefault() == null ? "null" : column.getColumnDefault());
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
        taskEntity.getFrame().setKeyNum(keyFields.size());

        LOGGER.info("合成中 --> 将表的信息转为类！");
        classEntity.setFields(fields);
        classEntity.setClassPackage(taskEntity.getPackageName());
        classEntity.setEntityName(specialWord(tableName));
        classEntity.setClassName(StringUtils.capitalize(classEntity.getEntityName()));
        classEntity.setComment(table.getComment()==null ? "" : table.getComment());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        classEntity.setCreateTime(sdf.format(new Date()));
        classEntity.setAuthorName(taskEntity.getAuthorName()==null ? "" : taskEntity.getAuthorName());
        classEntity.setAuthorEmail(taskEntity.getAuthorEmail()==null ? "" : taskEntity.getAuthorEmail());

        LOGGER.info("生成中 --> 将Object转化map格式数据！");
        taskMap.putAll(ObjectUtil.objToMap(taskEntity));
        taskMap.putAll(ObjectUtil.objToMap(classEntity));
        taskMap.put("tableName", tableName);
        taskMap.put("repositoryMapper", taskEntity.getPackageName().replace(".","/"));
        taskMap.put("keyFields", keyFields);
        taskMap.put("noKeyFields", noKeyFields);
        taskMap.put("notNullfields", notNullfields);
        taskMap.put("isAutoIncr", table.getAutoIncrement());

        // 去掉注释显示嵌入关键字
//        System.out.println("------------------------------------------");
//        Iterator entries = taskMap.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry entry = (Map.Entry) entries.next();
//            String key = (String) entry.getKey();
//            Object value = (Object) entry.getValue();
//            System.out.println("Key = " + key + ", Value = " + value);
//        }
//        System.out.println("------------------------------------------");

        li.append("<li><a class='J_menuItem' href='"+classEntity.getClassName()+".html'><i class='fa fa-paperclip'></i>"+table.getComment()+"</a></li>").append("\r\n");
        return true;
    }

    @Override
    public Boolean work(T taskEntity, String tableName) {
        LOGGER.info("生成中 --> 设置velocity资源加载器！");
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        VelocityContext context = new VelocityContext(taskMap);

        LOGGER.info("生成中 --> 渲染模板！");
        for(TemplateEnum template : taskEntity.getTemplates()){
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate("templates/"+template.getFile(), "UTF-8");
            tpl.merge(context, sw);
            String fileName = TemplateEnum.getFilePath(taskEntity.getProjectName(), template, (String)taskMap.get("classPackage"), (String)taskMap.get("className"));

            // 去掉注释控制台显示文件内容
//            System.out.println("------------------------------------------");
//            System.out.println(sw.toString());
//            System.out.println("------------------------------------------");

            FileUtil.outputFile(taskEntity.getZipPath(), fileName, sw.toString());
        }
        return true;
    }

    @Override
    public Boolean deploy(T taskEntity) {
        FrameEntity frameEntity = taskEntity.getFrame();
        if(frameEntity.getH5Frame() != null) {
            String fromPath = System.getProperty("user.dir")+"/code/WEB-INF";
            String toPath = System.getProperty("user.dir")+"/code/maven/"+taskEntity.getProjectName()+"/src/main/";
            if(frameEntity.getServiceFrame() == FrameEnum.Service.SPRING_BOOT) {
                toPath += "resources/WEB-INF";
            } else if(frameEntity.getServiceFrame() == FrameEnum.Service.SPRING) {
                toPath += "webapp/WEB-INF";
            }
            FileUtil.copyDirectory(fromPath, toPath);
            FileUtil.replaceFileStr(toPath+"/index.html", "this is temp li content", li.toString());
        }

//        FileUtil.zipFile(taskEntity.getProjectName());
        return true;
    }

    @Override
    public Boolean destroy(T taskEntity) {
        if(sqlSession != null) {
            sqlSession.clearCache();
            sqlSession.close();
        }
        return true;
    }

    /**
     * 检查列中命名是否规范
     *
     * @param tableName 表名
     * @param columnName 列名
     * @return 是否规范
     */
    public Boolean checkWord(T taskEntity, String tableName, String columnName){
        String[] delimiters = new String[]{"(", ")", "/", "\\", "=", "<", ">", "^", "'", " ", "-", "/", "*", "+", "[", "]",  "#", "|", "&", "%", "~"};
        for(String delimiter : delimiters) {
            if(columnName.contains(delimiter)) {
                taskEntity.getErrorMap().put("表："+tableName+"->列："+columnName, " 该列名中存在特殊字符 --> " + delimiter+", 如需分割请使用下划线");
                LOGGER.error(columnName + " 该列名中存在特殊字符 --> " + delimiter+", 如需分割请使用下划线");
                return false;
            }
        }
        if(TaskEntity.getSqlKey().contains(columnName.toUpperCase())) {
            taskEntity.getErrorMap().put("表："+tableName+"->列："+columnName, " 该字段名为SQL保留字");
            return false;
        }
        return true;
    }

    /**
     * 数据库命名 转 JAVA命名
     *
     * @param word 数据库命名
     * @return String java类型
     */
    public String specialWord(String word){
        // 清空命名中的空字符串
        word = word.replace(" ", "");
        // 转为java命名规范
        word = toJavaName(word, "_");
        if(TaskEntity.getJavaKey().contains(word.toLowerCase())) {
            LOGGER.error(word + " 该字段名与java保留关键字相同，增加T以区别");
            word = word+"T";
        }
        return word;
    }

    /**
     * 检查数据表命名中是否存在特殊字符，并转为java命名格式
     *
     * @param word 数据库命名
     * @param key 特殊字符
     * @return String java类型
     */
    public String toJavaName(String word, String key){
        // 单词中是否存在特殊字符
        if(word.contains(key)) {
            // 特殊字符在单词中的位置。
            int index = word.indexOf(key) + 1;
            //如果在中间将后一个单词大写并前移一位，如果在最后则变空字符串
            int wordLength = 1;
            if((index + wordLength) <= word.length()) {
                String start = word.substring(index, index + wordLength);
                word = word.replace(key + start, start.toUpperCase());
            } else {
                word = word.replace(key, "");
            }
            word = toJavaName(word, key);
        }
        return word;
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

}
