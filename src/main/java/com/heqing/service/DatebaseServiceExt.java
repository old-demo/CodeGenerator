package com.heqing.service;

import com.heqing.entity.orm.DatebaseEntity;
import org.apache.ibatis.session.SqlSession;

/**
 * 数据库连接信息业务逻辑层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
public interface DatebaseServiceExt extends DatebaseService {

    /**
     * 测试数据库是否连接成功
     *
     * @param datebase 数据库信息
     * @return 是否成功
     */
    Boolean connect(DatebaseEntity datebase);

    /**
     * 测试数据库是否连接成功
     *
     * @param driverClass 数据库引擎
     * @param url 联接地址
     * @param userName 用户名
     * @param password 数据库引擎
     * @return 是否成功
     */
    Boolean connect(String driverClass, String url, String userName, String password);

    /**
     * 根据数据库id获取SqlSession
     *
     * @param dbId 连接信息id
     * @return Sql操作类
     */
    SqlSession getSqlSession(Integer dbId);

    /**
     * 根据数据库信息获取SqlSession
     *
     * @param datebase 数据库信息
     * @return Sql操作类
     */
    SqlSession getSqlSession(DatebaseEntity datebase);
}
