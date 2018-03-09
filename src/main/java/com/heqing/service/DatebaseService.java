package com.heqing.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.DatebaseEntity;

/**
 * 数据库连接信息业务逻辑层接口
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:20:35
 */
public interface DatebaseService {

    /**
     * 增加数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例
     * @return 成功数量
     */
    int saveDatebase(DatebaseEntity datebase);

    /**
     * 增加多条数据库连接信息实例
     *
     * @param datebaseList 多条数据库连接信息实例
     * @return 成功数量
     */
    int saveBatchDatebase(List<DatebaseEntity> datebaseList);

    /**
     * 根据主键删除数据库连接信息实例
     *
     * @param id id
     * @return 成功数量
     */
    int removeDatebaseByKey(Integer id);

    /**
     * 根据主键删除多条数据库连接信息实例
     *
     * @param ids 主键ID集合
     * @return 成功数量
     */
    int removeBatchDatebaseByKey(List<Integer> ids);

    /**
     * 根据条件删除多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件删除使用
     * @return 成功数量
     */
    int removeBatchDatebaseByParam(DatebaseEntity datebase);

    /**
     * 修改数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例信息
     * @return 成功数量
     */
    int modifyDatebaseByKey(DatebaseEntity datebase);

    /**
     * 批量修改数据库连接信息实例
     *
     * @param datebaseList 多条数据库连接信息实例信息
     * @return 是否成功
     */
    int modifyBatchDatebaseByKey(List<DatebaseEntity> datebaseList);

    /**
     * 根据主键获取数据库连接信息实例信息
     *
     * @param id id
     * @return 数据库连接信息信息
     */
    DatebaseEntity getDatebaseByKey(Integer id);

    /**
     * 根据主键获取数据库连接信息实例信息
     *
     * @param ids  数据库连接信息实例集合
     * @return 数据库连接信息实例信息
     */
    List<DatebaseEntity> listDatebaseByKey(List<Integer> ids);

    /**
     * 获取所有数据库连接信息实例信息
     *
     * @return 数据库连接信息主键集合
     */
    List<DatebaseEntity> listDatebase();

    /**
     * 根据条件获取多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件查询使用
     * @return 数据库连接信息实例集合
     */
    List<DatebaseEntity> listDatebaseByParam(DatebaseEntity datebase);

    /**
     * 根据分页获取多条数据库连接信息实例
     *
     * @param pageNo 第几页
     * @param pageSize 每页数量
     * @return 数据库连接信息实例集合
     */
    PageInfo<DatebaseEntity> listDatebaseByPage(int pageNo, int pageSize);

    /**
     * 根据分页及条件获取多条数据库连接信息实例
     *
     * @param datebase 数据库连接信息实例:做条件查询使用
     * @param pageNo 第几页
     * @param pageSize 每页数量
     * @return 数据库连接信息实例集合
     */
    PageInfo<DatebaseEntity> listDatebaseByParamAndPage(DatebaseEntity datebase, int pageNo, int pageSize);

}
