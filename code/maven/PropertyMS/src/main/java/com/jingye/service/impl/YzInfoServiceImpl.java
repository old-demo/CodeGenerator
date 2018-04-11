package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.YzInfo;
import com.jingye.repository.YzInfoRepository;
import com.jingye.service.YzInfoService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Service("yzInfoService")
public class YzInfoServiceImpl implements YzInfoService {

    private static final Logger LOGGER = Logger.getLogger(YzInfoServiceImpl.class);

	@Autowired
	private YzInfoRepository yzInfoRepository;

    @Override
    public int saveYzInfo(YzInfo yzInfo) {
        if(yzInfo == null) {
            LOGGER.error("--> yzInfo 不能为null！" );
            return 0;
        }
        if(yzInfo.getYzName() == null) {
            LOGGER.error("--> yzInfo 姓名 不能为null！"  + yzInfo);
            return 0;
        }
        if(yzInfo.getYzTel() == null) {
            LOGGER.error("--> yzInfo 联系电话 不能为null！"  + yzInfo);
            return 0;
        }
        return yzInfoRepository.saveYzInfo(yzInfo);
    }

    @Override
    public int saveYzInfo(List<YzInfo> yzInfoList) {
        List<YzInfo> tempyzInfoList = new ArrayList<>();
        for(YzInfo yzInfo : yzInfoList) {
            if(yzInfo == null) {
                LOGGER.error("--> yzInfo 不能为null！" );
                continue;
            }
            if(yzInfo.getYzName() == null) {
                LOGGER.error("--> yzInfo 姓名 不能为null！"  + yzInfo);
                continue;
            }
            if(yzInfo.getYzTel() == null) {
                LOGGER.error("--> yzInfo 联系电话 不能为null！"  + yzInfo);
                continue;
            }
            tempyzInfoList.add(yzInfo);
        }
        return yzInfoRepository.saveBatchYzInfo(tempyzInfoList);
    }

    @Override
    public List<YzInfo> listYzInfo() {
        return yzInfoRepository.listYzInfo();
    }

    @Override
    public List<YzInfo> listYzInfoByParam(YzInfo yzInfo) {
        return yzInfoRepository.listYzInfoByParam(yzInfo);
    }

    @Override
    public PageInfoUtil<YzInfo> listYzInfoByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<YzInfo> yzInfoPage = new PageInfo<YzInfo>(yzInfoRepository.listYzInfo());
        return new PageInfoUtil(yzInfoPage.getList(), pageNum, pageSize, yzInfoPage.getTotal());
    }

    @Override
    public PageInfoUtil<YzInfo> listYzInfoByParamAndPage(YzInfo yzInfo, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<YzInfo> yzInfoPage = new PageInfo<YzInfo>(yzInfoRepository.listYzInfoByParam(yzInfo));
        return new PageInfoUtil(yzInfoPage.getList(), pageNum, pageSize, yzInfoPage.getTotal());
    }

    @Override
    public int deleteYzInfoByParam(YzInfo yzInfo) {
        return yzInfoRepository.deleteYzInfoByParam(yzInfo);
    }

    @Override
    public int updateYzInfoByKey(YzInfo yzInfo) {
        if(yzInfo == null) {
            LOGGER.error("--> yzInfo 不能为null！" );
            return 0;
        }
        if(yzInfo.getYzName() == null) {
            LOGGER.error("--> yzInfo 姓名 不能为null！"  + yzInfo);
            return 0;
        }
        if(yzInfo.getYzTel() == null) {
            LOGGER.error("--> yzInfo 联系电话 不能为null！"  + yzInfo);
            return 0;
        }
        return yzInfoRepository.updateYzInfoByKey(yzInfo);
    }

    @Override
    public int updateYzInfoByKey(List<YzInfo> yzInfoList) {
        int successNum = 0;
        for(YzInfo yzInfo : yzInfoList) {
            successNum += updateYzInfoByKey(yzInfo);
        }
        return successNum;
    }


    @Override
    public YzInfo getYzInfoByKey(Integer yzId) {
        return yzInfoRepository.getYzInfoByKey(yzId);
    }

    @Override
    public List<YzInfo> listYzInfoByKey(List<Integer> yzIdList) {
        return yzInfoRepository.listYzInfoByKey(yzIdList);
    }

    @Override
    public int deleteYzInfoByKey(Integer yzId) {
        return yzInfoRepository.deleteYzInfoByKey(yzId);
    }

    @Override
    public int deleteYzInfoByKey(List<Integer> yzIdList) {
        return  yzInfoRepository.deleteBatchYzInfoByKey(yzIdList);
    }

}
