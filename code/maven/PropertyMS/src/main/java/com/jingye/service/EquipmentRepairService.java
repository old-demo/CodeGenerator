package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.EquipmentRepair;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface EquipmentRepairService {

    /**
     * 增加实例
     *
     * @param equipmentRepair 实例
     * @return int 成功数量
     */
    int saveEquipmentRepair(EquipmentRepair equipmentRepair);

    /**
     * 增加多条实例
     *
     * @param equipmentRepairList 多条实例
     * @return int 成功数量
     */
    int saveEquipmentRepair(List<EquipmentRepair> equipmentRepairList);

    /**
     * 获取所有实例信息
     *
     * @return List<EquipmentRepair> 主键集合
     */
    List<EquipmentRepair> listEquipmentRepair();

    /**
     * 根据条件获取多条实例
     *
     * @param equipmentRepair 实例:做条件查询使用
     * @return List<EquipmentRepair> 实例集合
     */
    List<EquipmentRepair> listEquipmentRepairByParam(EquipmentRepair equipmentRepair);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<EquipmentRepair> 实例集合
     */
    PageInfoUtil<EquipmentRepair> listEquipmentRepairByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param equipmentRepair 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<EquipmentRepair> 实例集合
     */
    PageInfoUtil<EquipmentRepair> listEquipmentRepairByParamAndPage(EquipmentRepair equipmentRepair, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param equipmentRepair 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteEquipmentRepairByParam(EquipmentRepair equipmentRepair);

    /**
     * 修改实例
     *
     * @param equipmentRepair 实例信息
     * @return int 成功数量
     */
    int updateEquipmentRepairByKey(EquipmentRepair equipmentRepair);

    /**
     * 批量修改实例
     *
     * @param equipmentRepairList 多条实例信息
     * @return int 是否成功
     */
    int updateEquipmentRepairByKey(List<EquipmentRepair> equipmentRepairList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    EquipmentRepair getEquipmentRepairByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<EquipmentRepair> listEquipmentRepairByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteEquipmentRepairByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteEquipmentRepairByKey(List<Integer> idList);

}
