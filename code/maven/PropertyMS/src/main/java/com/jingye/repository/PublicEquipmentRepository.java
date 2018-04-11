package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.PublicEquipment;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Mapper
public interface PublicEquipmentRepository {

    /**
     * 增加实例
     *
     * @param publicEquipment 实例
     * @return int 成功数量
     */
    int savePublicEquipment(PublicEquipment publicEquipment);

    /**
     * 增加多条
     *
     * @param publicEquipmentList 多条列
     * @return int 成功数量
     */
    int saveBatchPublicEquipment(List<PublicEquipment> publicEquipmentList);

    /**
     * 获取所有
     *
     * @return List<PublicEquipment> 主键集合
     */
    List<PublicEquipment> listPublicEquipment();

    /**
     * 根据条件获取多条
     *
     * @param publicEquipment 列:做条件查询使用
     * @return List<PublicEquipment> 列集合
     */
    List<PublicEquipment> listPublicEquipmentByParam(PublicEquipment publicEquipment);

    /**
     * 根据条件删除多条实例
     *
     * @param publicEquipment 实例:做条件删除使用
     * @return int 成功数量
     */
    int deletePublicEquipmentByParam(PublicEquipment publicEquipment);


    /**
     * 根据主键修改
     *
     * @param publicEquipment 列信息
     * @return int 成功数量
     */
    int updatePublicEquipmentByKey(PublicEquipment publicEquipment);

    /**
     * 根据主键获取
     *
     * @param id Id
     * @return PublicEquipment 信息
     */
    PublicEquipment getPublicEquipmentByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id Id
     * @return int 成功数量
     */
    int deletePublicEquipmentByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchPublicEquipmentByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<PublicEquipment> listPublicEquipmentByKey(List<Integer> idList);

}
