package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.BuildingInfo;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface BuildingInfoService {

    /**
     * 增加实例
     *
     * @param buildingInfo 实例
     * @return int 成功数量
     */
    int saveBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 增加多条实例
     *
     * @param buildingInfoList 多条实例
     * @return int 成功数量
     */
    int saveBuildingInfo(List<BuildingInfo> buildingInfoList);

    /**
     * 获取所有实例信息
     *
     * @return List<BuildingInfo> 主键集合
     */
    List<BuildingInfo> listBuildingInfo();

    /**
     * 根据条件获取多条实例
     *
     * @param buildingInfo 实例:做条件查询使用
     * @return List<BuildingInfo> 实例集合
     */
    List<BuildingInfo> listBuildingInfoByParam(BuildingInfo buildingInfo);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<BuildingInfo> 实例集合
     */
    PageInfoUtil<BuildingInfo> listBuildingInfoByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param buildingInfo 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<BuildingInfo> 实例集合
     */
    PageInfoUtil<BuildingInfo> listBuildingInfoByParamAndPage(BuildingInfo buildingInfo, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param buildingInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingInfoByParam(BuildingInfo buildingInfo);

    /**
     * 修改实例
     *
     * @param buildingInfo 实例信息
     * @return int 成功数量
     */
    int updateBuildingInfoByKey(BuildingInfo buildingInfo);

    /**
     * 批量修改实例
     *
     * @param buildingInfoList 多条实例信息
     * @return int 是否成功
     */
    int updateBuildingInfoByKey(List<BuildingInfo> buildingInfoList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    BuildingInfo getBuildingInfoByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<BuildingInfo> listBuildingInfoByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteBuildingInfoByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteBuildingInfoByKey(List<Integer> idList);

}
