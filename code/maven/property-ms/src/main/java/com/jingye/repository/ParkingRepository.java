package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Parking;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Mapper
public interface ParkingRepository {

    /**
     * 增加实例
     *
     * @param parking 实例
     * @return int 成功数量
     */
    int saveParking(Parking parking);

    /**
     * 增加多条
     *
     * @param parkingList 多条列
     * @return int 成功数量
     */
    int saveBatchParking(List<Parking> parkingList);

    /**
     * 获取所有
     *
     * @return List<Parking> 主键集合
     */
    List<Parking> listParking();

    /**
     * 根据条件获取多条
     *
     * @param parking 列:做条件查询使用
     * @return List<Parking> 列集合
     */
    List<Parking> listParkingByParam(Parking parking);

    /**
     * 根据条件删除多条实例
     *
     * @param parking 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteParkingByParam(Parking parking);


    /**
     * 根据主键修改
     *
     * @param parking 列信息
     * @return int 成功数量
     */
    int updateParkingByKey(Parking parking);

    /**
     * 根据主键获取
     *
     * @param parkingId 车位id
     * @return Parking 信息
     */
    Parking getParkingByKey(@Param("parkingId")Integer parkingId);

    /**
     * 根据主键删除
     *
    * @param parkingId 车位id
     * @return int 成功数量
     */
    int deleteParkingByKey(@Param("parkingId")Integer parkingId);

    /**
     * 根据多个主键删除多条
     *
     * @param parkingIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchParkingByKey(List<Integer> parkingIdList);

    /**
     * 根据多个主键获取
     *
     * @param parkingIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Parking> listParkingByKey(List<Integer> parkingIdList);

}
