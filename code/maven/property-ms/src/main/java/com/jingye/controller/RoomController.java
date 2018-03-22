package com.jingye.controller;

import com.jingye.entity.Room;
import com.jingye.controller.request.RoomRequest;
import com.jingye.service.RoomService;
import com.jingye.util.ResponseUtil;
import com.jingye.util.PageInfoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对外接口层
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-03-22 11:51:10
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping(value = "/saveRoom", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveRoom(@RequestBody RoomRequest roomRequest) {
        Room room = roomRequest.getRoom();
        if(room == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = roomService.saveRoom(room);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateRoomByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateRoomByKey(@RequestBody RoomRequest roomRequest) {
        if(roomRequest.getRoomUnitId() == null) {
            return new ResponseUtil(0, "单元号不能为null！", null);
        }
        if(roomRequest.getRoomArea() == null) {
            return new ResponseUtil(0, "房间面积不能为null！", null);
        }
        if(roomRequest.getRoomShape() == null) {
            return new ResponseUtil(0, "房型不能为null！", null);
        }
        if(roomRequest.getRoomId() == null) {
            return new ResponseUtil(0, "房间号不能为null！", null);
        }
        if(roomRequest.getRoomOwnerId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        Room room = roomRequest.getRoom();
        if(room == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = roomService.updateRoomByKey(room);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteRoomByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteRoomByKey(@RequestBody RoomRequest roomRequest) {
        if(roomRequest.getRoomId() == null) {
            return new ResponseUtil(0, "房间号不能为null！", null);
        }
        int result = roomService.deleteRoomByKey(roomRequest.getRoomId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchRoomByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchRoomByKey(@RequestBody RoomRequest roomRequest) {
        List<Integer> roomIds = roomRequest.getRoomIdList();
        if(roomIds == null || roomIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = roomService.deleteRoomByKey(roomIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getRoomByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getRoomByKey(@RequestBody RoomRequest roomRequest) {
        if(roomRequest.getRoomId() == null) {
            return new ResponseUtil(0, "房间号不能为null！", null);
        }
        Room room = roomService.getRoomByKey(roomRequest.getRoomId());
        return new ResponseUtil(1, "OK", room);
    }

    @RequestMapping(value = "/listRoomByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listRoomByParamAndPage(@RequestBody RoomRequest roomRequest) {
        int pageNum = 1, pageSize = 100;
        if(roomRequest.getPageNum() != 0) {
            pageNum = roomRequest.getPageNum();
        }
        if(roomRequest.getPageSize() != 0) {
            pageSize = roomRequest.getPageSize();
        }
        Room room = roomRequest.getRoom();
        if(room == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Room> roomList = roomService.listRoomByParamAndPage(room, pageNum, pageSize);
        return new ResponseUtil(1, "OK", roomList);
    }

}
