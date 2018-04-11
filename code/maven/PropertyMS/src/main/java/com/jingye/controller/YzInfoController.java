package com.jingye.controller;

import com.jingye.entity.YzInfo;
import com.jingye.controller.request.YzInfoRequest;
import com.jingye.service.YzInfoService;
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
@RequestMapping("/yzInfo")
public class YzInfoController {

    @Autowired
    YzInfoService yzInfoService;

    @RequestMapping(value = "/saveYzInfo", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveYzInfo(@RequestBody YzInfoRequest yzInfoRequest) {
        YzInfo yzInfo = yzInfoRequest.getYzInfo();
        int result = yzInfoService.saveYzInfo(yzInfo);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateYzInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateYzInfoByKey(@RequestBody YzInfoRequest yzInfoRequest) {
        if(yzInfoRequest.getYzName() == null) {
            return new ResponseUtil(0, "姓名不能为null！", null);
        }
        if(yzInfoRequest.getYzTel() == null) {
            return new ResponseUtil(0, "联系电话不能为null！", null);
        }
        YzInfo yzInfo = yzInfoRequest.getYzInfo();
        int result = yzInfoService.updateYzInfoByKey(yzInfo);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteYzInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteYzInfoByKey(@RequestBody YzInfoRequest yzInfoRequest) {
        if(yzInfoRequest.getYzId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        int result = yzInfoService.deleteYzInfoByKey(yzInfoRequest.getYzId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchYzInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchYzInfoByKey(@RequestBody YzInfoRequest yzInfoRequest) {
        List<Integer> yzIds = yzInfoRequest.getYzIdList();
        if(yzIds == null || yzIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = yzInfoService.deleteYzInfoByKey(yzIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getYzInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getYzInfoByKey(@RequestBody YzInfoRequest yzInfoRequest) {
        if(yzInfoRequest.getYzId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        YzInfo yzInfo = yzInfoService.getYzInfoByKey(yzInfoRequest.getYzId());
        return new ResponseUtil(1, "OK", yzInfo);
    }

    @RequestMapping(value = "/listYzInfoByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listYzInfoByParamAndPage(@RequestBody YzInfoRequest yzInfoRequest) {
        int pageNum = 1, pageSize = 100;
        if(yzInfoRequest.getPageNum() != 0) {
            pageNum = yzInfoRequest.getPageNum();
        }
        if(yzInfoRequest.getPageSize() != 0) {
            pageSize = yzInfoRequest.getPageSize();
        }
        YzInfo yzInfo = yzInfoRequest.getYzInfo();
        if(yzInfo == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<YzInfo> yzInfoList = yzInfoService.listYzInfoByParamAndPage(yzInfo, pageNum, pageSize);
        return new ResponseUtil(1, "OK", yzInfoList);
    }

}
