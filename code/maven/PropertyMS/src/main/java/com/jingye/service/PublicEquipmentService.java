package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.PublicEquipment;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public interface PublicEquipmentService {

    /**
     * 增加实例
     *
     * @param publicEquipment 实例
     * @return int 成功数量
     */
    int savePublicEquipment(PublicEquipment publicEquipment);

    /**
     * 增加多条实例
     *
     * @param publicEquipmentList 多条实例
     * @return int 成功数量
     */
    int savePublicEquipment(List<PublicEquipment> publicEquipmentList);

    /**
     * 获取所有实例信息
     *
     * @return List<PublicEquipment> 主键集合
     */
    List<PublicEquipment> listPublicEquipment();

    /**
     * 根据条件获取多条实例
     *
     * @param publicEquipment 实例:做条件查询使用
     * @return List<PublicEquipment> 实例集合
     */
    List<PublicEquipment> listPublicEquipmentByParam(PublicEquipment publicEquipment);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<PublicEquipment> 实例集合
     */
    PageInfoUtil<PublicEquipment> listPublicEquipmentByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param publicEquipment 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<PublicEquipment> 实例集合
     */
    PageInfoUtil<PublicEquipment> listPublicEquipmentByParamAndPage(PublicEquipment publicEquipment, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param publicEquipment 实例:做条件删除使用
     * @return int 成功数量
     */
    int deletePublicEquipmentByParam(PublicEquipment publicEquipment);

    /**
     * 修改实例
     *
     * @param publicEquipment 实例信息
     * @return int 成功数量
     */
    int updatePublicEquipmentByKey(PublicEquipment publicEquipment);

    /**
     * 批量修改实例
     *
     * @param publicEquipmentList 多条实例信息
     * @return int 是否成功
     */
    int updatePublicEquipmentByKey(List<PublicEquipment> publicEquipmentList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    PublicEquipment getPublicEquipmentByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<PublicEquipment> listPublicEquipmentByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deletePublicEquipmentByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deletePublicEquipmentByKey(List<Integer> idList);

}
