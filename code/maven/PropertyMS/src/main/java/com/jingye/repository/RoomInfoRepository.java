package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.RoomInfo;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Mapper
public interface RoomInfoRepository {

    /**
     * 增加实例
     *
     * @param roomInfo 实例
     * @return int 成功数量
     */
    int saveRoomInfo(RoomInfo roomInfo);

    /**
     * 增加多条
     *
     * @param roomInfoList 多条列
     * @return int 成功数量
     */
    int saveBatchRoomInfo(List<RoomInfo> roomInfoList);

    /**
     * 获取所有
     *
     * @return List<RoomInfo> 主键集合
     */
    List<RoomInfo> listRoomInfo();

    /**
     * 根据条件获取多条
     *
     * @param roomInfo 列:做条件查询使用
     * @return List<RoomInfo> 列集合
     */
    List<RoomInfo> listRoomInfoByParam(RoomInfo roomInfo);

    /**
     * 根据条件删除多条实例
     *
     * @param roomInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomInfoByParam(RoomInfo roomInfo);


    /**
     * 根据主键修改
     *
     * @param roomInfo 列信息
     * @return int 成功数量
     */
    int updateRoomInfoByKey(RoomInfo roomInfo);

    /**
     * 根据主键获取
     *
     * @param id 
     * @return RoomInfo 信息
     */
    RoomInfo getRoomInfoByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id 
     * @return int 成功数量
     */
    int deleteRoomInfoByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchRoomInfoByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<RoomInfo> listRoomInfoByKey(List<Integer> idList);

}
