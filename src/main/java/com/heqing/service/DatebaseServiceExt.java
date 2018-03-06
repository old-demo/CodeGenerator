package com.heqing.service;

import com.heqing.entity.Datebase;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;

/**
 * 数据库连接信息业务逻辑层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
public interface DatebaseServiceExt extends DatebaseService {

    /**
     * 根据分页及条件获取多个实体信息
     *
     * @param driverClass 数据库引擎
     * @param url 联接地址
     * @param userName 用户名
     * @param password 数据库引擎
     * @return password 登录密码
     */
    Connection connect(String driverClass, String url, String userName, String password);

    /**
     * 根据数据库id获取SqlSession
     *
     * @param dbId 连接信息id
     * @return password
     */
    SqlSession getSqlSession(Integer dbId);

    /**
     * 根据数据库信息获取SqlSession
     *
     * @param datebase 数据库信息
     * @return password
     */
    SqlSession getSqlSession(Datebase datebase);
}
