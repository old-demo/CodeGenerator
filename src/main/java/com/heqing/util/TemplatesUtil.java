package com.heqing.util;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 模板生成工具类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/16
 */
public class TemplatesUtil {

    public final static String ENTITY = "Entity.java.vm";
    public final static String DAO = "DAO.java.vm";
    public final static String DAOMAPPER = "Mapper.xml.vm";
    public final static String SERVICE = "Service.java.vm";
    public final static String SERVICEIMPL = "ServiceImpl.java.vm";
    public final static String TEST = "Test.java.vm";
    public final static String HANDLER = "Handler.java.vm";
    public final static String POM = "Pom.xml.vm";
    public final static String APPLICATION = "Application.java.vm";
    public final static String APPLICATION_PROPERTIES = "Application.properties.vm";

    public static String getFilePath(String projectName, String template, String packageName, String className) {
        String filePatch = projectName+"/";
        String packagePath = "";
        if(StringUtils.isNotBlank(packageName)){
            packagePath = packageName.replace(".", "/");
        }

        if(template.contains(POM)){
            filePatch +=  "pom.xml";
        }
        if(template.contains(APPLICATION)){
            filePatch +=  "src/main/java/" + packagePath+ "/" +projectName+"Application.java";
        }
        if(template.contains(ENTITY)){
            filePatch += "src/main/java/" + packagePath + "/entity/" + className + ".java";
        }
        if(template.contains(DAO)){
            filePatch +=  "src/main/java/" + packagePath + "/dao/" + className + "Dao.java";
        }
        if(template.contains(SERVICE)){
            filePatch +=  "src/main/java/" + packagePath + "/service/" + className + "Service.java";
        }
        if(template.contains(SERVICEIMPL)){
            filePatch +=  "src/main/java/" + packagePath + "/service/impl/" + className + "ServiceImpl.java";
        }
        if(template.contains(HANDLER)){
            filePatch +=  "src/main/java/" + packagePath + "/hanler/" + className + "Handler.java";
        }
        if(template.contains(DAOMAPPER)){
            filePatch +=  "src/main/resources/" +packagePath + "/dao/mapper/" + className + "DaoMapper.xml";
        }
        if(template.contains(TEST)){
            filePatch +=  "src/test/java/" + packagePath + "/test/" + className + "Test.java";
        }
        if(template.contains(APPLICATION_PROPERTIES)){
            filePatch +=  "src/test/resources/application.properties";
        }
        return filePatch;
    }

    /**
     * 输出文件
     *
     * @param filePath 文件地址
     * @param fileName 文件名
     * @param content 文件文本内容
     */
    public static void outputFile(String filePath, String fileName, String content) {
        try {
            File file = new File(filePath+fileName);
            if(file.exists()) {
                return;
            }
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 复制文件至另一个文件夹下
     *
     * @param projectName 项目名称
     */
    public static void copyUtilFile(String projectName) {
        String newPath = System.getProperty("user.dir")+"/code/maven/"+projectName+"/src/main/java/com/heqing/util";
        List<String> utils = new ArrayList<>();
        utils.add("PageInfoUtil");

        for(String util : utils) {
            String oldpath = System.getProperty("user.dir")+"/src/main/java/com/heqing/util/"+util+".java";
            copyFile(oldpath, newPath);
        }
    }

    /**
     * 复制文件至另一个文件夹下
     *
     * @param oldpath 文件旧地址
     * @param newPath 文件新地址
     */
    public static void copyFile(String oldpath, String newPath) {
        File src = new File(oldpath);
        File dst = new File(newPath);
        if (!dst.exists()) {
            dst.mkdirs();
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src));
            FileOutputStream f = new FileOutputStream(dst + oldpath.substring(oldpath.lastIndexOf("/"), oldpath.length()));
            out = new BufferedOutputStream(f);
            byte[] buffer = new byte[16 * 1024];
            int len = 0;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将生成的代码压缩
     *
     * @param projectName 项目名称
     */
    public static void zipFile(String projectName) {
        try {
            String filePath = System.getProperty("user.dir")+"/code/maven/"+projectName;
            FileOutputStream fos1 = new FileOutputStream(new File(filePath+".zip"));
            FileUtil.toZip(filePath, fos1, true);
            FileUtil.delete(filePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
