package com.heqing.service;

import com.heqing.entity.orm.Datebase;
import com.heqing.util.PageInfoUtil;

import java.util.List;

/**
 * 数据库连接信息业务逻辑层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
public interface DatebaseService {

    /**
     * 增加数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例
     * @return int 成功数量
     */
    int saveDatebase(Datebase datebase);

    /**
     * 增加多条数据库连接信息实例
     *
     * @param datebaseList 多条数据库连接信息实例
     * @return int 成功数量
     */
    int saveBatchDatebase(List<Datebase> datebaseList);

    /**
     * 根据主键删除数据库连接信息实例
     *
     * @param id id
     * @return int 成功数量
     */
    int deleteDatebaseByKey(Integer id);

    /**
     * 根据主键删除多条数据库连接信息实例
     *
     * @param ids 主键ID集合
     * @return int 成功数量
     */
    int deleteBatchDatebaseByKey(List<Integer> ids);

    /**
     * 根据条件删除多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBatchDatebaseByParam(Datebase datebase);

    /**
     * 修改数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例信息
     * @return int 成功数量
     */
    int updateDatebaseByKey(Datebase datebase);

    /**
     * 批量修改数据库连接信息实例
     *
     * @param datebaseList 多条数据库连接信息实例信息
     * @return int 是否成功
     */
    int updateBatchDatebaseByKey(List<Datebase> datebaseList);

    /**
     * 根据主键获取数据库连接信息实例信息
     *
     * @param id id
     * @return Datebase 数据库连接信息信息
     */
    Datebase getDatebaseByKey(Integer id);

    /**
     * 根据主键获取数据库连接信息实例信息
     *
     * @param ids  数据库连接信息实例集合
     * @return List<T> 数据库连接信息实例信息
     */
    List<Datebase> listDatebaseByKey(List<Integer> ids);

    /**
     * 获取所有数据库连接信息实例信息
     *
     * @return List<Datebase> 数据库连接信息主键集合
     */
    List<Datebase> listDatebase();

    /**
     * 根据条件获取多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件查询使用
     * @return List<Datebase> 数据库连接信息实例集合
     */
    List<Datebase> listDatebaseByParam(Datebase datebase);

    /**
     * 根据分页获取多条数据库连接信息实例
     *
     * @param pageNo 第几页
     * @param pageSize 每页数量
     * @return Page<Datebase> 数据库连接信息实例集合
     */
    PageInfoUtil<Datebase> listDatebaseByPage(int pageNo, int pageSize);

    /**
     * 根据分页及条件获取多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Datebase> 数据库连接信息实例集合
     */
    PageInfoUtil<Datebase> listDatebaseByParamAndPage(Datebase datebase, int pageNum, int pageSize);

}
