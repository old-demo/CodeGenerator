package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Owner;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Mapper
public interface OwnerRepository {

    /**
     * 增加实例
     *
     * @param owner 实例
     * @return int 成功数量
     */
    int saveOwner(Owner owner);

    /**
     * 增加多条
     *
     * @param ownerList 多条列
     * @return int 成功数量
     */
    int saveBatchOwner(List<Owner> ownerList);

    /**
     * 获取所有
     *
     * @return List<Owner> 主键集合
     */
    List<Owner> listOwner();

    /**
     * 根据条件获取多条
     *
     * @param owner 列:做条件查询使用
     * @return List<Owner> 列集合
     */
    List<Owner> listOwnerByParam(Owner owner);

    /**
     * 根据条件删除多条实例
     *
     * @param owner 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteOwnerByParam(Owner owner);


    /**
     * 根据主键修改
     *
     * @param owner 列信息
     * @return int 成功数量
     */
    int updateOwnerByKey(Owner owner);

    /**
     * 根据主键获取
     *
     * @param yzId 业主id
     * @return Owner 信息
     */
    Owner getOwnerByKey(@Param("yzId")Integer yzId);

    /**
     * 根据主键删除
     *
    * @param yzId 业主id
     * @return int 成功数量
     */
    int deleteOwnerByKey(@Param("yzId")Integer yzId);

    /**
     * 根据多个主键删除多条
     *
     * @param yzIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchOwnerByKey(List<Integer> yzIdList);

    /**
     * 根据多个主键获取
     *
     * @param yzIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Owner> listOwnerByKey(List<Integer> yzIdList);

}
