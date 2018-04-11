package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.ParkingSpaces;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Mapper
public interface ParkingSpacesRepository {

    /**
     * 增加实例
     *
     * @param parkingSpaces 实例
     * @return int 成功数量
     */
    int saveParkingSpaces(ParkingSpaces parkingSpaces);

    /**
     * 增加多条
     *
     * @param parkingSpacesList 多条列
     * @return int 成功数量
     */
    int saveBatchParkingSpaces(List<ParkingSpaces> parkingSpacesList);

    /**
     * 获取所有
     *
     * @return List<ParkingSpaces> 主键集合
     */
    List<ParkingSpaces> listParkingSpaces();

    /**
     * 根据条件获取多条
     *
     * @param parkingSpaces 列:做条件查询使用
     * @return List<ParkingSpaces> 列集合
     */
    List<ParkingSpaces> listParkingSpacesByParam(ParkingSpaces parkingSpaces);

    /**
     * 根据条件删除多条实例
     *
     * @param parkingSpaces 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteParkingSpacesByParam(ParkingSpaces parkingSpaces);


    /**
     * 根据主键修改
     *
     * @param parkingSpaces 列信息
     * @return int 成功数量
     */
    int updateParkingSpacesByKey(ParkingSpaces parkingSpaces);

    /**
     * 根据主键获取
     *
     * @param id id
     * @return ParkingSpaces 信息
     */
    ParkingSpaces getParkingSpacesByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id id
     * @return int 成功数量
     */
    int deleteParkingSpacesByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchParkingSpacesByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<ParkingSpaces> listParkingSpacesByKey(List<Integer> idList);

}
