package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.RoomType;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public interface RoomTypeService {

    /**
     * 增加实例
     *
     * @param roomType 实例
     * @return int 成功数量
     */
    int saveRoomType(RoomType roomType);

    /**
     * 增加多条实例
     *
     * @param roomTypeList 多条实例
     * @return int 成功数量
     */
    int saveRoomType(List<RoomType> roomTypeList);

    /**
     * 获取所有实例信息
     *
     * @return List<RoomType> 主键集合
     */
    List<RoomType> listRoomType();

    /**
     * 根据条件获取多条实例
     *
     * @param roomType 实例:做条件查询使用
     * @return List<RoomType> 实例集合
     */
    List<RoomType> listRoomTypeByParam(RoomType roomType);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<RoomType> 实例集合
     */
    PageInfoUtil<RoomType> listRoomTypeByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param roomType 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<RoomType> 实例集合
     */
    PageInfoUtil<RoomType> listRoomTypeByParamAndPage(RoomType roomType, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param roomType 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteRoomTypeByParam(RoomType roomType);

    /**
     * 修改实例
     *
     * @param roomType 实例信息
     * @return int 成功数量
     */
    int updateRoomTypeByKey(RoomType roomType);

    /**
     * 批量修改实例
     *
     * @param roomTypeList 多条实例信息
     * @return int 是否成功
     */
    int updateRoomTypeByKey(List<RoomType> roomTypeList);


    /**
     * 根据主键获取实例信息
     *
     * @param rtId  实例
     * @return List<T> 实例信息
     */
    RoomType getRoomTypeByKey(Integer rtId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param rtIdList  实例集合
     * @return List<T> 实例信息
     */
    List<RoomType> listRoomTypeByKey(List<Integer> rtIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param rtId 主键
     * @return int 成功数量
     */
    int deleteRoomTypeByKey(Integer rtId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param rtIdList 主键集合
     * @return int 成功数量
     */
    int deleteRoomTypeByKey(List<Integer> rtIdList);

}
