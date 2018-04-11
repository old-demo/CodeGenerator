package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.ParkingSpaces;
import com.jingye.repository.ParkingSpacesRepository;
import com.jingye.service.ParkingSpacesService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:49
 */
@Service("parkingSpacesService")
public class ParkingSpacesServiceImpl implements ParkingSpacesService {

    private static final Logger LOGGER = Logger.getLogger(ParkingSpacesServiceImpl.class);

	@Autowired
	private ParkingSpacesRepository parkingSpacesRepository;

    @Override
    public int saveParkingSpaces(ParkingSpaces parkingSpaces) {
        if(parkingSpaces == null) {
            LOGGER.error("--> parkingSpaces 不能为null！" );
            return 0;
        }
        if(parkingSpaces.getId() == null) {
            LOGGER.error("--> parkingSpaces id 不能为null！"  + parkingSpaces);
            return 0;
        }
        if(parkingSpaces.getCwId() == null) {
            LOGGER.error("--> parkingSpaces 车位编号 不能为null！"  + parkingSpaces);
            return 0;
        }
        return parkingSpacesRepository.saveParkingSpaces(parkingSpaces);
    }

    @Override
    public int saveParkingSpaces(List<ParkingSpaces> parkingSpacesList) {
        List<ParkingSpaces> tempparkingSpacesList = new ArrayList<>();
        for(ParkingSpaces parkingSpaces : parkingSpacesList) {
            if(parkingSpaces == null) {
                LOGGER.error("--> parkingSpaces 不能为null！" );
                continue;
            }
            if(parkingSpaces.getId() == null) {
                LOGGER.error("--> parkingSpaces id 不能为null！"  + parkingSpaces);
                continue;
            }
            if(parkingSpaces.getCwId() == null) {
                LOGGER.error("--> parkingSpaces 车位编号 不能为null！"  + parkingSpaces);
                continue;
            }
            tempparkingSpacesList.add(parkingSpaces);
        }
        return parkingSpacesRepository.saveBatchParkingSpaces(tempparkingSpacesList);
    }

    @Override
    public List<ParkingSpaces> listParkingSpaces() {
        return parkingSpacesRepository.listParkingSpaces();
    }

    @Override
    public List<ParkingSpaces> listParkingSpacesByParam(ParkingSpaces parkingSpaces) {
        return parkingSpacesRepository.listParkingSpacesByParam(parkingSpaces);
    }

    @Override
    public PageInfoUtil<ParkingSpaces> listParkingSpacesByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ParkingSpaces> parkingSpacesPage = new PageInfo<ParkingSpaces>(parkingSpacesRepository.listParkingSpaces());
        return new PageInfoUtil(parkingSpacesPage.getList(), pageNum, pageSize, parkingSpacesPage.getTotal());
    }

    @Override
    public PageInfoUtil<ParkingSpaces> listParkingSpacesByParamAndPage(ParkingSpaces parkingSpaces, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<ParkingSpaces> parkingSpacesPage = new PageInfo<ParkingSpaces>(parkingSpacesRepository.listParkingSpacesByParam(parkingSpaces));
        return new PageInfoUtil(parkingSpacesPage.getList(), pageNum, pageSize, parkingSpacesPage.getTotal());
    }

    @Override
    public int deleteParkingSpacesByParam(ParkingSpaces parkingSpaces) {
        return parkingSpacesRepository.deleteParkingSpacesByParam(parkingSpaces);
    }

    @Override
    public int updateParkingSpacesByKey(ParkingSpaces parkingSpaces) {
        if(parkingSpaces == null) {
            LOGGER.error("--> parkingSpaces 不能为null！" );
            return 0;
        }
        if(parkingSpaces.getId() == null) {
            LOGGER.error("--> parkingSpaces id 不能为null！"  + parkingSpaces);
            return 0;
        }
        if(parkingSpaces.getCwId() == null) {
            LOGGER.error("--> parkingSpaces 车位编号 不能为null！"  + parkingSpaces);
            return 0;
        }
        return parkingSpacesRepository.updateParkingSpacesByKey(parkingSpaces);
    }

    @Override
    public int updateParkingSpacesByKey(List<ParkingSpaces> parkingSpacesList) {
        int successNum = 0;
        for(ParkingSpaces parkingSpaces : parkingSpacesList) {
            successNum += updateParkingSpacesByKey(parkingSpaces);
        }
        return successNum;
    }


    @Override
    public ParkingSpaces getParkingSpacesByKey(Integer id) {
        return parkingSpacesRepository.getParkingSpacesByKey(id);
    }

    @Override
    public List<ParkingSpaces> listParkingSpacesByKey(List<Integer> idList) {
        return parkingSpacesRepository.listParkingSpacesByKey(idList);
    }

    @Override
    public int deleteParkingSpacesByKey(Integer id) {
        return parkingSpacesRepository.deleteParkingSpacesByKey(id);
    }

    @Override
    public int deleteParkingSpacesByKey(List<Integer> idList) {
        return  parkingSpacesRepository.deleteBatchParkingSpacesByKey(idList);
    }

}
