package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.ComplaintsInfo;
import com.jingye.repository.ComplaintsInfoRepository;
import com.jingye.service.ComplaintsInfoService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("complaintsInfoService")
public class ComplaintsInfoServiceImpl implements ComplaintsInfoService {

    private static final Logger LOGGER = Logger.getLogger(ComplaintsInfoServiceImpl.class);

	@Autowired
	private ComplaintsInfoRepository complaintsInfoRepository;

    @Override
    public int saveComplaintsInfo(ComplaintsInfo complaintsInfo) {
        if(complaintsInfo == null) {
            LOGGER.error("--> complaintsInfo 不能为null！" );
            return 0;
        }
        if(complaintsInfo.getId() == null) {
            LOGGER.error("--> complaintsInfo id 不能为null！"  + complaintsInfo);
            return 0;
        }
        return complaintsInfoRepository.saveComplaintsInfo(complaintsInfo);
    }

    @Override
    public int saveComplaintsInfo(List<ComplaintsInfo> complaintsInfoList) {
        List<ComplaintsInfo> tempcomplaintsInfoList = new ArrayList<>();
        for(ComplaintsInfo complaintsInfo : complaintsInfoList) {
            if(complaintsInfo == null) {
                LOGGER.error("--> complaintsInfo 不能为null！" );
                continue;
            }
            if(complaintsInfo.getId() == null) {
                LOGGER.error("--> complaintsInfo id 不能为null！"  + complaintsInfo);
                continue;
            }
            tempcomplaintsInfoList.add(complaintsInfo);
        }
        return complaintsInfoRepository.saveBatchComplaintsInfo(tempcomplaintsInfoList);
    }

    @Override
    public List<ComplaintsInfo> listComplaintsInfo() {
        return complaintsInfoRepository.listComplaintsInfo();
    }

    @Override
    public List<ComplaintsInfo> listComplaintsInfoByParam(ComplaintsInfo complaintsInfo) {
        return complaintsInfoRepository.listComplaintsInfoByParam(complaintsInfo);
    }

    @Override
    public PageInfoUtil<ComplaintsInfo> listComplaintsInfoByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ComplaintsInfo> complaintsInfoPage = new PageInfo<ComplaintsInfo>(complaintsInfoRepository.listComplaintsInfo());
        return new PageInfoUtil(complaintsInfoPage.getList(), pageNum, pageSize, complaintsInfoPage.getTotal());
    }

    @Override
    public PageInfoUtil<ComplaintsInfo> listComplaintsInfoByParamAndPage(ComplaintsInfo complaintsInfo, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ComplaintsInfo> complaintsInfoPage = new PageInfo<ComplaintsInfo>(complaintsInfoRepository.listComplaintsInfoByParam(complaintsInfo));
        return new PageInfoUtil(complaintsInfoPage.getList(), pageNum, pageSize, complaintsInfoPage.getTotal());
    }

    @Override
    public int deleteComplaintsInfoByParam(ComplaintsInfo complaintsInfo) {
        return complaintsInfoRepository.deleteComplaintsInfoByParam(complaintsInfo);
    }

    @Override
    public int updateComplaintsInfoByKey(ComplaintsInfo complaintsInfo) {
        if(complaintsInfo == null) {
            LOGGER.error("--> complaintsInfo 不能为null！" );
            return 0;
        }
        if(complaintsInfo.getId() == null) {
            LOGGER.error("--> complaintsInfo id 不能为null！"  + complaintsInfo);
            return 0;
        }
        return complaintsInfoRepository.updateComplaintsInfoByKey(complaintsInfo);
    }

    @Override
    public int updateComplaintsInfoByKey(List<ComplaintsInfo> complaintsInfoList) {
        int successNum = 0;
        for(ComplaintsInfo complaintsInfo : complaintsInfoList) {
            successNum += updateComplaintsInfoByKey(complaintsInfo);
        }
        return successNum;
    }


    @Override
    public ComplaintsInfo getComplaintsInfoByKey(Integer id) {
        return complaintsInfoRepository.getComplaintsInfoByKey(id);
    }

    @Override
    public List<ComplaintsInfo> listComplaintsInfoByKey(List<Integer> idList) {
        return complaintsInfoRepository.listComplaintsInfoByKey(idList);
    }

    @Override
    public int deleteComplaintsInfoByKey(Integer id) {
        return complaintsInfoRepository.deleteComplaintsInfoByKey(id);
    }

    @Override
    public int deleteComplaintsInfoByKey(List<Integer> idList) {
        return  complaintsInfoRepository.deleteBatchComplaintsInfoByKey(idList);
    }

}
