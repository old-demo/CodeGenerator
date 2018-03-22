package com.jingye.controller;

import com.jingye.entity.Parking;
import com.jingye.controller.request.ParkingRequest;
import com.jingye.service.ParkingService;
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
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @RequestMapping(value = "/saveParking", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveParking(@RequestBody ParkingRequest parkingRequest) {
        Parking parking = parkingRequest.getParking();
        if(parking == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = parkingService.saveParking(parking);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateParkingByKey(@RequestBody ParkingRequest parkingRequest) {
        if(parkingRequest.getParkingOwnerId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        if(parkingRequest.getParkingArea() == null) {
            return new ResponseUtil(0, "车位面积不能为null！", null);
        }
        if(parkingRequest.getParkingId() == null) {
            return new ResponseUtil(0, "车位id不能为null！", null);
        }
        if(parkingRequest.getParkingCarNumber() == null) {
            return new ResponseUtil(0, "车牌号不能为null！", null);
        }
        if(parkingRequest.getParkingCarKind() == null) {
            return new ResponseUtil(0, "联系电话不能为null！", null);
        }
        Parking parking = parkingRequest.getParking();
        if(parking == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = parkingService.updateParkingByKey(parking);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteParkingByKey(@RequestBody ParkingRequest parkingRequest) {
        if(parkingRequest.getParkingId() == null) {
            return new ResponseUtil(0, "车位id不能为null！", null);
        }
        int result = parkingService.deleteParkingByKey(parkingRequest.getParkingId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchParkingByKey(@RequestBody ParkingRequest parkingRequest) {
        List<Integer> parkingIds = parkingRequest.getParkingIdList();
        if(parkingIds == null || parkingIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = parkingService.deleteParkingByKey(parkingIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getParkingByKey(@RequestBody ParkingRequest parkingRequest) {
        if(parkingRequest.getParkingId() == null) {
            return new ResponseUtil(0, "车位id不能为null！", null);
        }
        Parking parking = parkingService.getParkingByKey(parkingRequest.getParkingId());
        return new ResponseUtil(1, "OK", parking);
    }

    @RequestMapping(value = "/listParkingByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listParkingByParamAndPage(@RequestBody ParkingRequest parkingRequest) {
        int pageNum = 1, pageSize = 100;
        if(parkingRequest.getPageNum() != 0) {
            pageNum = parkingRequest.getPageNum();
        }
        if(parkingRequest.getPageSize() != 0) {
            pageSize = parkingRequest.getPageSize();
        }
        Parking parking = parkingRequest.getParking();
        if(parking == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Parking> parkingList = parkingService.listParkingByParamAndPage(parking, pageNum, pageSize);
        return new ResponseUtil(1, "OK", parkingList);
    }

}
