package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.PropertyCosts;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Mapper
public interface PropertyCostsRepository {

    /**
     * 增加实例
     *
     * @param propertyCosts 实例
     * @return int 成功数量
     */
    int savePropertyCosts(PropertyCosts propertyCosts);

    /**
     * 增加多条
     *
     * @param propertyCostsList 多条列
     * @return int 成功数量
     */
    int saveBatchPropertyCosts(List<PropertyCosts> propertyCostsList);

    /**
     * 获取所有
     *
     * @return List<PropertyCosts> 主键集合
     */
    List<PropertyCosts> listPropertyCosts();

    /**
     * 根据条件获取多条
     *
     * @param propertyCosts 列:做条件查询使用
     * @return List<PropertyCosts> 列集合
     */
    List<PropertyCosts> listPropertyCostsByParam(PropertyCosts propertyCosts);

    /**
     * 根据条件删除多条实例
     *
     * @param propertyCosts 实例:做条件删除使用
     * @return int 成功数量
     */
    int deletePropertyCostsByParam(PropertyCosts propertyCosts);


    /**
     * 根据主键修改
     *
     * @param propertyCosts 列信息
     * @return int 成功数量
     */
    int updatePropertyCostsByKey(PropertyCosts propertyCosts);

    /**
     * 根据主键获取
     *
     * @param id id
     * @return PropertyCosts 信息
     */
    PropertyCosts getPropertyCostsByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id id
     * @return int 成功数量
     */
    int deletePropertyCostsByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchPropertyCostsByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<PropertyCosts> listPropertyCostsByKey(List<Integer> idList);

}
