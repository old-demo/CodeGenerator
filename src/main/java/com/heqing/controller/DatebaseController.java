package com.heqing.controller;

import com.heqing.controller.request.DatebaseRequest;
import com.heqing.entity.orm.Datebase;
import com.heqing.service.DatebaseService;
import com.heqing.util.PageInfoUtil;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库连接信息对外接口层
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-03-18 21:57:48
 */
@RestController
@RequestMapping("/datebase")
public class DatebaseController {

    @Autowired
    DatebaseService datebaseService;

    @RequestMapping(value = "/saveDatebase", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveDatebase(@RequestBody DatebaseRequest datebaseRequest) {
        Datebase datebase = datebaseRequest.getDatebase();
        if(datebase == null) {
            return new ResponseUtil(0, "数据库信息不能为null！", null);
        }
        int result = datebaseService.saveDatebase(datebase);
        if(result == 1) {
            return new ResponseUtil(1, "创建数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "创建数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/updateDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil updateDatebaseByKey(@RequestBody DatebaseRequest datebaseRequest) {
        Datebase datebase = datebaseRequest.getDatebase();
        if(datebase == null) {
            return new ResponseUtil(0, "数据库信息不能为null！", null);
        }
        int result = datebaseService.updateDatebaseByKey(datebase);
        if(result == 1) {
            return new ResponseUtil(1, "修改数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "修改数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/deleteDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteDatebaseByKey(@RequestBody DatebaseRequest datebaseRequest) {
        if(datebaseRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = datebaseService.deleteDatebaseByKey(datebaseRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "删除数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/deleteBatchDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil deleteBatchDatebaseByKey(@RequestBody DatebaseRequest datebaseRequest) {
        List<Integer> ids = datebaseRequest.getIds();
        if(ids == null || ids.size() < 1) {
            return new ResponseUtil(0, "主键不能为null！", null);
        }
        int result = datebaseService.deleteBatchDatebaseByKey(ids);
        if(result > 0) {
            return new ResponseUtil(1, "删除数据库连接信息成功！", result);
        }
        return new ResponseUtil(0, "删除数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/getDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getDatebaseByKey(@RequestBody DatebaseRequest datebaseRequest) {
        if(datebaseRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        Datebase datebase = datebaseService.getDatebaseByKey(datebaseRequest.getId());
        return new ResponseUtil(1, "OK", datebase.toString());
    }

    @RequestMapping(value = "/listDatebaseByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listDatebaseByParamAndPage(@RequestBody DatebaseRequest datebaseRequest) {
        int pageNum = 1, pageSize = 100;
        if(datebaseRequest.getPageNum() != 0) {
            pageNum = datebaseRequest.getPageNum();
        }
        if(datebaseRequest.getPageSize() != 0) {
            pageSize = datebaseRequest.getPageSize();
        }
        Datebase datebase = datebaseRequest.getDatebase();
        if(datebase == null) {
            return new ResponseUtil(0, "数据库信息不能为null！", null);
        }
        PageInfoUtil<Datebase> datebaseList = datebaseService.listDatebaseByParamAndPage(datebase, pageNum, pageSize);
        return new ResponseUtil(1, "OK", datebaseList);
    }
}
