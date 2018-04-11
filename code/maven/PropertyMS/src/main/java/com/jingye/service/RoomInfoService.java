package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.RoomInfo;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public interface RoomInfoService {

    /**
     * 增加实例
     *
     * @param roomInfo 实例
     * @return int 成功数量
     */
    int saveRoomInfo(RoomInfo roomInfo);

    /**
     * 增加多条实例
     *
     * @param roomInfoList 多条实例
     * @return int 成功数量
     */
    int saveRoomInfo(List<RoomInfo> roomInfoList);

    /**
     * 获取所有实例信息
     *
     * @return List<RoomInfo> 主键集合
     */
    List<RoomInfo> listRoomInfo();

    /**
     * 根据条件获取多条实例
     *
     * @param roomInfo 实例:做条件查询使用
     * @return List<RoomInfo> 实例集合
     */
    List<RoomInfo> listRoomInfoByParam(RoomInfo roomInfo);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<RoomInfo> 实例集合
     */
    PageInfoUtil<RoomInfo> listRoomInfoByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param roomInfo 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<RoomInfo> 实例集合
     */
    PageInfoUtil<RoomInfo> listRoomInfoByParamAndPage(RoomInfo roomInfo, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param roomInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomInfoByParam(RoomInfo roomInfo);

    /**
     * 修改实例
     *
     * @param roomInfo 实例信息
     * @return int 成功数量
     */
    int updateRoomInfoByKey(RoomInfo roomInfo);

    /**
     * 批量修改实例
     *
     * @param roomInfoList 多条实例信息
     * @return int 是否成功
     */
    int updateRoomInfoByKey(List<RoomInfo> roomInfoList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    RoomInfo getRoomInfoByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<RoomInfo> listRoomInfoByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteRoomInfoByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteRoomInfoByKey(List<Integer> idList);

}
