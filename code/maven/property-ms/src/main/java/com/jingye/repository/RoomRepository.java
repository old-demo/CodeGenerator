package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Room;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Mapper
public interface RoomRepository {

    /**
     * 增加实例
     *
     * @param room 实例
     * @return int 成功数量
     */
    int saveRoom(Room room);

    /**
     * 增加多条
     *
     * @param roomList 多条列
     * @return int 成功数量
     */
    int saveBatchRoom(List<Room> roomList);

    /**
     * 获取所有
     *
     * @return List<Room> 主键集合
     */
    List<Room> listRoom();

    /**
     * 根据条件获取多条
     *
     * @param room 列:做条件查询使用
     * @return List<Room> 列集合
     */
    List<Room> listRoomByParam(Room room);

    /**
     * 根据条件删除多条实例
     *
     * @param room 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomByParam(Room room);


    /**
     * 根据主键修改
     *
     * @param room 列信息
     * @return int 成功数量
     */
    int updateRoomByKey(Room room);

    /**
     * 根据主键获取
     *
     * @param roomId 房间号
     * @return Room 信息
     */
    Room getRoomByKey(@Param("roomId")Integer roomId);

    /**
     * 根据主键删除
     *
    * @param roomId 房间号
     * @return int 成功数量
     */
    int deleteRoomByKey(@Param("roomId")Integer roomId);

    /**
     * 根据多个主键删除多条
     *
     * @param roomIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchRoomByKey(List<Integer> roomIdList);

    /**
     * 根据多个主键获取
     *
     * @param roomIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Room> listRoomByKey(List<Integer> roomIdList);

}
