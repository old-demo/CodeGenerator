package com.jingye.controller;

import com.jingye.entity.Equipment;
import com.jingye.controller.request.EquipmentRequest;
import com.jingye.service.EquipmentService;
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
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @RequestMapping(value = "/saveEquipment", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        Equipment equipment = equipmentRequest.getEquipment();
        if(equipment == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = equipmentService.saveEquipment(equipment);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateEquipmentByKey(@RequestBody EquipmentRequest equipmentRequest) {
        if(equipmentRequest.getEquipmentId() == null) {
            return new ResponseUtil(0, "编号不能为null！", null);
        }
        if(equipmentRequest.getEquipmentCycle() == null) {
            return new ResponseUtil(0, "检修周期不能为null！", null);
        }
        if(equipmentRequest.getEquipmentName() == null) {
            return new ResponseUtil(0, "名称不能为null！", null);
        }
        if(equipmentRequest.getEquipmentVendor() == null) {
            return new ResponseUtil(0, "生产厂商不能为null！", null);
        }
        if(equipmentRequest.getEquipmentNumber() == null) {
            return new ResponseUtil(0, "数量不能为null！", null);
        }
        if(equipmentRequest.getEquipmentProduce() == null) {
            return new ResponseUtil(0, "生产日期不能为null！", null);
        }
        Equipment equipment = equipmentRequest.getEquipment();
        if(equipment == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = equipmentService.updateEquipmentByKey(equipment);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteEquipmentByKey(@RequestBody EquipmentRequest equipmentRequest) {
        if(equipmentRequest.getEquipmentId() == null) {
            return new ResponseUtil(0, "编号不能为null！", null);
        }
        int result = equipmentService.deleteEquipmentByKey(equipmentRequest.getEquipmentId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchEquipmentByKey(@RequestBody EquipmentRequest equipmentRequest) {
        List<Integer> equipmentIds = equipmentRequest.getEquipmentIdList();
        if(equipmentIds == null || equipmentIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = equipmentService.deleteEquipmentByKey(equipmentIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getEquipmentByKey(@RequestBody EquipmentRequest equipmentRequest) {
        if(equipmentRequest.getEquipmentId() == null) {
            return new ResponseUtil(0, "编号不能为null！", null);
        }
        Equipment equipment = equipmentService.getEquipmentByKey(equipmentRequest.getEquipmentId());
        return new ResponseUtil(1, "OK", equipment);
    }

    @RequestMapping(value = "/listEquipmentByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listEquipmentByParamAndPage(@RequestBody EquipmentRequest equipmentRequest) {
        int pageNum = 1, pageSize = 100;
        if(equipmentRequest.getPageNum() != 0) {
            pageNum = equipmentRequest.getPageNum();
        }
        if(equipmentRequest.getPageSize() != 0) {
            pageSize = equipmentRequest.getPageSize();
        }
        Equipment equipment = equipmentRequest.getEquipment();
        if(equipment == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Equipment> equipmentList = equipmentService.listEquipmentByParamAndPage(equipment, pageNum, pageSize);
        return new ResponseUtil(1, "OK", equipmentList);
    }

}
