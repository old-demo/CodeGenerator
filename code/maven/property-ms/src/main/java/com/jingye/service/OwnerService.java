package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Owner;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
public interface OwnerService {

    /**
     * 增加实例
     *
     * @param owner 实例
     * @return int 成功数量
     */
    int saveOwner(Owner owner);

    /**
     * 增加多条实例
     *
     * @param ownerList 多条实例
     * @return int 成功数量
     */
    int saveOwner(List<Owner> ownerList);

    /**
     * 获取所有实例信息
     *
     * @return List<Owner> 主键集合
     */
    List<Owner> listOwner();

    /**
     * 根据条件获取多条实例
     *
     * @param owner 实例:做条件查询使用
     * @return List<Owner> 实例集合
     */
    List<Owner> listOwnerByParam(Owner owner);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Owner> 实例集合
     */
    PageInfoUtil<Owner> listOwnerByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param owner 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Owner> 实例集合
     */
    PageInfoUtil<Owner> listOwnerByParamAndPage(Owner owner, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param owner 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteOwnerByParam(Owner owner);

    /**
     * 修改实例
     *
     * @param owner 实例信息
     * @return int 成功数量
     */
    int updateOwnerByKey(Owner owner);

    /**
     * 批量修改实例
     *
     * @param ownerList 多条实例信息
     * @return int 是否成功
     */
    int updateOwnerByKey(List<Owner> ownerList);


    /**
     * 根据主键获取实例信息
     *
     * @param yzId  实例
     * @return List<T> 实例信息
     */
    Owner getOwnerByKey(Integer yzId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param yzIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Owner> listOwnerByKey(List<Integer> yzIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param yzId 主键
     * @return int 成功数量
     */
    int deleteOwnerByKey(Integer yzId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param yzIdList 主键集合
     * @return int 成功数量
     */
    int deleteOwnerByKey(List<Integer> yzIdList);

}
