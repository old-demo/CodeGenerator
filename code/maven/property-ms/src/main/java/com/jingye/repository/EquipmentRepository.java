package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Equipment;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Mapper
public interface EquipmentRepository {

    /**
     * 增加实例
     *
     * @param equipment 实例
     * @return int 成功数量
     */
    int saveEquipment(Equipment equipment);

    /**
     * 增加多条
     *
     * @param equipmentList 多条列
     * @return int 成功数量
     */
    int saveBatchEquipment(List<Equipment> equipmentList);

    /**
     * 获取所有
     *
     * @return List<Equipment> 主键集合
     */
    List<Equipment> listEquipment();

    /**
     * 根据条件获取多条
     *
     * @param equipment 列:做条件查询使用
     * @return List<Equipment> 列集合
     */
    List<Equipment> listEquipmentByParam(Equipment equipment);

    /**
     * 根据条件删除多条实例
     *
     * @param equipment 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteEquipmentByParam(Equipment equipment);


    /**
     * 根据主键修改
     *
     * @param equipment 列信息
     * @return int 成功数量
     */
    int updateEquipmentByKey(Equipment equipment);

    /**
     * 根据主键获取
     *
     * @param equipmentId 编号
     * @return Equipment 信息
     */
    Equipment getEquipmentByKey(@Param("equipmentId")Integer equipmentId);

    /**
     * 根据主键删除
     *
    * @param equipmentId 编号
     * @return int 成功数量
     */
    int deleteEquipmentByKey(@Param("equipmentId")Integer equipmentId);

    /**
     * 根据多个主键删除多条
     *
     * @param equipmentIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchEquipmentByKey(List<Integer> equipmentIdList);

    /**
     * 根据多个主键获取
     *
     * @param equipmentIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Equipment> listEquipmentByKey(List<Integer> equipmentIdList);

}
