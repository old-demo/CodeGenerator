package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.TemporaryParking;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Mapper
public interface TemporaryParkingRepository {

    /**
     * 增加实例
     *
     * @param temporaryParking 实例
     * @return int 成功数量
     */
    int saveTemporaryParking(TemporaryParking temporaryParking);

    /**
     * 增加多条
     *
     * @param temporaryParkingList 多条列
     * @return int 成功数量
     */
    int saveBatchTemporaryParking(List<TemporaryParking> temporaryParkingList);

    /**
     * 获取所有
     *
     * @return List<TemporaryParking> 主键集合
     */
    List<TemporaryParking> listTemporaryParking();

    /**
     * 根据条件获取多条
     *
     * @param temporaryParking 列:做条件查询使用
     * @return List<TemporaryParking> 列集合
     */
    List<TemporaryParking> listTemporaryParkingByParam(TemporaryParking temporaryParking);

    /**
     * 根据条件删除多条实例
     *
     * @param temporaryParking 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteTemporaryParkingByParam(TemporaryParking temporaryParking);


    /**
     * 根据主键修改
     *
     * @param temporaryParking 列信息
     * @return int 成功数量
     */
    int updateTemporaryParkingByKey(TemporaryParking temporaryParking);

    /**
     * 根据主键获取
     *
     * @param id Id
     * @return TemporaryParking 信息
     */
    TemporaryParking getTemporaryParkingByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id Id
     * @return int 成功数量
     */
    int deleteTemporaryParkingByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchTemporaryParkingByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<TemporaryParking> listTemporaryParkingByKey(List<Integer> idList);

}
