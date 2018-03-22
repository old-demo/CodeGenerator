package com.jingye.controller;

import com.jingye.entity.Building;
import com.jingye.controller.request.BuildingRequest;
import com.jingye.service.BuildingService;
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
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    BuildingService buildingService;

    @RequestMapping(value = "/saveBuilding", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveBuilding(@RequestBody BuildingRequest buildingRequest) {
        Building building = buildingRequest.getBuilding();
        if(building == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = buildingService.saveBuilding(building);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateBuildingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateBuildingByKey(@RequestBody BuildingRequest buildingRequest) {
        if(buildingRequest.getBuildingHead() == null) {
            return new ResponseUtil(0, "朝向不能为null！", null);
        }
        if(buildingRequest.getBulidingArea() == null) {
            return new ResponseUtil(0, "面积不能为null！", null);
        }
        if(buildingRequest.getBuildingKind() == null) {
            return new ResponseUtil(0, "类型不能为null！", null);
        }
        if(buildingRequest.getBuildingId() == null) {
            return new ResponseUtil(0, "大楼编号不能为null！", null);
        }
        if(buildingRequest.getBulidingLevel() == null) {
            return new ResponseUtil(0, "层数不能为null！", null);
        }
        Building building = buildingRequest.getBuilding();
        if(building == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = buildingService.updateBuildingByKey(building);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteBuildingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBuildingByKey(@RequestBody BuildingRequest buildingRequest) {
        if(buildingRequest.getBuildingId() == null) {
            return new ResponseUtil(0, "大楼编号不能为null！", null);
        }
        int result = buildingService.deleteBuildingByKey(buildingRequest.getBuildingId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchBuildingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchBuildingByKey(@RequestBody BuildingRequest buildingRequest) {
        List<Integer> buildingIds = buildingRequest.getBuildingIdList();
        if(buildingIds == null || buildingIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = buildingService.deleteBuildingByKey(buildingIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getBuildingByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getBuildingByKey(@RequestBody BuildingRequest buildingRequest) {
        if(buildingRequest.getBuildingId() == null) {
            return new ResponseUtil(0, "大楼编号不能为null！", null);
        }
        Building building = buildingService.getBuildingByKey(buildingRequest.getBuildingId());
        return new ResponseUtil(1, "OK", building);
    }

    @RequestMapping(value = "/listBuildingByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listBuildingByParamAndPage(@RequestBody BuildingRequest buildingRequest) {
        int pageNum = 1, pageSize = 100;
        if(buildingRequest.getPageNum() != 0) {
            pageNum = buildingRequest.getPageNum();
        }
        if(buildingRequest.getPageSize() != 0) {
            pageSize = buildingRequest.getPageSize();
        }
        Building building = buildingRequest.getBuilding();
        if(building == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Building> buildingList = buildingService.listBuildingByParamAndPage(building, pageNum, pageSize);
        return new ResponseUtil(1, "OK", buildingList);
    }

}
