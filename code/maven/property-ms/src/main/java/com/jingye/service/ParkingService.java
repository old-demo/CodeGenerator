package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Parking;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public interface ParkingService {

    /**
     * 增加实例
     *
     * @param parking 实例
     * @return int 成功数量
     */
    int saveParking(Parking parking);

    /**
     * 增加多条实例
     *
     * @param parkingList 多条实例
     * @return int 成功数量
     */
    int saveParking(List<Parking> parkingList);

    /**
     * 获取所有实例信息
     *
     * @return List<Parking> 主键集合
     */
    List<Parking> listParking();

    /**
     * 根据条件获取多条实例
     *
     * @param parking 实例:做条件查询使用
     * @return List<Parking> 实例集合
     */
    List<Parking> listParkingByParam(Parking parking);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Parking> 实例集合
     */
    PageInfoUtil<Parking> listParkingByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param parking 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Parking> 实例集合
     */
    PageInfoUtil<Parking> listParkingByParamAndPage(Parking parking, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param parking 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteParkingByParam(Parking parking);

    /**
     * 修改实例
     *
     * @param parking 实例信息
     * @return int 成功数量
     */
    int updateParkingByKey(Parking parking);

    /**
     * 批量修改实例
     *
     * @param parkingList 多条实例信息
     * @return int 是否成功
     */
    int updateParkingByKey(List<Parking> parkingList);


    /**
     * 根据主键获取实例信息
     *
     * @param parkingId  实例
     * @return List<T> 实例信息
     */
    Parking getParkingByKey(Integer parkingId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param parkingIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Parking> listParkingByKey(List<Integer> parkingIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param parkingId 主键
     * @return int 成功数量
     */
    int deleteParkingByKey(Integer parkingId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param parkingIdList 主键集合
     * @return int 成功数量
     */
    int deleteParkingByKey(List<Integer> parkingIdList);

}
