package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Parking;
import com.jingye.repository.ParkingRepository;
import com.jingye.service.ParkingService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Service("parkingService")
public class ParkingServiceImpl implements ParkingService {

    private static final Logger LOGGER = Logger.getLogger(ParkingServiceImpl.class);

	@Autowired
	private ParkingRepository parkingRepository;

    @Override
    public int saveParking(Parking parking) {
        if(parking == null) {
            LOGGER.error("--> parking 不能为null！" );
            return 0;
        }
        if(parking.getParkingOwnerId() == null) {
            LOGGER.error("--> parking 业主id 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingArea() == null) {
            LOGGER.error("--> parking 车位面积 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingId() == null) {
            LOGGER.error("--> parking 车位id 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingCarNumber() == null) {
            LOGGER.error("--> parking 车牌号 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingCarKind() == null) {
            LOGGER.error("--> parking 联系电话 不能为null！"  + parking);
            return 0;
        }
        return parkingRepository.saveParking(parking);
    }

    @Override
    public int saveParking(List<Parking> parkingList) {
        List<Parking> tempparkingList = new ArrayList<>();
        for(Parking parking : parkingList) {
            if(parking == null) {
                LOGGER.error("--> parking 不能为null！" );
                continue;
            }
            if(parking.getParkingOwnerId() == null) {
                LOGGER.error("--> parking 业主id 不能为null！"  + parking);
                continue;
            }
            if(parking.getParkingArea() == null) {
                LOGGER.error("--> parking 车位面积 不能为null！"  + parking);
                continue;
            }
            if(parking.getParkingId() == null) {
                LOGGER.error("--> parking 车位id 不能为null！"  + parking);
                continue;
            }
            if(parking.getParkingCarNumber() == null) {
                LOGGER.error("--> parking 车牌号 不能为null！"  + parking);
                continue;
            }
            if(parking.getParkingCarKind() == null) {
                LOGGER.error("--> parking 联系电话 不能为null！"  + parking);
                continue;
            }
            tempparkingList.add(parking);
        }
        return parkingRepository.saveBatchParking(tempparkingList);
    }

    @Override
    public List<Parking> listParking() {
        return parkingRepository.listParking();
    }

    @Override
    public List<Parking> listParkingByParam(Parking parking) {
        return parkingRepository.listParkingByParam(parking);
    }

    @Override
    public PageInfoUtil<Parking> listParkingByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Parking> parkingPage = new PageInfo<Parking>(parkingRepository.listParking());
        return new PageInfoUtil(parkingPage.getList(), pageNum, pageSize, parkingPage.getTotal());
    }

    @Override
    public PageInfoUtil<Parking> listParkingByParamAndPage(Parking parking, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Parking> parkingPage = new PageInfo<Parking>(parkingRepository.listParkingByParam(parking));
        return new PageInfoUtil(parkingPage.getList(), pageNum, pageSize, parkingPage.getTotal());
    }

    @Override
    public int deleteParkingByParam(Parking parking) {
        return parkingRepository.deleteParkingByParam(parking);
    }

    @Override
    public int updateParkingByKey(Parking parking) {
        if(parking == null) {
            LOGGER.error("--> parking 不能为null！" );
            return 0;
        }
        if(parking.getParkingOwnerId() == null) {
            LOGGER.error("--> parking 业主id 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingArea() == null) {
            LOGGER.error("--> parking 车位面积 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingId() == null) {
            LOGGER.error("--> parking 车位id 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingCarNumber() == null) {
            LOGGER.error("--> parking 车牌号 不能为null！"  + parking);
            return 0;
        }
        if(parking.getParkingCarKind() == null) {
            LOGGER.error("--> parking 联系电话 不能为null！"  + parking);
            return 0;
        }
        return parkingRepository.updateParkingByKey(parking);
    }

    @Override
    public int updateParkingByKey(List<Parking> parkingList) {
        int successNum = 0;
        for(Parking parking : parkingList) {
            successNum += updateParkingByKey(parking);
        }
        return successNum;
    }


    @Override
    public Parking getParkingByKey(Integer parkingId) {
        return parkingRepository.getParkingByKey(parkingId);
    }

    @Override
    public List<Parking> listParkingByKey(List<Integer> parkingIdList) {
        return parkingRepository.listParkingByKey(parkingIdList);
    }

    @Override
    public int deleteParkingByKey(Integer parkingId) {
        return parkingRepository.deleteParkingByKey(parkingId);
    }

    @Override
    public int deleteParkingByKey(List<Integer> parkingIdList) {
        return  parkingRepository.deleteBatchParkingByKey(parkingIdList);
    }

}
