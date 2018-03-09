package com.heqing.service;

import com.heqing.entity.orm.ColumnEntity;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 获取数据库 表 列信息接口
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
public interface ColumnService {

    /**
     * 获取表中所有列信息
     *
     * @param dbId 数据库id
     * @param tableName 表名
     * @return 表中所有列
     */
    List<ColumnEntity> listColumnByTable(Integer dbId, String tableName);

    /**
     * 获取表中所有列信息
     *
     * @param sqlSession 操作数据库
     * @param tableName 表名
     * @return 表中所有列
     */
    List<ColumnEntity> listColumnByTable(SqlSession sqlSession, String tableName);
}
