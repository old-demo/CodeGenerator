package com.jingye.controller;

import com.jingye.entity.BuildingInfo;
import com.jingye.controller.request.BuildingInfoRequest;
import com.jingye.service.BuildingInfoService;
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
@RequestMapping("/buildingInfo")
public class BuildingInfoController {

    @Autowired
    BuildingInfoService buildingInfoService;

    @RequestMapping(value = "/saveBuildingInfo", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveBuildingInfo(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        BuildingInfo buildingInfo = buildingInfoRequest.getBuildingInfo();
        int result = buildingInfoService.saveBuildingInfo(buildingInfo);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateBuildingInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateBuildingInfoByKey(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        if(buildingInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        BuildingInfo buildingInfo = buildingInfoRequest.getBuildingInfo();
        int result = buildingInfoService.updateBuildingInfoByKey(buildingInfo);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteBuildingInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBuildingInfoByKey(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        if(buildingInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = buildingInfoService.deleteBuildingInfoByKey(buildingInfoRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchBuildingInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchBuildingInfoByKey(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        List<Integer> ids = buildingInfoRequest.getIdList();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = buildingInfoService.deleteBuildingInfoByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getBuildingInfoByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getBuildingInfoByKey(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        if(buildingInfoRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        BuildingInfo buildingInfo = buildingInfoService.getBuildingInfoByKey(buildingInfoRequest.getId());
        return new ResponseUtil(1, "OK", buildingInfo);
    }

    @RequestMapping(value = "/listBuildingInfoByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listBuildingInfoByParamAndPage(@RequestBody BuildingInfoRequest buildingInfoRequest) {
        int pageNum = 1, pageSize = 100;
        if(buildingInfoRequest.getPageNum() != 0) {
            pageNum = buildingInfoRequest.getPageNum();
        }
        if(buildingInfoRequest.getPageSize() != 0) {
            pageSize = buildingInfoRequest.getPageSize();
        }
        BuildingInfo buildingInfo = buildingInfoRequest.getBuildingInfo();
        if(buildingInfo == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<BuildingInfo> buildingInfoList = buildingInfoService.listBuildingInfoByParamAndPage(buildingInfo, pageNum, pageSize);
        return new ResponseUtil(1, "OK", buildingInfoList);
    }

}
