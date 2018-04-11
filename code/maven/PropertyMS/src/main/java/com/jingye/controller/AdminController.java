package com.jingye.controller;

import com.jingye.entity.Admin;
import com.jingye.controller.request.AdminRequest;
import com.jingye.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/saveAdmin", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveAdmin(@RequestBody AdminRequest adminRequest) {
        Admin admin = adminRequest.getAdmin();
        int result = adminService.saveAdmin(admin);
        if(result == 1) {
            return new ResponseUtil(1, "创建成功！", null);
        }
        return new ResponseUtil(0, "创建失败！", null);
    }

    @RequestMapping(value = "/updateAdminByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateAdminByKey(@RequestBody AdminRequest adminRequest) {
        if(adminRequest.getAdTel() == null) {
            return new ResponseUtil(0, "联系电话不能为null！", null);
        }
        if(adminRequest.getAdName() == null) {
            return new ResponseUtil(0, "姓名不能为null！", null);
        }
        Admin admin = adminRequest.getAdmin();
        int result = adminService.updateAdminByKey(admin);
        if(result == 1) {
            return new ResponseUtil(1, "修改成功！", null);
        }
        return new ResponseUtil(0, "修改失败！", null);
    }

    @RequestMapping(value = "/deleteAdminByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteAdminByKey(@RequestBody AdminRequest adminRequest) {
        if(adminRequest.getAdId() == null) {
            return new ResponseUtil(0, "管理员id不能为null！", null);
        }
        int result = adminService.deleteAdminByKey(adminRequest.getAdId());
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", null);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/deleteBatchAdminByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchAdminByKey(@RequestBody AdminRequest adminRequest) {
        List<Integer> adIds = adminRequest.getAdIdList();
        if(adIds == null || adIds.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = adminService.deleteAdminByKey(adIds);
        if(result > 0) {
            return new ResponseUtil(1, "删除成功！", result);
        }
        return new ResponseUtil(0, "删除失败！", null);
    }

    @RequestMapping(value = "/getAdminByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getAdminByKey(@RequestBody AdminRequest adminRequest) {
        if(adminRequest.getAdId() == null) {
            return new ResponseUtil(0, "管理员id不能为null！", null);
        }
        Admin admin = adminService.getAdminByKey(adminRequest.getAdId());
        return new ResponseUtil(1, "OK", admin);
    }

    @RequestMapping(value = "/listAdminByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listAdminByParamAndPage(@RequestBody AdminRequest adminRequest) {
        int pageNum = 1, pageSize = 100;
        if(adminRequest.getPageNum() != 0) {
            pageNum = adminRequest.getPageNum();
        }
        if(adminRequest.getPageSize() != 0) {
            pageSize = adminRequest.getPageSize();
        }
        Admin admin = adminRequest.getAdmin();
        if(admin == null) {
            return new ResponseUtil(0, "不能为null！", null);
        }
        PageInfoUtil<Admin> adminList = adminService.listAdminByParamAndPage(admin, pageNum, pageSize);
        return new ResponseUtil(1, "OK", adminList);
    }

}
