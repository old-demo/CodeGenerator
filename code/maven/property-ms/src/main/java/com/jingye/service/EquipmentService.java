package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Equipment;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public interface EquipmentService {

    /**
     * 增加实例
     *
     * @param equipment 实例
     * @return int 成功数量
     */
    int saveEquipment(Equipment equipment);

    /**
     * 增加多条实例
     *
     * @param equipmentList 多条实例
     * @return int 成功数量
     */
    int saveEquipment(List<Equipment> equipmentList);

    /**
     * 获取所有实例信息
     *
     * @return List<Equipment> 主键集合
     */
    List<Equipment> listEquipment();

    /**
     * 根据条件获取多条实例
     *
     * @param equipment 实例:做条件查询使用
     * @return List<Equipment> 实例集合
     */
    List<Equipment> listEquipmentByParam(Equipment equipment);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Equipment> 实例集合
     */
    PageInfoUtil<Equipment> listEquipmentByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param equipment 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Equipment> 实例集合
     */
    PageInfoUtil<Equipment> listEquipmentByParamAndPage(Equipment equipment, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param equipment 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteEquipmentByParam(Equipment equipment);

    /**
     * 修改实例
     *
     * @param equipment 实例信息
     * @return int 成功数量
     */
    int updateEquipmentByKey(Equipment equipment);

    /**
     * 批量修改实例
     *
     * @param equipmentList 多条实例信息
     * @return int 是否成功
     */
    int updateEquipmentByKey(List<Equipment> equipmentList);


    /**
     * 根据主键获取实例信息
     *
     * @param equipmentId  实例
     * @return List<T> 实例信息
     */
    Equipment getEquipmentByKey(Integer equipmentId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param equipmentIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Equipment> listEquipmentByKey(List<Integer> equipmentIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param equipmentId 主键
     * @return int 成功数量
     */
    int deleteEquipmentByKey(Integer equipmentId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param equipmentIdList 主键集合
     * @return int 成功数量
     */
    int deleteEquipmentByKey(List<Integer> equipmentIdList);

}
