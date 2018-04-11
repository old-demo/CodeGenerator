package com.jingye.controller;

import com.jingye.entity.TemporaryParking;
import com.jingye.controller.request.TemporaryParkingRequest;
import com.jingye.service.TemporaryParkingService;
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
@RequestMapping("/temporaryParking")
public class TemporaryParkingController {

    @Autowired
    TemporaryParkingService temporaryParkingService;

    @RequestMapping(value = "/saveTemporaryParking", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveTemporaryParking(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        TemporaryParking temporaryParking = temporaryParkingRequest.getTemporaryParking();
        int result = temporaryParkingService.saveTemporaryParking(temporaryParking);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateTemporaryParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateTemporaryParkingByKey(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        if(temporaryParkingRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        TemporaryParking temporaryParking = temporaryParkingRequest.getTemporaryParking();
        int result = temporaryParkingService.updateTemporaryParkingByKey(temporaryParking);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteTemporaryParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteTemporaryParkingByKey(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        if(temporaryParkingRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        int result = temporaryParkingService.deleteTemporaryParkingByKey(temporaryParkingRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchTemporaryParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchTemporaryParkingByKey(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        List<Integer> ids = temporaryParkingRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = temporaryParkingService.deleteTemporaryParkingByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getTemporaryParkingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getTemporaryParkingByKey(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        if(temporaryParkingRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        TemporaryParking temporaryParking = temporaryParkingService.getTemporaryParkingByKey(temporaryParkingRequest.getId());
        return new ResponseUtil(1, "OK", temporaryParking);
    }

    @RequestMapping(value = "/listTemporaryParkingByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listTemporaryParkingByParamAndPage(@RequestBody TemporaryParkingRequest temporaryParkingRequest) {
        int pageNum = 1, pageSize = 100;
        if(temporaryParkingRequest.getPageNum() != 0) {
            pageNum = temporaryParkingRequest.getPageNum();
        }
        if(temporaryParkingRequest.getPageSize() != 0) {
            pageSize = temporaryParkingRequest.getPageSize();
        }
        TemporaryParking temporaryParking = temporaryParkingRequest.getTemporaryParking();
        if(temporaryParking == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<TemporaryParking> temporaryParkingList = temporaryParkingService.listTemporaryParkingByParamAndPage(temporaryParking, pageNum, pageSize);
        return new ResponseUtil(1, "OK", temporaryParkingList);
    }

}
