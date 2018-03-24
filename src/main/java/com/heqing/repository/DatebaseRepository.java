package com.heqing.repository;

import com.heqing.entity.orm.Datebase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据库连接信息数据持久层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
@Mapper
public interface DatebaseRepository {

    /**
     * 增加数据库连接信息
     *
     * @param datebase 数据库连接信息列
     * @return int 成功数量
     */
    int saveDatebase(Datebase datebase);

    /**
     * 增加多条数据库连接信息
     *
     * @param datebaseList 多条数据库连接信息列
     * @return int 成功数量
     */
    int saveBatchDatebase(List<Datebase> datebaseList);

    /**
     * 根据主键删除数据库连接信息
     *
     * @param id id
     * @return int 成功数量
     */
    int deleteDatebaseByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条数据库连接信息
     *
     * @param ids  数据库连接信息列集合
     * @return int 成功数量
     */
    int deleteBatchDatebaseByKey(List<Integer> ids);

    /**
     * 根据条件删除多条数据库连接信息
     *
     * @param datebase 数据库连接信息列:做条件删除使用
     * @return int 成功数量
     */
    int deleteBatchDatebaseByParam(Datebase datebase);

    /**
     * 根据主键修改数据库连接信息
     *
     * @param datebase 数据库连接信息列信息
     * @return int 成功数量
     */
    int updateDatebaseByKey(Datebase datebase);

    /**
     * 根据多个主键批量修改数据库连接信息
     *
     * @param datebaseList 多条数据库连接信息列信息
     * @return int 是否成功
     */
    int updateBatchDatebaseByKey(List<Datebase> datebaseList);

    /**
     * 根据主键获取数据库连接信息
     *
     * @param id id
     * @return Datebase 数据库连接信息信息
     */
    Datebase getDatebaseByKey(@Param("id")Integer id);

    /**
     * 根据多个主键获取数据库连接信息
     *
     * @param ids  数据库连接信息列集合
     * @return List<T> 数据库连接信息列实体信息
     */
    List<Datebase> listDatebaseByKey(List<Integer> ids);

    /**
     * 获取所有数据库连接信息
     *
     * @return List<Datebase> 数据库连接信息主键集合
     */
    List<Datebase> listDatebase();

    /**
     * 根据条件获取多条数据库连接信息
     *
     * @param datebase 数据库连接信息列:做条件查询使用
     * @return List<Datebase> 数据库连接信息列集合
     */
    List<Datebase> listDatebaseByParam(Datebase datebase);

}
