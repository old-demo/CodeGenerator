package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.ParkingSpaces;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface ParkingSpacesService {

    /**
     * 增加实例
     *
     * @param parkingSpaces 实例
     * @return int 成功数量
     */
    int saveParkingSpaces(ParkingSpaces parkingSpaces);

    /**
     * 增加多条实例
     *
     * @param parkingSpacesList 多条实例
     * @return int 成功数量
     */
    int saveParkingSpaces(List<ParkingSpaces> parkingSpacesList);

    /**
     * 获取所有实例信息
     *
     * @return List<ParkingSpaces> 主键集合
     */
    List<ParkingSpaces> listParkingSpaces();

    /**
     * 根据条件获取多条实例
     *
     * @param parkingSpaces 实例:做条件查询使用
     * @return List<ParkingSpaces> 实例集合
     */
    List<ParkingSpaces> listParkingSpacesByParam(ParkingSpaces parkingSpaces);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<ParkingSpaces> 实例集合
     */
    PageInfoUtil<ParkingSpaces> listParkingSpacesByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param parkingSpaces 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<ParkingSpaces> 实例集合
     */
    PageInfoUtil<ParkingSpaces> listParkingSpacesByParamAndPage(ParkingSpaces parkingSpaces, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param parkingSpaces 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteParkingSpacesByParam(ParkingSpaces parkingSpaces);

    /**
     * 修改实例
     *
     * @param parkingSpaces 实例信息
     * @return int 成功数量
     */
    int updateParkingSpacesByKey(ParkingSpaces parkingSpaces);

    /**
     * 批量修改实例
     *
     * @param parkingSpacesList 多条实例信息
     * @return int 是否成功
     */
    int updateParkingSpacesByKey(List<ParkingSpaces> parkingSpacesList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    ParkingSpaces getParkingSpacesByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<ParkingSpaces> listParkingSpacesByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteParkingSpacesByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteParkingSpacesByKey(List<Integer> idList);

}
