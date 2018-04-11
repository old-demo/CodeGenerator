package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.YzInfo;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Mapper
public interface YzInfoRepository {

    /**
     * 增加实例
     *
     * @param yzInfo 实例
     * @return int 成功数量
     */
    int saveYzInfo(YzInfo yzInfo);

    /**
     * 增加多条
     *
     * @param yzInfoList 多条列
     * @return int 成功数量
     */
    int saveBatchYzInfo(List<YzInfo> yzInfoList);

    /**
     * 获取所有
     *
     * @return List<YzInfo> 主键集合
     */
    List<YzInfo> listYzInfo();

    /**
     * 根据条件获取多条
     *
     * @param yzInfo 列:做条件查询使用
     * @return List<YzInfo> 列集合
     */
    List<YzInfo> listYzInfoByParam(YzInfo yzInfo);

    /**
     * 根据条件删除多条实例
     *
     * @param yzInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteYzInfoByParam(YzInfo yzInfo);


    /**
     * 根据主键修改
     *
     * @param yzInfo 列信息
     * @return int 成功数量
     */
    int updateYzInfoByKey(YzInfo yzInfo);

    /**
     * 根据主键获取
     *
     * @param yzId 业主id
     * @return YzInfo 信息
     */
    YzInfo getYzInfoByKey(@Param("yzId")Integer yzId);

    /**
     * 根据主键删除
     *
    * @param yzId 业主id
     * @return int 成功数量
     */
    int deleteYzInfoByKey(@Param("yzId")Integer yzId);

    /**
     * 根据多个主键删除多条
     *
     * @param yzIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchYzInfoByKey(List<Integer> yzIdList);

    /**
     * 根据多个主键获取
     *
     * @param yzIdList 列集合
     * @return List<T> 列实体信息
     */
    List<YzInfo> listYzInfoByKey(List<Integer> yzIdList);

}
