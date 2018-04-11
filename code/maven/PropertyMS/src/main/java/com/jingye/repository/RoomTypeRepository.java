package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.RoomType;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Mapper
public interface RoomTypeRepository {

    /**
     * 增加实例
     *
     * @param roomType 实例
     * @return int 成功数量
     */
    int saveRoomType(RoomType roomType);

    /**
     * 增加多条
     *
     * @param roomTypeList 多条列
     * @return int 成功数量
     */
    int saveBatchRoomType(List<RoomType> roomTypeList);

    /**
     * 获取所有
     *
     * @return List<RoomType> 主键集合
     */
    List<RoomType> listRoomType();

    /**
     * 根据条件获取多条
     *
     * @param roomType 列:做条件查询使用
     * @return List<RoomType> 列集合
     */
    List<RoomType> listRoomTypeByParam(RoomType roomType);

    /**
     * 根据条件删除多条实例
     *
     * @param roomType 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomTypeByParam(RoomType roomType);


    /**
     * 根据主键修改
     *
     * @param roomType 列信息
     * @return int 成功数量
     */
    int updateRoomTypeByKey(RoomType roomType);

    /**
     * 根据主键获取
     *
     * @param rtId 房型id
     * @return RoomType 信息
     */
    RoomType getRoomTypeByKey(@Param("rtId")Integer rtId);

    /**
     * 根据主键删除
     *
    * @param rtId 房型id
     * @return int 成功数量
     */
    int deleteRoomTypeByKey(@Param("rtId")Integer rtId);

    /**
     * 根据多个主键删除多条
     *
     * @param rtIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchRoomTypeByKey(List<Integer> rtIdList);

    /**
     * 根据多个主键获取
     *
     * @param rtIdList 列集合
     * @return List<T> 列实体信息
     */
    List<RoomType> listRoomTypeByKey(List<Integer> rtIdList);

}
