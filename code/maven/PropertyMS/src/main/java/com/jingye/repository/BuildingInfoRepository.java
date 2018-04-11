package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.BuildingInfo;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Mapper
public interface BuildingInfoRepository {

    /**
     * 增加实例
     *
     * @param buildingInfo 实例
     * @return int 成功数量
     */
    int saveBuildingInfo(BuildingInfo buildingInfo);

    /**
     * 增加多条
     *
     * @param buildingInfoList 多条列
     * @return int 成功数量
     */
    int saveBatchBuildingInfo(List<BuildingInfo> buildingInfoList);

    /**
     * 获取所有
     *
     * @return List<BuildingInfo> 主键集合
     */
    List<BuildingInfo> listBuildingInfo();

    /**
     * 根据条件获取多条
     *
     * @param buildingInfo 列:做条件查询使用
     * @return List<BuildingInfo> 列集合
     */
    List<BuildingInfo> listBuildingInfoByParam(BuildingInfo buildingInfo);

    /**
     * 根据条件删除多条实例
     *
     * @param buildingInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteBuildingInfoByParam(BuildingInfo buildingInfo);


    /**
     * 根据主键修改
     *
     * @param buildingInfo 列信息
     * @return int 成功数量
     */
    int updateBuildingInfoByKey(BuildingInfo buildingInfo);

    /**
     * 根据主键获取
     *
     * @param id id
     * @return BuildingInfo 信息
     */
    BuildingInfo getBuildingInfoByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id id
     * @return int 成功数量
     */
    int deleteBuildingInfoByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchBuildingInfoByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<BuildingInfo> listBuildingInfoByKey(List<Integer> idList);

}
