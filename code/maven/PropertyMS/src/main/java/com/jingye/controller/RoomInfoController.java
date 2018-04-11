package com.jingye.controller;

import com.jingye.entity.RoomInfo;
import com.jingye.controller.request.RoomInfoRequest;
import com.jingye.service.RoomInfoService;
import com.jingye.util.ResponseUtil;
import com.jingye.util.PageInfoUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.math.BigDecimal;

/**
 * 对外接口层
 *
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
@RestController
@RequestMapping("/roomInfo")
public class RoomInfoController {

    @Autowired
    RoomInfoService roomInfoService;

    @RequestMapping(value = "/saveRoomInfo", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveRoomInfo(@RequestBody RoomInfoRequest roomInfoRequest) {
        RoomInfo roomInfo = roomInfoRequest.getRoomInfo();
        int result = roomInfoService.saveRoomInfo(roomInfo);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateRoomInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateRoomInfoByKey(@RequestBody RoomInfoRequest roomInfoRequest) {
        if(roomInfoRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        RoomInfo roomInfo = roomInfoRequest.getRoomInfo();
        int result = roomInfoService.updateRoomInfoByKey(roomInfo);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteRoomInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteRoomInfoByKey(@RequestBody RoomInfoRequest roomInfoRequest) {
        if(roomInfoRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = roomInfoService.deleteRoomInfoByKey(roomInfoRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchRoomInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchRoomInfoByKey(@RequestBody RoomInfoRequest roomInfoRequest) {
        List<Integer> ids = roomInfoRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = roomInfoService.deleteRoomInfoByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getRoomInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getRoomInfoByKey(@RequestBody RoomInfoRequest roomInfoRequest) {
        if(roomInfoRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        RoomInfo roomInfo = roomInfoService.getRoomInfoByKey(roomInfoRequest.getId());
        return new ResponseUtil(1, "OK", roomInfo);
    }

    @RequestMapping(value = "/listRoomInfoByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listRoomInfoByParamAndPage(@RequestBody RoomInfoRequest roomInfoRequest) {
        int pageNum = 1, pageSize = 100;
        if(roomInfoRequest.getPageNum() != 0) {
            pageNum = roomInfoRequest.getPageNum();
        }
        if(roomInfoRequest.getPageSize() != 0) {
            pageSize = roomInfoRequest.getPageSize();
        }
        RoomInfo roomInfo = roomInfoRequest.getRoomInfo();
        if(roomInfo == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<RoomInfo> roomInfoList = roomInfoService.listRoomInfoByParamAndPage(roomInfo, pageNum, pageSize);
        return new ResponseUtil(1, "OK", roomInfoList);
    }

}
