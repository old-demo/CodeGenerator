package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Charge;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
public interface ChargeService {

    /**
     * 增加实例
     *
     * @param charge 实例
     * @return int 成功数量
     */
    int saveCharge(Charge charge);

    /**
     * 增加多条实例
     *
     * @param chargeList 多条实例
     * @return int 成功数量
     */
    int saveCharge(List<Charge> chargeList);

    /**
     * 获取所有实例信息
     *
     * @return List<Charge> 主键集合
     */
    List<Charge> listCharge();

    /**
     * 根据条件获取多条实例
     *
     * @param charge 实例:做条件查询使用
     * @return List<Charge> 实例集合
     */
    List<Charge> listChargeByParam(Charge charge);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Charge> 实例集合
     */
    PageInfoUtil<Charge> listChargeByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param charge 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Charge> 实例集合
     */
    PageInfoUtil<Charge> listChargeByParamAndPage(Charge charge, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param charge 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteChargeByParam(Charge charge);

    /**
     * 修改实例
     *
     * @param charge 实例信息
     * @return int 成功数量
     */
    int updateChargeByKey(Charge charge);

    /**
     * 批量修改实例
     *
     * @param chargeList 多条实例信息
     * @return int 是否成功
     */
    int updateChargeByKey(List<Charge> chargeList);


    /**
     * 根据主键获取实例信息
     *
     * @param chargeId  实例
     * @return List<T> 实例信息
     */
    Charge getChargeByKey(Integer chargeId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param chargeIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Charge> listChargeByKey(List<Integer> chargeIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param chargeId 主键
     * @return int 成功数量
     */
    int deleteChargeByKey(Integer chargeId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param chargeIdList 主键集合
     * @return int 成功数量
     */
    int deleteChargeByKey(List<Integer> chargeIdList);

}
