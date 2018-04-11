package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.BuildingType;
import com.jingye.repository.BuildingTypeRepository;
import com.jingye.service.BuildingTypeService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("buildingTypeService")
public class BuildingTypeServiceImpl implements BuildingTypeService {

    private static final Logger LOGGER = Logger.getLogger(BuildingTypeServiceImpl.class);

	@Autowired
	private BuildingTypeRepository buildingTypeRepository;

    @Override
    public int saveBuildingType(BuildingType buildingType) {
        if(buildingType == null) {
            LOGGER.error("--> buildingType 不能为null！" );
            return 0;
        }
        if(buildingType.getId() == null) {
            LOGGER.error("--> buildingType id 不能为null！"  + buildingType);
            return 0;
        }
        return buildingTypeRepository.saveBuildingType(buildingType);
    }

    @Override
    public int saveBuildingType(List<BuildingType> buildingTypeList) {
        List<BuildingType> tempbuildingTypeList = new ArrayList<>();
        for(BuildingType buildingType : buildingTypeList) {
            if(buildingType == null) {
                LOGGER.error("--> buildingType 不能为null！" );
                continue;
            }
            if(buildingType.getId() == null) {
                LOGGER.error("--> buildingType id 不能为null！"  + buildingType);
                continue;
            }
            tempbuildingTypeList.add(buildingType);
        }
        return buildingTypeRepository.saveBatchBuildingType(tempbuildingTypeList);
    }

    @Override
    public List<BuildingType> listBuildingType() {
        return buildingTypeRepository.listBuildingType();
    }

    @Override
    public List<BuildingType> listBuildingTypeByParam(BuildingType buildingType) {
        return buildingTypeRepository.listBuildingTypeByParam(buildingType);
    }

    @Override
    public PageInfoUtil<BuildingType> listBuildingTypeByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BuildingType> buildingTypePage = new PageInfo<BuildingType>(buildingTypeRepository.listBuildingType());
        return new PageInfoUtil(buildingTypePage.getList(), pageNum, pageSize, buildingTypePage.getTotal());
    }

    @Override
    public PageInfoUtil<BuildingType> listBuildingTypeByParamAndPage(BuildingType buildingType, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<BuildingType> buildingTypePage = new PageInfo<BuildingType>(buildingTypeRepository.listBuildingTypeByParam(buildingType));
        return new PageInfoUtil(buildingTypePage.getList(), pageNum, pageSize, buildingTypePage.getTotal());
    }

    @Override
    public int deleteBuildingTypeByParam(BuildingType buildingType) {
        return buildingTypeRepository.deleteBuildingTypeByParam(buildingType);
    }

    @Override
    public int updateBuildingTypeByKey(BuildingType buildingType) {
        if(buildingType == null) {
            LOGGER.error("--> buildingType 不能为null！" );
            return 0;
        }
        if(buildingType.getId() == null) {
            LOGGER.error("--> buildingType id 不能为null！"  + buildingType);
            return 0;
        }
        return buildingTypeRepository.updateBuildingTypeByKey(buildingType);
    }

    @Override
    public int updateBuildingTypeByKey(List<BuildingType> buildingTypeList) {
        int successNum = 0;
        for(BuildingType buildingType : buildingTypeList) {
            successNum += updateBuildingTypeByKey(buildingType);
        }
        return successNum;
    }


    @Override
    public BuildingType getBuildingTypeByKey(Integer id) {
        return buildingTypeRepository.getBuildingTypeByKey(id);
    }

    @Override
    public List<BuildingType> listBuildingTypeByKey(List<Integer> idList) {
        return buildingTypeRepository.listBuildingTypeByKey(idList);
    }

    @Override
    public int deleteBuildingTypeByKey(Integer id) {
        return buildingTypeRepository.deleteBuildingTypeByKey(id);
    }

    @Override
    public int deleteBuildingTypeByKey(List<Integer> idList) {
        return  buildingTypeRepository.deleteBatchBuildingTypeByKey(idList);
    }

}
