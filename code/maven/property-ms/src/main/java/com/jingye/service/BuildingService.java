package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Building;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
public interface BuildingService {

    /**
     * 增加实例
     *
     * @param building 实例
     * @return int 成功数量
     */
    int saveBuilding(Building building);

    /**
     * 增加多条实例
     *
     * @param buildingList 多条实例
     * @return int 成功数量
     */
    int saveBuilding(List<Building> buildingList);

    /**
     * 获取所有实例信息
     *
     * @return List<Building> 主键集合
     */
    List<Building> listBuilding();

    /**
     * 根据条件获取多条实例
     *
     * @param building 实例:做条件查询使用
     * @return List<Building> 实例集合
     */
    List<Building> listBuildingByParam(Building building);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Building> 实例集合
     */
    PageInfoUtil<Building> listBuildingByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param building 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Building> 实例集合
     */
    PageInfoUtil<Building> listBuildingByParamAndPage(Building building, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param building 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingByParam(Building building);

    /**
     * 修改实例
     *
     * @param building 实例信息
     * @return int 成功数量
     */
    int updateBuildingByKey(Building building);

    /**
     * 批量修改实例
     *
     * @param buildingList 多条实例信息
     * @return int 是否成功
     */
    int updateBuildingByKey(List<Building> buildingList);


    /**
     * 根据主键获取实例信息
     *
     * @param buildingId  实例
     * @return List<T> 实例信息
     */
    Building getBuildingByKey(Integer buildingId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param buildingIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Building> listBuildingByKey(List<Integer> buildingIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param buildingId 主键
     * @return int 成功数量
     */
    int deleteBuildingByKey(Integer buildingId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param buildingIdList 主键集合
     * @return int 成功数量
     */
    int deleteBuildingByKey(List<Integer> buildingIdList);

}
