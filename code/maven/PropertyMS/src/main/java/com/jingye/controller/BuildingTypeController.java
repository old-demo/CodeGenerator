package com.jingye.controller;

import com.jingye.entity.BuildingType;
import com.jingye.controller.request.BuildingTypeRequest;
import com.jingye.service.BuildingTypeService;
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
@RequestMapping("/buildingType")
public class BuildingTypeController {

    @Autowired
    BuildingTypeService buildingTypeService;

    @RequestMapping(value = "/saveBuildingType", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveBuildingType(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        BuildingType buildingType = buildingTypeRequest.getBuildingType();
        int result = buildingTypeService.saveBuildingType(buildingType);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateBuildingTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateBuildingTypeByKey(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        if(buildingTypeRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        BuildingType buildingType = buildingTypeRequest.getBuildingType();
        int result = buildingTypeService.updateBuildingTypeByKey(buildingType);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteBuildingTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBuildingTypeByKey(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        if(buildingTypeRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = buildingTypeService.deleteBuildingTypeByKey(buildingTypeRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchBuildingTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchBuildingTypeByKey(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        List<Integer> ids = buildingTypeRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = buildingTypeService.deleteBuildingTypeByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getBuildingTypeByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getBuildingTypeByKey(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        if(buildingTypeRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        BuildingType buildingType = buildingTypeService.getBuildingTypeByKey(buildingTypeRequest.getId());
        return new ResponseUtil(1, "OK", buildingType);
    }

    @RequestMapping(value = "/listBuildingTypeByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listBuildingTypeByParamAndPage(@RequestBody BuildingTypeRequest buildingTypeRequest) {
        int pageNum = 1, pageSize = 100;
        if(buildingTypeRequest.getPageNum() != 0) {
            pageNum = buildingTypeRequest.getPageNum();
        }
        if(buildingTypeRequest.getPageSize() != 0) {
            pageSize = buildingTypeRequest.getPageSize();
        }
        BuildingType buildingType = buildingTypeRequest.getBuildingType();
        if(buildingType == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<BuildingType> buildingTypeList = buildingTypeService.listBuildingTypeByParamAndPage(buildingType, pageNum, pageSize);
        return new ResponseUtil(1, "OK", buildingTypeList);
    }

}
