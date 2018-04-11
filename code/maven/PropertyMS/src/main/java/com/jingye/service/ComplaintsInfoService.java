package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.ComplaintsInfo;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
public interface ComplaintsInfoService {

    /**
     * 增加实例
     *
     * @param complaintsInfo 实例
     * @return int 成功数量
     */
    int saveComplaintsInfo(ComplaintsInfo complaintsInfo);

    /**
     * 增加多条实例
     *
     * @param complaintsInfoList 多条实例
     * @return int 成功数量
     */
    int saveComplaintsInfo(List<ComplaintsInfo> complaintsInfoList);

    /**
     * 获取所有实例信息
     *
     * @return List<ComplaintsInfo> 主键集合
     */
    List<ComplaintsInfo> listComplaintsInfo();

    /**
     * 根据条件获取多条实例
     *
     * @param complaintsInfo 实例:做条件查询使用
     * @return List<ComplaintsInfo> 实例集合
     */
    List<ComplaintsInfo> listComplaintsInfoByParam(ComplaintsInfo complaintsInfo);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<ComplaintsInfo> 实例集合
     */
    PageInfoUtil<ComplaintsInfo> listComplaintsInfoByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param complaintsInfo 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<ComplaintsInfo> 实例集合
     */
    PageInfoUtil<ComplaintsInfo> listComplaintsInfoByParamAndPage(ComplaintsInfo complaintsInfo, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param complaintsInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteComplaintsInfoByParam(ComplaintsInfo complaintsInfo);

    /**
     * 修改实例
     *
     * @param complaintsInfo 实例信息
     * @return int 成功数量
     */
    int updateComplaintsInfoByKey(ComplaintsInfo complaintsInfo);

    /**
     * 批量修改实例
     *
     * @param complaintsInfoList 多条实例信息
     * @return int 是否成功
     */
    int updateComplaintsInfoByKey(List<ComplaintsInfo> complaintsInfoList);


    /**
     * 根据主键获取实例信息
     *
     * @param id  实例
     * @return List<T> 实例信息
     */
    ComplaintsInfo getComplaintsInfoByKey(Integer id);

    /**
     * 根据多个主键获取实例信息
     *
     * @param idList  实例集合
     * @return List<T> 实例信息
     */
    List<ComplaintsInfo> listComplaintsInfoByKey(List<Integer> idList);

    /**
     * 根据主键删除多条实例
     *
     * @param id 主键
     * @return int 成功数量
     */
    int deleteComplaintsInfoByKey(Integer id);

    /**
     * 根据多个主键删除多条实例
     *
     * @param idList 主键集合
     * @return int 成功数量
     */
    int deleteComplaintsInfoByKey(List<Integer> idList);

}
