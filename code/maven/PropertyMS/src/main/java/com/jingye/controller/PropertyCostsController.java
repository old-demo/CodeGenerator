package com.jingye.controller;

import com.jingye.entity.PropertyCosts;
import com.jingye.controller.request.PropertyCostsRequest;
import com.jingye.service.PropertyCostsService;
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
@RequestMapping("/propertyCosts")
public class PropertyCostsController {

    @Autowired
    PropertyCostsService propertyCostsService;

    @RequestMapping(value = "/savePropertyCosts", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil savePropertyCosts(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        PropertyCosts propertyCosts = propertyCostsRequest.getPropertyCosts();
        int result = propertyCostsService.savePropertyCosts(propertyCosts);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updatePropertyCostsByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updatePropertyCostsByKey(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        if(propertyCostsRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        PropertyCosts propertyCosts = propertyCostsRequest.getPropertyCosts();
        int result = propertyCostsService.updatePropertyCostsByKey(propertyCosts);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deletePropertyCostsByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deletePropertyCostsByKey(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        if(propertyCostsRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = propertyCostsService.deletePropertyCostsByKey(propertyCostsRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchPropertyCostsByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchPropertyCostsByKey(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        List<Integer> ids = propertyCostsRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = propertyCostsService.deletePropertyCostsByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getPropertyCostsByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getPropertyCostsByKey(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        if(propertyCostsRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        PropertyCosts propertyCosts = propertyCostsService.getPropertyCostsByKey(propertyCostsRequest.getId());
        return new ResponseUtil(1, "OK", propertyCosts);
    }

    @RequestMapping(value = "/listPropertyCostsByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listPropertyCostsByParamAndPage(@RequestBody PropertyCostsRequest propertyCostsRequest) {
        int pageNum = 1, pageSize = 100;
        if(propertyCostsRequest.getPageNum() != 0) {
            pageNum = propertyCostsRequest.getPageNum();
        }
        if(propertyCostsRequest.getPageSize() != 0) {
            pageSize = propertyCostsRequest.getPageSize();
        }
        PropertyCosts propertyCosts = propertyCostsRequest.getPropertyCosts();
        if(propertyCosts == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<PropertyCosts> propertyCostsList = propertyCostsService.listPropertyCostsByParamAndPage(propertyCosts, pageNum, pageSize);
        return new ResponseUtil(1, "OK", propertyCostsList);
    }

}
