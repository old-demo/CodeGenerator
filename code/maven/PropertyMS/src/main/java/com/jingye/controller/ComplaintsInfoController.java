package com.jingye.controller;

import com.jingye.entity.ComplaintsInfo;
import com.jingye.controller.request.ComplaintsInfoRequest;
import com.jingye.service.ComplaintsInfoService;
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
@RequestMapping("/complaintsInfo")
public class ComplaintsInfoController {

    @Autowired
    ComplaintsInfoService complaintsInfoService;

    @RequestMapping(value = "/saveComplaintsInfo", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveComplaintsInfo(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        ComplaintsInfo complaintsInfo = complaintsInfoRequest.getComplaintsInfo();
        int result = complaintsInfoService.saveComplaintsInfo(complaintsInfo);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateComplaintsInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateComplaintsInfoByKey(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        if(complaintsInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        ComplaintsInfo complaintsInfo = complaintsInfoRequest.getComplaintsInfo();
        int result = complaintsInfoService.updateComplaintsInfoByKey(complaintsInfo);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteComplaintsInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteComplaintsInfoByKey(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        if(complaintsInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = complaintsInfoService.deleteComplaintsInfoByKey(complaintsInfoRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchComplaintsInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchComplaintsInfoByKey(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        List<Integer> ids = complaintsInfoRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = complaintsInfoService.deleteComplaintsInfoByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getComplaintsInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getComplaintsInfoByKey(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        if(complaintsInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        ComplaintsInfo complaintsInfo = complaintsInfoService.getComplaintsInfoByKey(complaintsInfoRequest.getId());
        return new ResponseUtil(1, "OK", complaintsInfo);
    }

    @RequestMapping(value = "/listComplaintsInfoByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listComplaintsInfoByParamAndPage(@RequestBody ComplaintsInfoRequest complaintsInfoRequest) {
        int pageNum = 1, pageSize = 100;
        if(complaintsInfoRequest.getPageNum() != 0) {
            pageNum = complaintsInfoRequest.getPageNum();
        }
        if(complaintsInfoRequest.getPageSize() != 0) {
            pageSize = complaintsInfoRequest.getPageSize();
        }
        ComplaintsInfo complaintsInfo = complaintsInfoRequest.getComplaintsInfo();
        if(complaintsInfo == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<ComplaintsInfo> complaintsInfoList = complaintsInfoService.listComplaintsInfoByParamAndPage(complaintsInfo, pageNum, pageSize);
        return new ResponseUtil(1, "OK", complaintsInfoList);
    }

}
