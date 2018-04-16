package com.heqing.util;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件操作工具类
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/03/01
 */
public class FileUtil {

    private static final int  BUFFER_SIZE = 2 * 1024;

    /**
     * 压缩成ZIP 方法1
     * @param srcDir 压缩文件夹路径
     * @param out    压缩文件输出流
     * @param keepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     * 							false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws RuntimeException 压缩失败会抛出运行时异常
     */
    public static void toZip(String srcDir, OutputStream out, boolean keepDirStructure)
            throws RuntimeException{

        long start = System.currentTimeMillis();
        ZipOutputStream zos = null ;
        try {
            zos = new ZipOutputStream(out);
            File sourceFile = new File(srcDir);
            compress(sourceFile,zos,sourceFile.getName(),keepDirStructure);
            long end = System.currentTimeMillis();
            System.out.println("压缩完成，耗时：" + (end - start) +" ms");
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils",e);
        }finally{
            if(zos != null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 递归压缩方法
     * @param sourceFile 源文件
     * @param zos		 zip输出流
     * @param name		 压缩后的名称
     * @param keepDirStructure  是否保留原来的目录结构,true:保留目录结构;
     * 							false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
     * @throws Exception
     */
    private static void compress(File sourceFile, ZipOutputStream zos, String name,
                                 boolean keepDirStructure) throws Exception{
        byte[] buf = new byte[BUFFER_SIZE];
        if(sourceFile.isFile()){
            // 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
            zos.putNextEntry(new ZipEntry(name));
            // copy文件到zip输出流中
            int len;
            FileInputStream in = new FileInputStream(sourceFile);
            while ((len = in.read(buf)) != -1){
                zos.write(buf, 0, len);
            }
            // Complete the entry
            zos.closeEntry();
            in.close();
        } else {
            File[] listFiles = sourceFile.listFiles();
            if(listFiles == null || listFiles.length == 0){
                // 需要保留原来的文件结构时,需要对空文件夹进行处理
                if(keepDirStructure){
                    // 空文件夹的处理
                    zos.putNextEntry(new ZipEntry(name + "/"));
                    // 没有文件，不需要文件的copy
                    zos.closeEntry();
                }

            }else {
                for (File file : listFiles) {
                    // 判断是否需要保留原来的文件结构
                    if (keepDirStructure) {
                        // 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
                        // 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
                        compress(file, zos, name + "/" + file.getName(), keepDirStructure);
                    } else {
                        compress(file, zos, file.getName(), keepDirStructure);
                    }

                }
            }
        }
    }

    /**
     * 删除文件，可以是文件或文件夹
     *
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        } else {
            if (file.isFile()) {
                return deleteFile(fileName);
            } else {
                return deleteDirectory(fileName);
            }
        }
    }

    /**
     * 删除单个文件
     *
     * @param fileName 要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 删除目录及目录下的文件
     *
     * @param dir
     *            要删除的目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String dir) {
        // 如果dir不以文件分隔符结尾，自动添加文件分隔符
        if (!dir.endsWith(File.separator)) {
            dir = dir + File.separator;
        }
        File dirFile = new File(dir);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹中的所有文件包括子目录
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                flag = FileUtil.deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
            // 删除子目录
            else if (files[i].isDirectory()) {
                flag = FileUtil.deleteDirectory(files[i]
                        .getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            return false;
        }
        // 删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
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
     * 将生成的代码压缩
     *
     * @param projectName 项目名称
     */
    public static void zipFile(String projectName) {
        try {
            String filePath = System.getProperty("user.dir")+"/code/maven/"+projectName;
            FileOutputStream fos1 = new FileOutputStream(new File(filePath+"_"+System.currentTimeMillis()+".zip"));
            FileUtil.toZip(filePath, fos1, true);
            FileUtil.delete(filePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                return stringList;
            }
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String str = "";
            while ((str = br.readLine()) != null) {
                stringList.add(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                isr.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    /**
     * 将文件夹下所有文件复制到另一个目录
     *
     * @param fromPath 原始文件目录路径
     * @param toPath 新的目录路径
     */
    public static void copyDirectory(String fromPath, String toPath){
        File fromFile = new File(fromPath);
        File toFile = new File(toPath);
        if(!fromFile.canRead()){
            return;
        }else{
            if (!toFile.exists()) {
                toFile.mkdirs();
            }
            File[] files = fromFile.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    copyFile(new File(fromPath + File.separator + files[i].getName()), new File(toPath + File.separator + files[i].getName()));
                } else if (files[i].isDirectory()) {
                    copyDirectory(fromPath + File.separator + files[i].getName(), toPath + File.separator + files[i].getName());
                }
            }
        }
    }

    /**
     * 将文件复制到另一个目录
     *
     * @param s 原始文件
     * @param t 新的文件
     */
    public static void copyFile(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            in = fi.getChannel();//得到对应的文件通道
            out = fo.getChannel();//得到对应的文件通道
            in.transferTo(0, in.size(), out);//连接两个通道，并且从in通道读取，然后写入out通道
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /***
     * 替换指定文件中的指定内容
     * @param filepath  文件路径
     * @param sourceStr 文件需要替换的内容
     * @param targetStr 替换后的内容
     * @return 替换成功返回true，否则返回false
     */
    public static boolean replaceFileStr(String filepath,String sourceStr,String targetStr){
        try {
            FileReader fis = new FileReader(filepath);  // 创建文件输入流
            BufferedReader br = new BufferedReader(fis);
            char[] data = new char[1024];               // 创建缓冲字符数组
            int rn = 0;
            StringBuilder sb=new StringBuilder();       // 创建字符串构建器
            //fis.read(data)：将字符读入数组。在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。读取的字符数，如果已到达流的末尾，则返回 -1
            while ((rn = fis.read(data)) > 0) {         // 读取文件内容到字符串构建器
                String str=String.valueOf(data,0,rn);//把数组转换成字符串
                sb.append(str);
            }
            fis.close();// 关闭输入流
            // 从构建器中生成字符串，并替换搜索文本
            String str = sb.toString().replace(sourceStr, targetStr);
            FileWriter fout = new FileWriter(filepath);// 创建文件输出流
            fout.write(str.toCharArray());// 把替换完成的字符串写入文件内
            fout.close();// 关闭输出流

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
