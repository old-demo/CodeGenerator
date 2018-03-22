package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Building;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Mapper
public interface BuildingRepository {

    /**
     * 增加实例
     *
     * @param building 实例
     * @return int 成功数量
     */
    int saveBuilding(Building building);

    /**
     * 增加多条
     *
     * @param buildingList 多条列
     * @return int 成功数量
     */
    int saveBatchBuilding(List<Building> buildingList);

    /**
     * 获取所有
     *
     * @return List<Building> 主键集合
     */
    List<Building> listBuilding();

    /**
     * 根据条件获取多条
     *
     * @param building 列:做条件查询使用
     * @return List<Building> 列集合
     */
    List<Building> listBuildingByParam(Building building);

    /**
     * 根据条件删除多条实例
     *
     * @param building 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingByParam(Building building);


    /**
     * 根据主键修改
     *
     * @param building 列信息
     * @return int 成功数量
     */
    int updateBuildingByKey(Building building);

    /**
     * 根据主键获取
     *
     * @param buildingId 大楼编号
     * @return Building 信息
     */
    Building getBuildingByKey(@Param("buildingId")Integer buildingId);

    /**
     * 根据主键删除
     *
    * @param buildingId 大楼编号
     * @return int 成功数量
     */
    int deleteBuildingByKey(@Param("buildingId")Integer buildingId);

    /**
     * 根据多个主键删除多条
     *
     * @param buildingIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchBuildingByKey(List<Integer> buildingIdList);

    /**
     * 根据多个主键获取
     *
     * @param buildingIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Building> listBuildingByKey(List<Integer> buildingIdList);

}
