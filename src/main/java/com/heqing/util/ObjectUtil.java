package com.heqing.util;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * 对象工厂
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
public class ObjectUtil {

    private static final Logger LOGGER = Logger.getLogger(ObjectUtil.class);

    private static List<ClassLoader> externalClassLoaders;

    static {
        externalClassLoaders = new ArrayList<ClassLoader>();
    }

    private ObjectUtil(){
        super();
    }

    public static synchronized void addExternalClassLoader(ClassLoader classLoader) {
        ObjectUtil.externalClassLoaders.add(classLoader);
    }

    @SuppressWarnings("rawtypes")
    public static Class externalClassForName(String type) throws ClassNotFoundException {

        Class clazz;

        for (ClassLoader classLoader : externalClassLoaders) {
            try {
                classLoader.loadClass(type);
                clazz = Class.forName(type, true, classLoader);
                return clazz;
            } catch (ClassNotFoundException e) {
                LOGGER.info(e.getMessage(), e);
            }
        }

        return internalClassForName(type);
    }

    public static Class<?> internalClassForName(String type) throws ClassNotFoundException {
        Class<?> clazz = null;

        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            clazz = Class.forName(type, true, cl);
        } catch (ClassNotFoundException e) {
            LOGGER.info(e.getMessage(), e);
        }

        if (clazz == null) {
            clazz = Class.forName(type, true, ObjectUtil.class.getClassLoader());
        }

        return clazz;
    }

    public static Object createExternalObject(String type) {
        Object answer = null;

        try {
            Class<?> clazz = externalClassForName(type);
            answer = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return answer;
    }

    public static Map<String,Object> objToMap(Object obj) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (key.compareToIgnoreCase("class") == 0) {
                    continue;
                }
                Method getter = property.getReadMethod();
                Object value = getter != null ? getter.invoke(obj) : null;
                map.put(key, value);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static Object map2Obj(Map<String,Object> map, Class<?> clz) {
        Object obj = null;
        try {
            if (map == null) {
                return null;
            }
            obj = clz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                Method setter = property.getWriteMethod();
                if (setter != null) {
                    setter.invoke(obj, map.get(property.getName()));
                }
            }
            return obj;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static String obj2json(Object obj) throws Exception {
        return JSON.toJSONString(obj);
    }

    public static <T> T json2obj(String jsonStr, Class<T> clazz) throws Exception {
        return JSON.parseObject(jsonStr, clazz);
    }

    public static <T> Map<String, Object> json2map(String jsonStr)     throws Exception {
        return JSON.parseObject(jsonStr, Map.class);
    }

    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }
}
