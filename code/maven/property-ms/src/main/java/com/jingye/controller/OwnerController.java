package com.jingye.controller;

import com.jingye.entity.Owner;
import com.jingye.controller.request.OwnerRequest;
import com.jingye.service.OwnerService;
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
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @RequestMapping(value = "/saveOwner", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveOwner(@RequestBody OwnerRequest ownerRequest) {
        Owner owner = ownerRequest.getOwner();
        if(owner == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = ownerService.saveOwner(owner);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateOwnerByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateOwnerByKey(@RequestBody OwnerRequest ownerRequest) {
        if(ownerRequest.getYzSex() == null) {
            return new ResponseUtil(0, "业主性别不能为null！", null);
        }
        if(ownerRequest.getYzId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        if(ownerRequest.getYzName() == null) {
            return new ResponseUtil(0, "业主姓名不能为null！", null);
        }
        if(ownerRequest.getYzPhone() == null) {
            return new ResponseUtil(0, "联系方式不能为null！", null);
        }
        Owner owner = ownerRequest.getOwner();
        if(owner == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        int result = ownerService.updateOwnerByKey(owner);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteOwnerByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteOwnerByKey(@RequestBody OwnerRequest ownerRequest) {
        if(ownerRequest.getYzId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        int result = ownerService.deleteOwnerByKey(ownerRequest.getYzId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchOwnerByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchOwnerByKey(@RequestBody OwnerRequest ownerRequest) {
        List<Integer> yzIds = ownerRequest.getYzIdList();
        if(yzIds == null || yzIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = ownerService.deleteOwnerByKey(yzIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getOwnerByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getOwnerByKey(@RequestBody OwnerRequest ownerRequest) {
        if(ownerRequest.getYzId() == null) {
            return new ResponseUtil(0, "业主id不能为null！", null);
        }
        Owner owner = ownerService.getOwnerByKey(ownerRequest.getYzId());
        return new ResponseUtil(1, "OK", owner);
    }

    @RequestMapping(value = "/listOwnerByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listOwnerByParamAndPage(@RequestBody OwnerRequest ownerRequest) {
        int pageNum = 1, pageSize = 100;
        if(ownerRequest.getPageNum() != 0) {
            pageNum = ownerRequest.getPageNum();
        }
        if(ownerRequest.getPageSize() != 0) {
            pageSize = ownerRequest.getPageSize();
        }
        Owner owner = ownerRequest.getOwner();
        if(owner == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Owner> ownerList = ownerService.listOwnerByParamAndPage(owner, pageNum, pageSize);
        return new ResponseUtil(1, "OK", ownerList);
    }

}
