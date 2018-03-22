package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Charge;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Mapper
public interface ChargeRepository {

    /**
     * 增加实例
     *
     * @param charge 实例
     * @return int 成功数量
     */
    int saveCharge(Charge charge);

    /**
     * 增加多条
     *
     * @param chargeList 多条列
     * @return int 成功数量
     */
    int saveBatchCharge(List<Charge> chargeList);

    /**
     * 获取所有
     *
     * @return List<Charge> 主键集合
     */
    List<Charge> listCharge();

    /**
     * 根据条件获取多条
     *
     * @param charge 列:做条件查询使用
     * @return List<Charge> 列集合
     */
    List<Charge> listChargeByParam(Charge charge);

    /**
     * 根据条件删除多条实例
     *
     * @param charge 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteChargeByParam(Charge charge);


    /**
     * 根据主键修改
     *
     * @param charge 列信息
     * @return int 成功数量
     */
    int updateChargeByKey(Charge charge);

    /**
     * 根据主键获取
     *
     * @param chargeId 收费标准id
     * @return Charge 信息
     */
    Charge getChargeByKey(@Param("chargeId")Integer chargeId);

    /**
     * 根据主键删除
     *
    * @param chargeId 收费标准id
     * @return int 成功数量
     */
    int deleteChargeByKey(@Param("chargeId")Integer chargeId);

    /**
     * 根据多个主键删除多条
     *
     * @param chargeIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchChargeByKey(List<Integer> chargeIdList);

    /**
     * 根据多个主键获取
     *
     * @param chargeIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Charge> listChargeByKey(List<Integer> chargeIdList);

}
