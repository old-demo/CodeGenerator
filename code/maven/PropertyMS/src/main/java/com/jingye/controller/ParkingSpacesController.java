package com.jingye.controller;

import com.jingye.entity.ParkingSpaces;
import com.jingye.controller.request.ParkingSpacesRequest;
import com.jingye.service.ParkingSpacesService;
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
 * @date   2018-04-11 12:14:49
 */
@RestController
@RequestMapping("/parkingSpaces")
public class ParkingSpacesController {

    @Autowired
    ParkingSpacesService parkingSpacesService;

    @RequestMapping(value = "/saveParkingSpaces", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveParkingSpaces(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        ParkingSpaces parkingSpaces = parkingSpacesRequest.getParkingSpaces();
        int result = parkingSpacesService.saveParkingSpaces(parkingSpaces);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateParkingSpacesByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateParkingSpacesByKey(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        if(parkingSpacesRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        if(parkingSpacesRequest.getCwId() == null) {
            return new ResponseUtil(0, "车位编号不能为null！", null);
        }
        ParkingSpaces parkingSpaces = parkingSpacesRequest.getParkingSpaces();
        int result = parkingSpacesService.updateParkingSpacesByKey(parkingSpaces);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteParkingSpacesByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteParkingSpacesByKey(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        if(parkingSpacesRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = parkingSpacesService.deleteParkingSpacesByKey(parkingSpacesRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchParkingSpacesByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchParkingSpacesByKey(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        List<Integer> ids = parkingSpacesRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = parkingSpacesService.deleteParkingSpacesByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getParkingSpacesByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getParkingSpacesByKey(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        if(parkingSpacesRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        ParkingSpaces parkingSpaces = parkingSpacesService.getParkingSpacesByKey(parkingSpacesRequest.getId());
        return new ResponseUtil(1, "OK", parkingSpaces);
    }

    @RequestMapping(value = "/listParkingSpacesByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listParkingSpacesByParamAndPage(@RequestBody ParkingSpacesRequest parkingSpacesRequest) {
        int pageNum = 1, pageSize = 100;
        if(parkingSpacesRequest.getPageNum() != 0) {
            pageNum = parkingSpacesRequest.getPageNum();
        }
        if(parkingSpacesRequest.getPageSize() != 0) {
            pageSize = parkingSpacesRequest.getPageSize();
        }
        ParkingSpaces parkingSpaces = parkingSpacesRequest.getParkingSpaces();
        if(parkingSpaces == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<ParkingSpaces> parkingSpacesList = parkingSpacesService.listParkingSpacesByParamAndPage(parkingSpaces, pageNum, pageSize);
        return new ResponseUtil(1, "OK", parkingSpacesList);
    }

}
