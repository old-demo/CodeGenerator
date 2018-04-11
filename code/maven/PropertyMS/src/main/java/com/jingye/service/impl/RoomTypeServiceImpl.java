package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.RoomType;
import com.jingye.repository.RoomTypeRepository;
import com.jingye.service.RoomTypeService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Service("roomTypeService")
public class RoomTypeServiceImpl implements RoomTypeService {

    private static final Logger LOGGER = Logger.getLogger(RoomTypeServiceImpl.class);

	@Autowired
	private RoomTypeRepository roomTypeRepository;

    @Override
    public int saveRoomType(RoomType roomType) {
        if(roomType == null) {
            LOGGER.error("--> roomType 不能为null！" );
            return 0;
        }
        if(roomType.getRtId() == null) {
            LOGGER.error("--> roomType 房型id 不能为null！"  + roomType);
            return 0;
        }
        return roomTypeRepository.saveRoomType(roomType);
    }

    @Override
    public int saveRoomType(List<RoomType> roomTypeList) {
        List<RoomType> temproomTypeList = new ArrayList<>();
        for(RoomType roomType : roomTypeList) {
            if(roomType == null) {
                LOGGER.error("--> roomType 不能为null！" );
                continue;
            }
            if(roomType.getRtId() == null) {
                LOGGER.error("--> roomType 房型id 不能为null！"  + roomType);
                continue;
            }
            temproomTypeList.add(roomType);
        }
        return roomTypeRepository.saveBatchRoomType(temproomTypeList);
    }

    @Override
    public List<RoomType> listRoomType() {
        return roomTypeRepository.listRoomType();
    }

    @Override
    public List<RoomType> listRoomTypeByParam(RoomType roomType) {
        return roomTypeRepository.listRoomTypeByParam(roomType);
    }

    @Override
    public PageInfoUtil<RoomType> listRoomTypeByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RoomType> roomTypePage = new PageInfo<RoomType>(roomTypeRepository.listRoomType());
        return new PageInfoUtil(roomTypePage.getList(), pageNum, pageSize, roomTypePage.getTotal());
    }

    @Override
    public PageInfoUtil<RoomType> listRoomTypeByParamAndPage(RoomType roomType, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RoomType> roomTypePage = new PageInfo<RoomType>(roomTypeRepository.listRoomTypeByParam(roomType));
        return new PageInfoUtil(roomTypePage.getList(), pageNum, pageSize, roomTypePage.getTotal());
    }

    @Override
    public int deleteRoomTypeByParam(RoomType roomType) {
        return roomTypeRepository.deleteRoomTypeByParam(roomType);
    }

    @Override
    public int updateRoomTypeByKey(RoomType roomType) {
        if(roomType == null) {
            LOGGER.error("--> roomType 不能为null！" );
            return 0;
        }
        if(roomType.getRtId() == null) {
            LOGGER.error("--> roomType 房型id 不能为null！"  + roomType);
            return 0;
        }
        return roomTypeRepository.updateRoomTypeByKey(roomType);
    }

    @Override
    public int updateRoomTypeByKey(List<RoomType> roomTypeList) {
        int successNum = 0;
        for(RoomType roomType : roomTypeList) {
            successNum += updateRoomTypeByKey(roomType);
        }
        return successNum;
    }


    @Override
    public RoomType getRoomTypeByKey(Integer rtId) {
        return roomTypeRepository.getRoomTypeByKey(rtId);
    }

    @Override
    public List<RoomType> listRoomTypeByKey(List<Integer> rtIdList) {
        return roomTypeRepository.listRoomTypeByKey(rtIdList);
    }

    @Override
    public int deleteRoomTypeByKey(Integer rtId) {
        return roomTypeRepository.deleteRoomTypeByKey(rtId);
    }

    @Override
    public int deleteRoomTypeByKey(List<Integer> rtIdList) {
        return  roomTypeRepository.deleteBatchRoomTypeByKey(rtIdList);
    }

}
