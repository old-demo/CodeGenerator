package com.heqing.repository;

import com.heqing.entity.orm.TableEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 获取数据库 表信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
@Mapper
public interface TableRepository {

    /**
     * 获取所有表信息
     *
     * @param tableName 表名
     * @return 所有表信息
     */
    TableEntity getTableByName(@Param(value="tableName")String tableName);

    /**
     * 获取所有表信息
     *
     * @return 所有表信息
     */
    List<TableEntity> listTable();
}
