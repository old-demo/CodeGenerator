package com.jingye.controller;

import com.jingye.entity.RoomType;
import com.jingye.controller.request.RoomTypeRequest;
import com.jingye.service.RoomTypeService;
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
@RequestMapping("/roomType")
public class RoomTypeController {

    @Autowired
    RoomTypeService roomTypeService;

    @RequestMapping(value = "/saveRoomType", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveRoomType(@RequestBody RoomTypeRequest roomTypeRequest) {
        RoomType roomType = roomTypeRequest.getRoomType();
        int result = roomTypeService.saveRoomType(roomType);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateRoomTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateRoomTypeByKey(@RequestBody RoomTypeRequest roomTypeRequest) {
        if(roomTypeRequest.getRtId() == null) {
            return new ResponseUtil(0, "房型id不能为null！", null);
        }
        RoomType roomType = roomTypeRequest.getRoomType();
        int result = roomTypeService.updateRoomTypeByKey(roomType);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteRoomTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteRoomTypeByKey(@RequestBody RoomTypeRequest roomTypeRequest) {
        if(roomTypeRequest.getRtId() == null) {
            return new ResponseUtil(0, "房型id不能为null！", null);
        }
        int result = roomTypeService.deleteRoomTypeByKey(roomTypeRequest.getRtId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchRoomTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchRoomTypeByKey(@RequestBody RoomTypeRequest roomTypeRequest) {
        List<Integer> rtIds = roomTypeRequest.getRtIdList();
        if(rtIds == null || rtIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = roomTypeService.deleteRoomTypeByKey(rtIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getRoomTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getRoomTypeByKey(@RequestBody RoomTypeRequest roomTypeRequest) {
        if(roomTypeRequest.getRtId() == null) {
            return new ResponseUtil(0, "房型id不能为null！", null);
        }
        RoomType roomType = roomTypeService.getRoomTypeByKey(roomTypeRequest.getRtId());
        return new ResponseUtil(1, "OK", roomType);
    }

    @RequestMapping(value = "/listRoomTypeByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listRoomTypeByParamAndPage(@RequestBody RoomTypeRequest roomTypeRequest) {
        int pageNum = 1, pageSize = 100;
        if(roomTypeRequest.getPageNum() != 0) {
            pageNum = roomTypeRequest.getPageNum();
        }
        if(roomTypeRequest.getPageSize() != 0) {
            pageSize = roomTypeRequest.getPageSize();
        }
        RoomType roomType = roomTypeRequest.getRoomType();
        if(roomType == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<RoomType> roomTypeList = roomTypeService.listRoomTypeByParamAndPage(roomType, pageNum, pageSize);
        return new ResponseUtil(1, "OK", roomTypeList);
    }

}
