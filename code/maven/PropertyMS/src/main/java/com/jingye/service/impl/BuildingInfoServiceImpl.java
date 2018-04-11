package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.BuildingInfo;
import com.jingye.repository.BuildingInfoRepository;
import com.jingye.service.BuildingInfoService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("buildingInfoService")
public class BuildingInfoServiceImpl implements BuildingInfoService {

    private static final Logger LOGGER = Logger.getLogger(BuildingInfoServiceImpl.class);

	@Autowired
	private BuildingInfoRepository buildingInfoRepository;

    @Override
    public int saveBuildingInfo(BuildingInfo buildingInfo) {
        if(buildingInfo == null) {
            LOGGER.error("--> buildingInfo 不能为null！" );
            return 0;
        }
        if(buildingInfo.getId() == null) {
            LOGGER.error("--> buildingInfo id 不能为null！"  + buildingInfo);
            return 0;
        }
        return buildingInfoRepository.saveBuildingInfo(buildingInfo);
    }

    @Override
    public int saveBuildingInfo(List<BuildingInfo> buildingInfoList) {
        List<BuildingInfo> tempbuildingInfoList = new ArrayList<>();
        for(BuildingInfo buildingInfo : buildingInfoList) {
            if(buildingInfo == null) {
                LOGGER.error("--> buildingInfo 不能为null！" );
                continue;
            }
            if(buildingInfo.getId() == null) {
                LOGGER.error("--> buildingInfo id 不能为null！"  + buildingInfo);
                continue;
            }
            tempbuildingInfoList.add(buildingInfo);
        }
        return buildingInfoRepository.saveBatchBuildingInfo(tempbuildingInfoList);
    }

    @Override
    public List<BuildingInfo> listBuildingInfo() {
        return buildingInfoRepository.listBuildingInfo();
    }

    @Override
    public List<BuildingInfo> listBuildingInfoByParam(BuildingInfo buildingInfo) {
        return buildingInfoRepository.listBuildingInfoByParam(buildingInfo);
    }

    @Override
    public PageInfoUtil<BuildingInfo> listBuildingInfoByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BuildingInfo> buildingInfoPage = new PageInfo<BuildingInfo>(buildingInfoRepository.listBuildingInfo());
        return new PageInfoUtil(buildingInfoPage.getList(), pageNum, pageSize, buildingInfoPage.getTotal());
    }

    @Override
    public PageInfoUtil<BuildingInfo> listBuildingInfoByParamAndPage(BuildingInfo buildingInfo, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BuildingInfo> buildingInfoPage = new PageInfo<BuildingInfo>(buildingInfoRepository.listBuildingInfoByParam(buildingInfo));
        return new PageInfoUtil(buildingInfoPage.getList(), pageNum, pageSize, buildingInfoPage.getTotal());
    }

    @Override
    public int deleteBuildingInfoByParam(BuildingInfo buildingInfo) {
        return buildingInfoRepository.deleteBuildingInfoByParam(buildingInfo);
    }

    @Override
    public int updateBuildingInfoByKey(BuildingInfo buildingInfo) {
        if(buildingInfo == null) {
            LOGGER.error("--> buildingInfo 不能为null！" );
            return 0;
        }
        if(buildingInfo.getId() == null) {
            LOGGER.error("--> buildingInfo id 不能为null！"  + buildingInfo);
            return 0;
        }
        return buildingInfoRepository.updateBuildingInfoByKey(buildingInfo);
    }

    @Override
    public int updateBuildingInfoByKey(List<BuildingInfo> buildingInfoList) {
        int successNum = 0;
        for(BuildingInfo buildingInfo : buildingInfoList) {
            successNum += updateBuildingInfoByKey(buildingInfo);
        }
        return successNum;
    }


    @Override
    public BuildingInfo getBuildingInfoByKey(Integer id) {
        return buildingInfoRepository.getBuildingInfoByKey(id);
    }

    @Override
    public List<BuildingInfo> listBuildingInfoByKey(List<Integer> idList) {
        return buildingInfoRepository.listBuildingInfoByKey(idList);
    }

    @Override
    public int deleteBuildingInfoByKey(Integer id) {
        return buildingInfoRepository.deleteBuildingInfoByKey(id);
    }

    @Override
    public int deleteBuildingInfoByKey(List<Integer> idList) {
        return  buildingInfoRepository.deleteBatchBuildingInfoByKey(idList);
    }

}
