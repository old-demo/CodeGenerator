package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.YzInfo;

import java.util.List;
import java.math.BigDecimal;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public interface YzInfoService {

    /**
     * 增加实例
     *
     * @param yzInfo 实例
     * @return int 成功数量
     */
    int saveYzInfo(YzInfo yzInfo);

    /**
     * 增加多条实例
     *
     * @param yzInfoList 多条实例
     * @return int 成功数量
     */
    int saveYzInfo(List<YzInfo> yzInfoList);

    /**
     * 获取所有实例信息
     *
     * @return List<YzInfo> 主键集合
     */
    List<YzInfo> listYzInfo();

    /**
     * 根据条件获取多条实例
     *
     * @param yzInfo 实例:做条件查询使用
     * @return List<YzInfo> 实例集合
     */
    List<YzInfo> listYzInfoByParam(YzInfo yzInfo);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<YzInfo> 实例集合
     */
    PageInfoUtil<YzInfo> listYzInfoByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param yzInfo 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<YzInfo> 实例集合
     */
    PageInfoUtil<YzInfo> listYzInfoByParamAndPage(YzInfo yzInfo, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param yzInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteYzInfoByParam(YzInfo yzInfo);

    /**
     * 修改实例
     *
     * @param yzInfo 实例信息
     * @return int 成功数量
     */
    int updateYzInfoByKey(YzInfo yzInfo);

    /**
     * 批量修改实例
     *
     * @param yzInfoList 多条实例信息
     * @return int 是否成功
     */
    int updateYzInfoByKey(List<YzInfo> yzInfoList);


    /**
     * 根据主键获取实例信息
     *
     * @param yzId  实例
     * @return List<T> 实例信息
     */
    YzInfo getYzInfoByKey(Integer yzId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param yzIdList  实例集合
     * @return List<T> 实例信息
     */
    List<YzInfo> listYzInfoByKey(List<Integer> yzIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param yzId 主键
     * @return int 成功数量
     */
    int deleteYzInfoByKey(Integer yzId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param yzIdList 主键集合
     * @return int 成功数量
     */
    int deleteYzInfoByKey(List<Integer> yzIdList);

}
