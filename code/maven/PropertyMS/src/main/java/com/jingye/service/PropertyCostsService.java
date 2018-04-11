package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.PropertyCosts;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface PropertyCostsService {

    /**
     * 增加实例
     *
     * @param propertyCosts 实例
     * @return int 成功数量
     */
    int savePropertyCosts(PropertyCosts propertyCosts);

    /**
     * 增加多条实例
     *
     * @param propertyCostsList 多条实例
     * @return int 成功数量
     */
    int savePropertyCosts(List<PropertyCosts> propertyCostsList);

    /**
     * 获取所有实例信息
     *
     * @return List<PropertyCosts> 主键集合
     */
    List<PropertyCosts> listPropertyCosts();

    /**
     * 根据条件获取多条实例
     *
     * @param propertyCosts 实例:做条件查询使用
     * @return List<PropertyCosts> 实例集合
     */
    List<PropertyCosts> listPropertyCostsByParam(PropertyCosts propertyCosts);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<PropertyCosts> 实例集合
     */
    PageInfoUtil<PropertyCosts> listPropertyCostsByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param propertyCosts 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<PropertyCosts> 实例集合
     */
    PageInfoUtil<PropertyCosts> listPropertyCostsByParamAndPage(PropertyCosts propertyCosts, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param propertyCosts 实例:做条件删除使用
     * @return int 成功数量
     */
    int deletePropertyCostsByParam(PropertyCosts propertyCosts);

    /**
     * 修改实例
     *
     * @param propertyCosts 实例信息
     * @return int 成功数量
     */
    int updatePropertyCostsByKey(PropertyCosts propertyCosts);

    /**
     * 批量修改实例
     *
     * @param propertyCostsList 多条实例信息
     * @return int 是否成功
     */
    int updatePropertyCostsByKey(List<PropertyCosts> propertyCostsList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    PropertyCosts getPropertyCostsByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<PropertyCosts> listPropertyCostsByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deletePropertyCostsByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deletePropertyCostsByKey(List<Integer> idList);

}
