package com.jingye.controller;

import com.jingye.entity.PublicEquipment;
import com.jingye.controller.request.PublicEquipmentRequest;
import com.jingye.service.PublicEquipmentService;
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
@RequestMapping("/publicEquipment")
public class PublicEquipmentController {

    @Autowired
    PublicEquipmentService publicEquipmentService;

    @RequestMapping(value = "/savePublicEquipment", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil savePublicEquipment(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        PublicEquipment publicEquipment = publicEquipmentRequest.getPublicEquipment();
        int result = publicEquipmentService.savePublicEquipment(publicEquipment);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updatePublicEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updatePublicEquipmentByKey(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        if(publicEquipmentRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        PublicEquipment publicEquipment = publicEquipmentRequest.getPublicEquipment();
        int result = publicEquipmentService.updatePublicEquipmentByKey(publicEquipment);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deletePublicEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deletePublicEquipmentByKey(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        if(publicEquipmentRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        int result = publicEquipmentService.deletePublicEquipmentByKey(publicEquipmentRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchPublicEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchPublicEquipmentByKey(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        List<Integer> ids = publicEquipmentRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = publicEquipmentService.deletePublicEquipmentByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getPublicEquipmentByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getPublicEquipmentByKey(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        if(publicEquipmentRequest.getId() == null) {
            return new ResponseUtil(0, "Id不能为null！", null);
        }
        PublicEquipment publicEquipment = publicEquipmentService.getPublicEquipmentByKey(publicEquipmentRequest.getId());
        return new ResponseUtil(1, "OK", publicEquipment);
    }

    @RequestMapping(value = "/listPublicEquipmentByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listPublicEquipmentByParamAndPage(@RequestBody PublicEquipmentRequest publicEquipmentRequest) {
        int pageNum = 1, pageSize = 100;
        if(publicEquipmentRequest.getPageNum() != 0) {
            pageNum = publicEquipmentRequest.getPageNum();
        }
        if(publicEquipmentRequest.getPageSize() != 0) {
            pageSize = publicEquipmentRequest.getPageSize();
        }
        PublicEquipment publicEquipment = publicEquipmentRequest.getPublicEquipment();
        if(publicEquipment == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<PublicEquipment> publicEquipmentList = publicEquipmentService.listPublicEquipmentByParamAndPage(publicEquipment, pageNum, pageSize);
        return new ResponseUtil(1, "OK", publicEquipmentList);
    }

}
