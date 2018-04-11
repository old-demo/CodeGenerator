package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.TemporaryParking;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public interface TemporaryParkingService {

    /**
     * 增加实例
     *
     * @param temporaryParking 实例
     * @return int 成功数量
     */
    int saveTemporaryParking(TemporaryParking temporaryParking);

    /**
     * 增加多条实例
     *
     * @param temporaryParkingList 多条实例
     * @return int 成功数量
     */
    int saveTemporaryParking(List<TemporaryParking> temporaryParkingList);

    /**
     * 获取所有实例信息
     *
     * @return List<TemporaryParking> 主键集合
     */
    List<TemporaryParking> listTemporaryParking();

    /**
     * 根据条件获取多条实例
     *
     * @param temporaryParking 实例:做条件查询使用
     * @return List<TemporaryParking> 实例集合
     */
    List<TemporaryParking> listTemporaryParkingByParam(TemporaryParking temporaryParking);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<TemporaryParking> 实例集合
     */
    PageInfoUtil<TemporaryParking> listTemporaryParkingByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param temporaryParking 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<TemporaryParking> 实例集合
     */
    PageInfoUtil<TemporaryParking> listTemporaryParkingByParamAndPage(TemporaryParking temporaryParking, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param temporaryParking 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteTemporaryParkingByParam(TemporaryParking temporaryParking);

    /**
     * 修改实例
     *
     * @param temporaryParking 实例信息
     * @return int 成功数量
     */
    int updateTemporaryParkingByKey(TemporaryParking temporaryParking);

    /**
     * 批量修改实例
     *
     * @param temporaryParkingList 多条实例信息
     * @return int 是否成功
     */
    int updateTemporaryParkingByKey(List<TemporaryParking> temporaryParkingList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    TemporaryParking getTemporaryParkingByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<TemporaryParking> listTemporaryParkingByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteTemporaryParkingByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteTemporaryParkingByKey(List<Integer> idList);

}
