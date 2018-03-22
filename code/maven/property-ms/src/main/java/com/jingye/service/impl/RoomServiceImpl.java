package com.jingye.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.jingye.entity.Room;
import com.jingye.repository.RoomRepository;
import com.jingye.service.RoomService;
import com.jingye.util.PageInfoUtil;

/**
 * 业务逻辑实现类
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {

    private static final Logger LOGGER = Logger.getLogger(RoomServiceImpl.class);

	@Autowired
	private RoomRepository roomRepository;

    @Override
    public int saveRoom(Room room) {
        if(room == null) {
            LOGGER.error("--> room 不能为null！" );
            return 0;
        }
        if(room.getRoomUnitId() == null) {
            LOGGER.error("--> room 单元号 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomArea() == null) {
            LOGGER.error("--> room 房间面积 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomShape() == null) {
            LOGGER.error("--> room 房型 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomId() == null) {
            LOGGER.error("--> room 房间号 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomOwnerId() == null) {
            LOGGER.error("--> room 业主id 不能为null！"  + room);
            return 0;
        }
        return roomRepository.saveRoom(room);
    }

    @Override
    public int saveRoom(List<Room> roomList) {
        List<Room> temproomList = new ArrayList<>();
        for(Room room : roomList) {
            if(room == null) {
                LOGGER.error("--> room 不能为null！" );
                continue;
            }
            if(room.getRoomUnitId() == null) {
                LOGGER.error("--> room 单元号 不能为null！"  + room);
                continue;
            }
            if(room.getRoomArea() == null) {
                LOGGER.error("--> room 房间面积 不能为null！"  + room);
                continue;
            }
            if(room.getRoomShape() == null) {
                LOGGER.error("--> room 房型 不能为null！"  + room);
                continue;
            }
            if(room.getRoomId() == null) {
                LOGGER.error("--> room 房间号 不能为null！"  + room);
                continue;
            }
            if(room.getRoomOwnerId() == null) {
                LOGGER.error("--> room 业主id 不能为null！"  + room);
                continue;
            }
            temproomList.add(room);
        }
        return roomRepository.saveBatchRoom(temproomList);
    }

    @Override
    public List<Room> listRoom() {
        return roomRepository.listRoom();
    }

    @Override
    public List<Room> listRoomByParam(Room room) {
        return roomRepository.listRoomByParam(room);
    }

    @Override
    public PageInfoUtil<Room> listRoomByPage(int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Room> roomPage = new PageInfo<Room>(roomRepository.listRoom());
        return new PageInfoUtil(roomPage.getList(), pageNum, pageSize, roomPage.getTotal());
    }

    @Override
    public PageInfoUtil<Room> listRoomByParamAndPage(Room room, int pageNum, int pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        pageSize = pageSize < 1 ? 1 : pageSize > 100 ? 100 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Room> roomPage = new PageInfo<Room>(roomRepository.listRoomByParam(room));
        return new PageInfoUtil(roomPage.getList(), pageNum, pageSize, roomPage.getTotal());
    }

    @Override
    public int deleteRoomByParam(Room room) {
        return roomRepository.deleteRoomByParam(room);
    }

    @Override
    public int updateRoomByKey(Room room) {
        if(room == null) {
            LOGGER.error("--> room 不能为null！" );
            return 0;
        }
        if(room.getRoomUnitId() == null) {
            LOGGER.error("--> room 单元号 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomArea() == null) {
            LOGGER.error("--> room 房间面积 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomShape() == null) {
            LOGGER.error("--> room 房型 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomId() == null) {
            LOGGER.error("--> room 房间号 不能为null！"  + room);
            return 0;
        }
        if(room.getRoomOwnerId() == null) {
            LOGGER.error("--> room 业主id 不能为null！"  + room);
            return 0;
        }
        return roomRepository.updateRoomByKey(room);
    }

    @Override
    public int updateRoomByKey(List<Room> roomList) {
        int successNum = 0;
        for(Room room : roomList) {
            successNum += updateRoomByKey(room);
        }
        return successNum;
    }


    @Override
    public Room getRoomByKey(Integer roomId) {
        return roomRepository.getRoomByKey(roomId);
    }

    @Override
    public List<Room> listRoomByKey(List<Integer> roomIdList) {
        return roomRepository.listRoomByKey(roomIdList);
    }

    @Override
    public int deleteRoomByKey(Integer roomId) {
        return roomRepository.deleteRoomByKey(roomId);
    }

    @Override
    public int deleteRoomByKey(List<Integer> roomIdList) {
        return  roomRepository.deleteBatchRoomByKey(roomIdList);
    }

}
