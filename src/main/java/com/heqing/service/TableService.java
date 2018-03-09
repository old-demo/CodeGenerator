package com.heqing.service;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.TableEntity;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 获取数据库 表信息接口
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
public interface TableService {

    /**
     * 获取所有表信息
     *
     * @param dbId 数据库id
     * @param tableName 表名
     * @return 所有表信息
     */
    TableEntity getTableByName(Integer dbId, String tableName);

    /**
     * 获取所有表信息
     *
     * @param sqlSession 操作数据库
     * @param tableName 表名
     * @return 所有表信息
     */
    TableEntity getTableByName(SqlSession sqlSession, String tableName);

    /**
     * 获取所有表信息
     *
     * @param dbId 数据库id
     * @return 所有表信息
     */
    List<TableEntity> listTable(Integer dbId);

    /**
     * 获取所有表信息
     *
     * @param sqlSession 操作数据库
     * @return 所有表信息
     */
    List<TableEntity> listTable(SqlSession sqlSession);

    /**
     * 根据表名模糊匹配表信息
     *
     * @param dbId 数据库id
     * @param tableName 表名
     * @param pageNo 第几页
     * @param pageSize 每页数量
     * @return 所有表信息
     */
    PageInfo<TableEntity> listTableByParamAndPage(Integer dbId, String tableName, int pageNo, int pageSize);

    /**
     * 根据表名模糊匹配表信息
     *
     * @param sqlSession 操作数据库
     * @param tableName 表名
     * @param pageNo 第几页
     * @param pageSize 每页数量
     * @return 所有表信息
     */
    PageInfo<TableEntity> listTableByParamAndPage(SqlSession sqlSession, String tableName, int pageNo, int pageSize);
}
