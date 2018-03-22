package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Admin;
import com.jingye.repository.AdminRepository;
import com.jingye.service.AdminService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = Logger.getLogger(AdminServiceImpl.class);

	@Autowired
	private AdminRepository adminRepository;

    @Override
    public int saveAdmin(Admin admin) {
        if(admin == null) {
            LOGGER.error("--> admin 不能为null！" );
            return 0;
        }
        if(admin.getAdName() == null) {
            LOGGER.error("--> admin 管理员姓名 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdSex() == null) {
            LOGGER.error("--> admin 管理员性别 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdAge() == null) {
            LOGGER.error("--> admin 年龄 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdId() == null) {
            LOGGER.error("--> admin 管理员编号 不能为null！"  + admin);
            return 0;
        }
        return adminRepository.saveAdmin(admin);
    }

    @Override
    public int saveAdmin(List<Admin> adminList) {
        List<Admin> tempadminList = new ArrayList<>();
        for(Admin admin : adminList) {
            if(admin == null) {
                LOGGER.error("--> admin 不能为null！" );
                continue;
            }
            if(admin.getAdName() == null) {
                LOGGER.error("--> admin 管理员姓名 不能为null！"  + admin);
                continue;
            }
            if(admin.getAdSex() == null) {
                LOGGER.error("--> admin 管理员性别 不能为null！"  + admin);
                continue;
            }
            if(admin.getAdAge() == null) {
                LOGGER.error("--> admin 年龄 不能为null！"  + admin);
                continue;
            }
            if(admin.getAdId() == null) {
                LOGGER.error("--> admin 管理员编号 不能为null！"  + admin);
                continue;
            }
            tempadminList.add(admin);
        }
        return adminRepository.saveBatchAdmin(tempadminList);
    }

    @Override
    public List<Admin> listAdmin() {
        return adminRepository.listAdmin();
    }

    @Override
    public List<Admin> listAdminByParam(Admin admin) {
        return adminRepository.listAdminByParam(admin);
    }

    @Override
    public PageInfoUtil<Admin> listAdminByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Admin> adminPage = new PageInfo<Admin>(adminRepository.listAdmin());
        return new PageInfoUtil(adminPage.getList(), pageNum, pageSize, adminPage.getTotal());
    }

    @Override
    public PageInfoUtil<Admin> listAdminByParamAndPage(Admin admin, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Admin> adminPage = new PageInfo<Admin>(adminRepository.listAdminByParam(admin));
        return new PageInfoUtil(adminPage.getList(), pageNum, pageSize, adminPage.getTotal());
    }

    @Override
    public int deleteAdminByParam(Admin admin) {
        return adminRepository.deleteAdminByParam(admin);
    }

    @Override
    public int updateAdminByKey(Admin admin) {
        if(admin == null) {
            LOGGER.error("--> admin 不能为null！" );
            return 0;
        }
        if(admin.getAdName() == null) {
            LOGGER.error("--> admin 管理员姓名 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdSex() == null) {
            LOGGER.error("--> admin 管理员性别 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdAge() == null) {
            LOGGER.error("--> admin 年龄 不能为null！"  + admin);
            return 0;
        }
        if(admin.getAdId() == null) {
            LOGGER.error("--> admin 管理员编号 不能为null！"  + admin);
            return 0;
        }
        return adminRepository.updateAdminByKey(admin);
    }

    @Override
    public int updateAdminByKey(List<Admin> adminList) {
        int successNum = 0;
        for(Admin admin : adminList) {
            successNum += updateAdminByKey(admin);
        }
        return successNum;
    }


    @Override
    public Admin getAdminByKey(Integer adId) {
        return adminRepository.getAdminByKey(adId);
    }

    @Override
    public List<Admin> listAdminByKey(List<Integer> adIdList) {
        return adminRepository.listAdminByKey(adIdList);
    }

    @Override
    public int deleteAdminByKey(Integer adId) {
        return adminRepository.deleteAdminByKey(adId);
    }

    @Override
    public int deleteAdminByKey(List<Integer> adIdList) {
        return  adminRepository.deleteBatchAdminByKey(adIdList);
    }

}
