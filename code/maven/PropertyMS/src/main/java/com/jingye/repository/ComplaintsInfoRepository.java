package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.math.BigDecimal;

import com.jingye.entity.ComplaintsInfo;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Mapper
public interface ComplaintsInfoRepository {

    /**
     * 增加实例
     *
     * @param complaintsInfo 实例
     * @return int 成功数量
     */
    int saveComplaintsInfo(ComplaintsInfo complaintsInfo);

    /**
     * 增加多条
     *
     * @param complaintsInfoList 多条列
     * @return int 成功数量
     */
    int saveBatchComplaintsInfo(List<ComplaintsInfo> complaintsInfoList);

    /**
     * 获取所有
     *
     * @return List<ComplaintsInfo> 主键集合
     */
    List<ComplaintsInfo> listComplaintsInfo();

    /**
     * 根据条件获取多条
     *
     * @param complaintsInfo 列:做条件查询使用
     * @return List<ComplaintsInfo> 列集合
     */
    List<ComplaintsInfo> listComplaintsInfoByParam(ComplaintsInfo complaintsInfo);

    /**
     * 根据条件删除多条实例
     *
     * @param complaintsInfo 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteComplaintsInfoByParam(ComplaintsInfo complaintsInfo);


    /**
     * 根据主键修改
     *
     * @param complaintsInfo 列信息
     * @return int 成功数量
     */
    int updateComplaintsInfoByKey(ComplaintsInfo complaintsInfo);

    /**
     * 根据主键获取
     *
     * @param id id
     * @return ComplaintsInfo 信息
     */
    ComplaintsInfo getComplaintsInfoByKey(@Param("id")Integer id);

    /**
     * 根据主键删除
     *
    * @param id id
     * @return int 成功数量
     */
    int deleteComplaintsInfoByKey(@Param("id")Integer id);

    /**
     * 根据多个主键删除多条
     *
     * @param idList  列集合
     * @return int 成功数量
     */
    int deleteBatchComplaintsInfoByKey(List<Integer> idList);

    /**
     * 根据多个主键获取
     *
     * @param idList 列集合
     * @return List<T> 列实体信息
     */
    List<ComplaintsInfo> listComplaintsInfoByKey(List<Integer> idList);

}
