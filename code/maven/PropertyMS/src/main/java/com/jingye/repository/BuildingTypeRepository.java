package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.BuildingType;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Mapper
public interface BuildingTypeRepository {

    /**
     * 增加实例
     *
     * @param buildingType 实例
     * @return int 成功数量
     */
    int saveBuildingType(BuildingType buildingType);

    /**
     * 增加多条
     *
     * @param buildingTypeList 多条列
     * @return int 成功数量
     */
    int saveBatchBuildingType(List<BuildingType> buildingTypeList);

    /**
     * 获取所有
     *
     * @return List<BuildingType> 主键集合
     */
    List<BuildingType> listBuildingType();

    /**
     * 根据条件获取多条
     *
     * @param buildingType 列:做条件查询使用
     * @return List<BuildingType> 列集合
     */
    List<BuildingType> listBuildingTypeByParam(BuildingType buildingType);

    /**
     * 根据条件删除多条实例
     *
     * @param buildingType 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingTypeByParam(BuildingType buildingType);


    /**
     * 根据主键修改
     *
     * @param buildingType 列信息
     * @return int 成功数量
     */
    int updateBuildingTypeByKey(BuildingType buildingType);

    /**
     * 根据主键获取
     *
     * @param id id
     * @return BuildingType 信息
     */
    BuildingType getBuildingTypeByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id id
     * @return int 成功数量
     */
    int deleteBuildingTypeByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchBuildingTypeByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<BuildingType> listBuildingTypeByKey(List<Integer> idList);

}
