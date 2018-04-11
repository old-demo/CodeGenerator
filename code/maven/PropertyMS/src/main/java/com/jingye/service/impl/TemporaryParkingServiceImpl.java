package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.TemporaryParking;
import com.jingye.repository.TemporaryParkingRepository;
import com.jingye.service.TemporaryParkingService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Service("temporaryParkingService")
public class TemporaryParkingServiceImpl implements TemporaryParkingService {

    private static final Logger LOGGER = Logger.getLogger(TemporaryParkingServiceImpl.class);

	@Autowired
	private TemporaryParkingRepository temporaryParkingRepository;

    @Override
    public int saveTemporaryParking(TemporaryParking temporaryParking) {
        if(temporaryParking == null) {
            LOGGER.error("--> temporaryParking 不能为null！" );
            return 0;
        }
        if(temporaryParking.getId() == null) {
            LOGGER.error("--> temporaryParking Id 不能为null！"  + temporaryParking);
            return 0;
        }
        return temporaryParkingRepository.saveTemporaryParking(temporaryParking);
    }

    @Override
    public int saveTemporaryParking(List<TemporaryParking> temporaryParkingList) {
        List<TemporaryParking> temptemporaryParkingList = new ArrayList<>();
        for(TemporaryParking temporaryParking : temporaryParkingList) {
            if(temporaryParking == null) {
                LOGGER.error("--> temporaryParking 不能为null！" );
                continue;
            }
            if(temporaryParking.getId() == null) {
                LOGGER.error("--> temporaryParking Id 不能为null！"  + temporaryParking);
                continue;
            }
            temptemporaryParkingList.add(temporaryParking);
        }
        return temporaryParkingRepository.saveBatchTemporaryParking(temptemporaryParkingList);
    }

    @Override
    public List<TemporaryParking> listTemporaryParking() {
        return temporaryParkingRepository.listTemporaryParking();
    }

    @Override
    public List<TemporaryParking> listTemporaryParkingByParam(TemporaryParking temporaryParking) {
        return temporaryParkingRepository.listTemporaryParkingByParam(temporaryParking);
    }

    @Override
    public PageInfoUtil<TemporaryParking> listTemporaryParkingByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TemporaryParking> temporaryParkingPage = new PageInfo<TemporaryParking>(temporaryParkingRepository.listTemporaryParking());
        return new PageInfoUtil(temporaryParkingPage.getList(), pageNum, pageSize, temporaryParkingPage.getTotal());
    }

    @Override
    public PageInfoUtil<TemporaryParking> listTemporaryParkingByParamAndPage(TemporaryParking temporaryParking, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<TemporaryParking> temporaryParkingPage = new PageInfo<TemporaryParking>(temporaryParkingRepository.listTemporaryParkingByParam(temporaryParking));
        return new PageInfoUtil(temporaryParkingPage.getList(), pageNum, pageSize, temporaryParkingPage.getTotal());
    }

    @Override
    public int deleteTemporaryParkingByParam(TemporaryParking temporaryParking) {
        return temporaryParkingRepository.deleteTemporaryParkingByParam(temporaryParking);
    }

    @Override
    public int updateTemporaryParkingByKey(TemporaryParking temporaryParking) {
        if(temporaryParking == null) {
            LOGGER.error("--> temporaryParking 不能为null！" );
            return 0;
        }
        if(temporaryParking.getId() == null) {
            LOGGER.error("--> temporaryParking Id 不能为null！"  + temporaryParking);
            return 0;
        }
        return temporaryParkingRepository.updateTemporaryParkingByKey(temporaryParking);
    }

    @Override
    public int updateTemporaryParkingByKey(List<TemporaryParking> temporaryParkingList) {
        int successNum = 0;
        for(TemporaryParking temporaryParking : temporaryParkingList) {
            successNum += updateTemporaryParkingByKey(temporaryParking);
        }
        return successNum;
    }


    @Override
    public TemporaryParking getTemporaryParkingByKey(Integer id) {
        return temporaryParkingRepository.getTemporaryParkingByKey(id);
    }

    @Override
    public List<TemporaryParking> listTemporaryParkingByKey(List<Integer> idList) {
        return temporaryParkingRepository.listTemporaryParkingByKey(idList);
    }

    @Override
    public int deleteTemporaryParkingByKey(Integer id) {
        return temporaryParkingRepository.deleteTemporaryParkingByKey(id);
    }

    @Override
    public int deleteTemporaryParkingByKey(List<Integer> idList) {
        return  temporaryParkingRepository.deleteBatchTemporaryParkingByKey(idList);
    }

}
