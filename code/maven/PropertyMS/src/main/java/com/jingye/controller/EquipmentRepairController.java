package com.jingye.controller;

import com.jingye.entity.EquipmentRepair;
import com.jingye.controller.request.EquipmentRepairRequest;
import com.jingye.service.EquipmentRepairService;
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
@RequestMapping("/equipmentRepair")
public class EquipmentRepairController {

    @Autowired
    EquipmentRepairService equipmentRepairService;

    @RequestMapping(value = "/saveEquipmentRepair", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveEquipmentRepair(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        EquipmentRepair equipmentRepair = equipmentRepairRequest.getEquipmentRepair();
        int result = equipmentRepairService.saveEquipmentRepair(equipmentRepair);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateEquipmentRepairByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateEquipmentRepairByKey(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        if(equipmentRepairRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        EquipmentRepair equipmentRepair = equipmentRepairRequest.getEquipmentRepair();
        int result = equipmentRepairService.updateEquipmentRepairByKey(equipmentRepair);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteEquipmentRepairByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteEquipmentRepairByKey(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        if(equipmentRepairRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = equipmentRepairService.deleteEquipmentRepairByKey(equipmentRepairRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchEquipmentRepairByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchEquipmentRepairByKey(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        List<Integer> ids = equipmentRepairRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = equipmentRepairService.deleteEquipmentRepairByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getEquipmentRepairByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getEquipmentRepairByKey(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        if(equipmentRepairRequest.getId() == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        EquipmentRepair equipmentRepair = equipmentRepairService.getEquipmentRepairByKey(equipmentRepairRequest.getId());
        return new ResponseUtil(1, "OK", equipmentRepair);
    }

    @RequestMapping(value = "/listEquipmentRepairByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listEquipmentRepairByParamAndPage(@RequestBody EquipmentRepairRequest equipmentRepairRequest) {
        int pageNum = 1, pageSize = 100;
        if(equipmentRepairRequest.getPageNum() != 0) {
            pageNum = equipmentRepairRequest.getPageNum();
        }
        if(equipmentRepairRequest.getPageSize() != 0) {
            pageSize = equipmentRepairRequest.getPageSize();
        }
        EquipmentRepair equipmentRepair = equipmentRepairRequest.getEquipmentRepair();
        if(equipmentRepair == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<EquipmentRepair> equipmentRepairList = equipmentRepairService.listEquipmentRepairByParamAndPage(equipmentRepair, pageNum, pageSize);
        return new ResponseUtil(1, "OK", equipmentRepairList);
    }

}
