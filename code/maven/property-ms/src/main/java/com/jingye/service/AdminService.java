package com.jingye.service;

import com.jingye.util.PageInfoUtil;
import com.jingye.entity.Admin;

import java.util.List;

/**
 * 业务逻辑层接口
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
public interface AdminService {

    /**
     * 增加实例
     *
     * @param admin 实例
     * @return int 成功数量
     */
    int saveAdmin(Admin admin);

    /**
     * 增加多条实例
     *
     * @param adminList 多条实例
     * @return int 成功数量
     */
    int saveAdmin(List<Admin> adminList);

    /**
     * 获取所有实例信息
     *
     * @return List<Admin> 主键集合
     */
    List<Admin> listAdmin();

    /**
     * 根据条件获取多条实例
     *
     * @param admin 实例:做条件查询使用
     * @return List<Admin> 实例集合
     */
    List<Admin> listAdminByParam(Admin admin);

    /**
     * 根据分页获取多条实例
     *
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Admin> 实例集合
     */
    PageInfoUtil<Admin> listAdminByPage(int pageNum, int pageSize);

    /**
     * 根据分页及条件获取多条实例
     *
     * @param admin 实例:做条件查询使用
     * @param pageNum 第几页
     * @param pageSize 每页数量
     * @return Page<Admin> 实例集合
     */
    PageInfoUtil<Admin> listAdminByParamAndPage(Admin admin, int pageNum, int pageSize);

    /**
     * 根据条件删除多条实例
     *
     * @param admin 实例:做条件删除使用
     * @return int 成功数量
     */
    int deleteAdminByParam(Admin admin);

    /**
     * 修改实例
     *
     * @param admin 实例信息
     * @return int 成功数量
     */
    int updateAdminByKey(Admin admin);

    /**
     * 批量修改实例
     *
     * @param adminList 多条实例信息
     * @return int 是否成功
     */
    int updateAdminByKey(List<Admin> adminList);


    /**
     * 根据主键获取实例信息
     *
     * @param adId  实例
     * @return List<T> 实例信息
     */
    Admin getAdminByKey(Integer adId);

    /**
     * 根据多个主键获取实例信息
     *
     * @param adIdList  实例集合
     * @return List<T> 实例信息
     */
    List<Admin> listAdminByKey(List<Integer> adIdList);

    /**
     * 根据主键删除多条实例
     *
     * @param adId 主键
     * @return int 成功数量
     */
    int deleteAdminByKey(Integer adId);

    /**
     * 根据多个主键删除多条实例
     *
     * @param adIdList 主键集合
     * @return int 成功数量
     */
    int deleteAdminByKey(List<Integer> adIdList);

}
