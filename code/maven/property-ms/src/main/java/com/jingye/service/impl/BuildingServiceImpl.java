package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Building;
import com.jingye.repository.BuildingRepository;
import com.jingye.service.BuildingService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:09
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {

    private static final Logger LOGGER = Logger.getLogger(BuildingServiceImpl.class);

	@Autowired
	private BuildingRepository buildingRepository;

    @Override
    public int saveBuilding(Building building) {
        if(building == null) {
            LOGGER.error("--> building 不能为null！" );
            return 0;
        }
        if(building.getBuildingHead() == null) {
            LOGGER.error("--> building 朝向 不能为null！"  + building);
            return 0;
        }
        if(building.getBulidingArea() == null) {
            LOGGER.error("--> building 面积 不能为null！"  + building);
            return 0;
        }
        if(building.getBuildingKind() == null) {
            LOGGER.error("--> building 类型 不能为null！"  + building);
            return 0;
        }
        if(building.getBuildingId() == null) {
            LOGGER.error("--> building 大楼编号 不能为null！"  + building);
            return 0;
        }
        if(building.getBulidingLevel() == null) {
            LOGGER.error("--> building 层数 不能为null！"  + building);
            return 0;
        }
        return buildingRepository.saveBuilding(building);
    }

    @Override
    public int saveBuilding(List<Building> buildingList) {
        List<Building> tempbuildingList = new ArrayList<>();
        for(Building building : buildingList) {
            if(building == null) {
                LOGGER.error("--> building 不能为null！" );
                continue;
            }
            if(building.getBuildingHead() == null) {
                LOGGER.error("--> building 朝向 不能为null！"  + building);
                continue;
            }
            if(building.getBulidingArea() == null) {
                LOGGER.error("--> building 面积 不能为null！"  + building);
                continue;
            }
            if(building.getBuildingKind() == null) {
                LOGGER.error("--> building 类型 不能为null！"  + building);
                continue;
            }
            if(building.getBuildingId() == null) {
                LOGGER.error("--> building 大楼编号 不能为null！"  + building);
                continue;
            }
            if(building.getBulidingLevel() == null) {
                LOGGER.error("--> building 层数 不能为null！"  + building);
                continue;
            }
            tempbuildingList.add(building);
        }
        return buildingRepository.saveBatchBuilding(tempbuildingList);
    }

    @Override
    public List<Building> listBuilding() {
        return buildingRepository.listBuilding();
    }

    @Override
    public List<Building> listBuildingByParam(Building building) {
        return buildingRepository.listBuildingByParam(building);
    }

    @Override
    public PageInfoUtil<Building> listBuildingByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Building> buildingPage = new PageInfo<Building>(buildingRepository.listBuilding());
        return new PageInfoUtil(buildingPage.getList(), pageNum, pageSize, buildingPage.getTotal());
    }

    @Override
    public PageInfoUtil<Building> listBuildingByParamAndPage(Building building, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Building> buildingPage = new PageInfo<Building>(buildingRepository.listBuildingByParam(building));
        return new PageInfoUtil(buildingPage.getList(), pageNum, pageSize, buildingPage.getTotal());
    }

    @Override
    public int deleteBuildingByParam(Building building) {
        return buildingRepository.deleteBuildingByParam(building);
    }

    @Override
    public int updateBuildingByKey(Building building) {
        if(building == null) {
            LOGGER.error("--> building 不能为null！" );
            return 0;
        }
        if(building.getBuildingHead() == null) {
            LOGGER.error("--> building 朝向 不能为null！"  + building);
            return 0;
        }
        if(building.getBulidingArea() == null) {
            LOGGER.error("--> building 面积 不能为null！"  + building);
            return 0;
        }
        if(building.getBuildingKind() == null) {
            LOGGER.error("--> building 类型 不能为null！"  + building);
            return 0;
        }
        if(building.getBuildingId() == null) {
            LOGGER.error("--> building 大楼编号 不能为null！"  + building);
            return 0;
        }
        if(building.getBulidingLevel() == null) {
            LOGGER.error("--> building 层数 不能为null！"  + building);
            return 0;
        }
        return buildingRepository.updateBuildingByKey(building);
    }

    @Override
    public int updateBuildingByKey(List<Building> buildingList) {
        int successNum = 0;
        for(Building building : buildingList) {
            successNum += updateBuildingByKey(building);
        }
        return successNum;
    }


    @Override
    public Building getBuildingByKey(Integer buildingId) {
        return buildingRepository.getBuildingByKey(buildingId);
    }

    @Override
    public List<Building> listBuildingByKey(List<Integer> buildingIdList) {
        return buildingRepository.listBuildingByKey(buildingIdList);
    }

    @Override
    public int deleteBuildingByKey(Integer buildingId) {
        return buildingRepository.deleteBuildingByKey(buildingId);
    }

    @Override
    public int deleteBuildingByKey(List<Integer> buildingIdList) {
        return  buildingRepository.deleteBatchBuildingByKey(buildingIdList);
    }

}
