package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.BuildingType;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface BuildingTypeService {

    /**
     * 增加实例
     *
     * @param buildingType 实例
     * @return int 成功数量
     */
    int saveBuildingType(BuildingType buildingType);

    /**
     * 增加多条实例
     *
     * @param buildingTypeList 多条实例
     * @return int 成功数量
     */
    int saveBuildingType(List<BuildingType> buildingTypeList);

    /**
     * 获取所有实例信息
     *
     * @return List<BuildingType> 主键集合
     */
    List<BuildingType> listBuildingType();

    /**
     * 根据条件获取多条实例
     *
     * @param buildingType 实例:做条件查询使用
     * @return List<BuildingType> 实例集合
     */
    List<BuildingType> listBuildingTypeByParam(BuildingType buildingType);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<BuildingType> 实例集合
     */
    PageInfoUtil<BuildingType> listBuildingTypeByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param buildingType 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<BuildingType> 实例集合
     */
    PageInfoUtil<BuildingType> listBuildingTypeByParamAndPage(BuildingType buildingType, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param buildingType 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingTypeByParam(BuildingType buildingType);

    /**
     * 修改实例
     *
     * @param buildingType 实例信息
     * @return int 成功数量
     */
    int updateBuildingTypeByKey(BuildingType buildingType);

    /**
     * 批量修改实例
     *
     * @param buildingTypeList 多条实例信息
     * @return int 是否成功
     */
    int updateBuildingTypeByKey(List<BuildingType> buildingTypeList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    BuildingType getBuildingTypeByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<BuildingType> listBuildingTypeByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteBuildingTypeByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteBuildingTypeByKey(List<Integer> idList);

}
