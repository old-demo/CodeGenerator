package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

import com.jingye.entity.RoomInfo;
import com.jingye.repository.RoomInfoRepository;
import com.jingye.service.RoomInfoService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@Service("roomInfoService")
public class RoomInfoServiceImpl implements RoomInfoService {

    private static final Logger LOGGER = Logger.getLogger(RoomInfoServiceImpl.class);

	@Autowired
	private RoomInfoRepository roomInfoRepository;

    @Override
    public int saveRoomInfo(RoomInfo roomInfo) {
        if(roomInfo == null) {
            LOGGER.error("--> roomInfo 不能为null！" );
            return 0;
        }
        if(roomInfo.getId() == null) {
            LOGGER.error("--> roomInfo  不能为null！"  + roomInfo);
            return 0;
        }
        return roomInfoRepository.saveRoomInfo(roomInfo);
    }

    @Override
    public int saveRoomInfo(List<RoomInfo> roomInfoList) {
        List<RoomInfo> temproomInfoList = new ArrayList<>();
        for(RoomInfo roomInfo : roomInfoList) {
            if(roomInfo == null) {
                LOGGER.error("--> roomInfo 不能为null！" );
                continue;
            }
            if(roomInfo.getId() == null) {
                LOGGER.error("--> roomInfo  不能为null！"  + roomInfo);
                continue;
            }
            temproomInfoList.add(roomInfo);
        }
        return roomInfoRepository.saveBatchRoomInfo(temproomInfoList);
    }

    @Override
    public List<RoomInfo> listRoomInfo() {
        return roomInfoRepository.listRoomInfo();
    }

    @Override
    public List<RoomInfo> listRoomInfoByParam(RoomInfo roomInfo) {
        return roomInfoRepository.listRoomInfoByParam(roomInfo);
    }

    @Override
    public PageInfoUtil<RoomInfo> listRoomInfoByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RoomInfo> roomInfoPage = new PageInfo<RoomInfo>(roomInfoRepository.listRoomInfo());
        return new PageInfoUtil(roomInfoPage.getList(), pageNum, pageSize, roomInfoPage.getTotal());
    }

    @Override
    public PageInfoUtil<RoomInfo> listRoomInfoByParamAndPage(RoomInfo roomInfo, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RoomInfo> roomInfoPage = new PageInfo<RoomInfo>(roomInfoRepository.listRoomInfoByParam(roomInfo));
        return new PageInfoUtil(roomInfoPage.getList(), pageNum, pageSize, roomInfoPage.getTotal());
    }

    @Override
    public int deleteRoomInfoByParam(RoomInfo roomInfo) {
        return roomInfoRepository.deleteRoomInfoByParam(roomInfo);
    }

    @Override
    public int updateRoomInfoByKey(RoomInfo roomInfo) {
        if(roomInfo == null) {
            LOGGER.error("--> roomInfo 不能为null！" );
            return 0;
        }
        if(roomInfo.getId() == null) {
            LOGGER.error("--> roomInfo  不能为null！"  + roomInfo);
            return 0;
        }
        return roomInfoRepository.updateRoomInfoByKey(roomInfo);
    }

    @Override
    public int updateRoomInfoByKey(List<RoomInfo> roomInfoList) {
        int successNum = 0;
        for(RoomInfo roomInfo : roomInfoList) {
            successNum += updateRoomInfoByKey(roomInfo);
        }
        return successNum;
    }


    @Override
    public RoomInfo getRoomInfoByKey(Integer id) {
        return roomInfoRepository.getRoomInfoByKey(id);
    }

    @Override
    public List<RoomInfo> listRoomInfoByKey(List<Integer> idList) {
        return roomInfoRepository.listRoomInfoByKey(idList);
    }

    @Override
    public int deleteRoomInfoByKey(Integer id) {
        return roomInfoRepository.deleteRoomInfoByKey(id);
    }

    @Override
    public int deleteRoomInfoByKey(List<Integer> idList) {
        return  roomInfoRepository.deleteBatchRoomInfoByKey(idList);
    }

}
