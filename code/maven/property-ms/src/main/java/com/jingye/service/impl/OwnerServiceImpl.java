package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Owner;
import com.jingye.repository.OwnerRepository;
import com.jingye.service.OwnerService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

    private static final Logger LOGGER = Logger.getLogger(OwnerServiceImpl.class);

	@Autowired
	private OwnerRepository ownerRepository;

    @Override
    public int saveOwner(Owner owner) {
        if(owner == null) {
            LOGGER.error("--> owner 不能为null！" );
            return 0;
        }
        if(owner.getYzSex() == null) {
            LOGGER.error("--> owner 业主性别 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzId() == null) {
            LOGGER.error("--> owner 业主id 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzName() == null) {
            LOGGER.error("--> owner 业主姓名 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzPhone() == null) {
            LOGGER.error("--> owner 联系方式 不能为null！"  + owner);
            return 0;
        }
        return ownerRepository.saveOwner(owner);
    }

    @Override
    public int saveOwner(List<Owner> ownerList) {
        List<Owner> tempownerList = new ArrayList<>();
        for(Owner owner : ownerList) {
            if(owner == null) {
                LOGGER.error("--> owner 不能为null！" );
                continue;
            }
            if(owner.getYzSex() == null) {
                LOGGER.error("--> owner 业主性别 不能为null！"  + owner);
                continue;
            }
            if(owner.getYzId() == null) {
                LOGGER.error("--> owner 业主id 不能为null！"  + owner);
                continue;
            }
            if(owner.getYzName() == null) {
                LOGGER.error("--> owner 业主姓名 不能为null！"  + owner);
                continue;
            }
            if(owner.getYzPhone() == null) {
                LOGGER.error("--> owner 联系方式 不能为null！"  + owner);
                continue;
            }
            tempownerList.add(owner);
        }
        return ownerRepository.saveBatchOwner(tempownerList);
    }

    @Override
    public List<Owner> listOwner() {
        return ownerRepository.listOwner();
    }

    @Override
    public List<Owner> listOwnerByParam(Owner owner) {
        return ownerRepository.listOwnerByParam(owner);
    }

    @Override
    public PageInfoUtil<Owner> listOwnerByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Owner> ownerPage = new PageInfo<Owner>(ownerRepository.listOwner());
        return new PageInfoUtil(ownerPage.getList(), pageNum, pageSize, ownerPage.getTotal());
    }

    @Override
    public PageInfoUtil<Owner> listOwnerByParamAndPage(Owner owner, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Owner> ownerPage = new PageInfo<Owner>(ownerRepository.listOwnerByParam(owner));
        return new PageInfoUtil(ownerPage.getList(), pageNum, pageSize, ownerPage.getTotal());
    }

    @Override
    public int deleteOwnerByParam(Owner owner) {
        return ownerRepository.deleteOwnerByParam(owner);
    }

    @Override
    public int updateOwnerByKey(Owner owner) {
        if(owner == null) {
            LOGGER.error("--> owner 不能为null！" );
            return 0;
        }
        if(owner.getYzSex() == null) {
            LOGGER.error("--> owner 业主性别 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzId() == null) {
            LOGGER.error("--> owner 业主id 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzName() == null) {
            LOGGER.error("--> owner 业主姓名 不能为null！"  + owner);
            return 0;
        }
        if(owner.getYzPhone() == null) {
            LOGGER.error("--> owner 联系方式 不能为null！"  + owner);
            return 0;
        }
        return ownerRepository.updateOwnerByKey(owner);
    }

    @Override
    public int updateOwnerByKey(List<Owner> ownerList) {
        int successNum = 0;
        for(Owner owner : ownerList) {
            successNum += updateOwnerByKey(owner);
        }
        return successNum;
    }


    @Override
    public Owner getOwnerByKey(Integer yzId) {
        return ownerRepository.getOwnerByKey(yzId);
    }

    @Override
    public List<Owner> listOwnerByKey(List<Integer> yzIdList) {
        return ownerRepository.listOwnerByKey(yzIdList);
    }

    @Override
    public int deleteOwnerByKey(Integer yzId) {
        return ownerRepository.deleteOwnerByKey(yzId);
    }

    @Override
    public int deleteOwnerByKey(List<Integer> yzIdList) {
        return  ownerRepository.deleteBatchOwnerByKey(yzIdList);
    }

}
