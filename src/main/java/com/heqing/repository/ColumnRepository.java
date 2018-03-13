package com.heqing.repository;

import com.heqing.entity.orm.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 获取数据库 列信息
 *
 * @author heqing
 * @email 975656343@qq.com
 * @date 2018/01/03
 */
@Mapper
public interface ColumnRepository {

    /**
     * 获取表中所有列信息
     *
     * @param tableName 表名
     * @return 表中所有列
     */
    List<Column> listColumnByTable(@Param(value="tableName")String tableName);
}
