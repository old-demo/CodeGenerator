package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Room;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public interface RoomService {

    /**
     * 增加实例
     *
     * @param room 实例
     * @return int 成功数量
     */
    int saveRoom(Room room);

    /**
     * 增加多条实例
     *
     * @param roomList 多条实例
     * @return int 成功数量
     */
    int saveRoom(List<Room> roomList);

    /**
     * 获取所有实例信息
     *
     * @return List<Room> 主键集合
     */
    List<Room> listRoom();

    /**
     * 根据条件获取多条实例
     *
     * @param room 实例:做条件查询使用
     * @return List<Room> 实例集合
     */
    List<Room> listRoomByParam(Room room);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Room> 实例集合
     */
    PageInfoUtil<Room> listRoomByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param room 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Room> 实例集合
     */
    PageInfoUtil<Room> listRoomByParamAndPage(Room room, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param room 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomByParam(Room room);

    /**
     * 修改实例
     *
     * @param room 实例信息
     * @return int 成功数量
     */
    int updateRoomByKey(Room room);

    /**
     * 批量修改实例
     *
     * @param roomList 多条实例信息
     * @return int 是否成功
     */
    int updateRoomByKey(List<Room> roomList);


    /**
     * 根据主键获取实例信息
     *
     * @param roomId  实例
     * @return List<T> 实例信息
     */
    Room getRoomByKey(Integer roomId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param roomIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Room> listRoomByKey(List<Integer> roomIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param roomId 主键
     * @return int 成功数量
     */
    int deleteRoomByKey(Integer roomId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param roomIdList 主键集合
     * @return int 成功数量
     */
    int deleteRoomByKey(List<Integer> roomIdList);

}
