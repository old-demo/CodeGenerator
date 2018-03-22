package com.jingye.controller;

import com.jingye.entity.Charge;
import com.jingye.controller.request.ChargeRequest;
import com.jingye.service.ChargeService;
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
 * @date   2018-03-22 11:51:09
 */
@RestController
@RequestMapping("/charge")
public class ChargeController {

    @Autowired
    ChargeService chargeService;

    @RequestMapping(value = "/saveCharge", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveCharge(@RequestBody ChargeRequest chargeRequest) {
        Charge charge = chargeRequest.getCharge();
        if(charge == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = chargeService.saveCharge(charge);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateChargeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateChargeByKey(@RequestBody ChargeRequest chargeRequest) {
        if(chargeRequest.getChargeId() == null) {
            return new ResponseUtil(0, "收费标准id不能为null！", null);
        }
        if(chargeRequest.getChargeMoney() == null) {
            return new ResponseUtil(0, "收费金额不能为null！", null);
        }
        if(chargeRequest.getChargeName() == null) {
            return new ResponseUtil(0, "收费标准名不能为null！", null);
        }
        if(chargeRequest.getChargeKind() == null) {
            return new ResponseUtil(0, "收费标准类别不能为null！", null);
        }
        Charge charge = chargeRequest.getCharge();
        if(charge == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = chargeService.updateChargeByKey(charge);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteChargeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteChargeByKey(@RequestBody ChargeRequest chargeRequest) {
        if(chargeRequest.getChargeId() == null) {
            return new ResponseUtil(0, "收费标准id不能为null！", null);
        }
        int result = chargeService.deleteChargeByKey(chargeRequest.getChargeId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchChargeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchChargeByKey(@RequestBody ChargeRequest chargeRequest) {
        List<Integer> chargeIds = chargeRequest.getChargeIdList();
        if(chargeIds == null || chargeIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = chargeService.deleteChargeByKey(chargeIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getChargeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getChargeByKey(@RequestBody ChargeRequest chargeRequest) {
        if(chargeRequest.getChargeId() == null) {
            return new ResponseUtil(0, "收费标准id不能为null！", null);
        }
        Charge charge = chargeService.getChargeByKey(chargeRequest.getChargeId());
        return new ResponseUtil(1, "OK", charge);
    }

    @RequestMapping(value = "/listChargeByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listChargeByParamAndPage(@RequestBody ChargeRequest chargeRequest) {
        int pageNum = 1, pageSize = 100;
        if(chargeRequest.getPageNum() != 0) {
            pageNum = chargeRequest.getPageNum();
        }
        if(chargeRequest.getPageSize() != 0) {
            pageSize = chargeRequest.getPageSize();
        }
        Charge charge = chargeRequest.getCharge();
        if(charge == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Charge> chargeList = chargeService.listChargeByParamAndPage(charge, pageNum, pageSize);
        return new ResponseUtil(1, "OK", chargeList);
    }

}
