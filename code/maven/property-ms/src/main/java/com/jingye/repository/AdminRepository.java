package com.jingye.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.jingye.entity.Admin;

/**
 * 数据持久层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Mapper
public interface AdminRepository {

    /**
     * 增加实例
     *
     * @param admin 实例
     * @return int 成功数量
     */
    int saveAdmin(Admin admin);

    /**
     * 增加多条
     *
     * @param adminList 多条列
     * @return int 成功数量
     */
    int saveBatchAdmin(List<Admin> adminList);

    /**
     * 获取所有
     *
     * @return List<Admin> 主键集合
     */
    List<Admin> listAdmin();

    /**
     * 根据条件获取多条
     *
     * @param admin 列:做条件查询使用
     * @return List<Admin> 列集合
     */
    List<Admin> listAdminByParam(Admin admin);

    /**
     * 根据条件删除多条实例
     *
     * @param admin 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteAdminByParam(Admin admin);


    /**
     * 根据主键修改
     *
     * @param admin 列信息
     * @return int 成功数量
     */
    int updateAdminByKey(Admin admin);

    /**
     * 根据主键获取
     *
     * @param adId 管理员编号
     * @return Admin 信息
     */
    Admin getAdminByKey(@Param("adId")Integer adId);

    /**
     * 根据主键删除
     *
    * @param adId 管理员编号
     * @return int 成功数量
     */
    int deleteAdminByKey(@Param("adId")Integer adId);

    /**
     * 根据多个主键删除多条
     *
     * @param adIdList  列集合
     * @return int 成功数量
     */
    int deleteBatchAdminByKey(List<Integer> adIdList);

    /**
     * 根据多个主键获取
     *
     * @param adIdList 列集合
     * @return List<T> 列实体信息
     */
    List<Admin> listAdminByKey(List<Integer> adIdList);

}
