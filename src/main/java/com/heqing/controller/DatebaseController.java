package com.heqing.controller;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.Datebase;
import com.heqing.service.DatebaseService;

import com.heqing.util.ObjectUtil;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 数据库连接信息对外接口层
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:28:39
 */
@RestController
@RequestMapping("/datebase/v1")
public class DatebaseController {

    @Autowired
    DatebaseService datebaseService;

    @RequestMapping(value = "/saveDatebase", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil saveDatebase(@RequestBody Datebase datebaseRequest) {
        int result = datebaseService.saveDatebase(datebaseRequest);
        if(result == 1) {
            return new ResponseUtil(1, "创建数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "创建数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/modifyDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil modifyDatebaseByKey(@RequestBody Datebase datebaseRequest) {
        if(datebaseRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = datebaseService.updateDatebaseByKey(datebaseRequest);
        if(result == 1) {
            return new ResponseUtil(1, "修改数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "修改数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/removeDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil removeDatebaseByKey(@RequestBody Datebase datebaseRequest) {
        if(datebaseRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        int result = datebaseService.deleteDatebaseByKey(datebaseRequest.getId());
        if(result > 0) {
            return new ResponseUtil(1, "删除数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "删除数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/getDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getDatebaseByKey(@RequestBody Datebase datebaseRequest) {
        if(datebaseRequest.getId() == null) {
            return new ResponseUtil(0, "id不能为null！", null);
        }
        Datebase datebase = datebaseService.getDatebaseByKey(datebaseRequest.getId());
        if(datebase != null) {
            return new ResponseUtil(1, "OK", datebase);
        }
        return new ResponseUtil(0, "无法找到"+datebaseRequest.getId()+"对应的数据库", null);
    }

    @RequestMapping(value = "/removeDatebaseByParam", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil removeBatchDatebaseByParam(@RequestBody Datebase datebaseRequest) {

        int result = datebaseService.deleteBatchDatebaseByParam(datebaseRequest);
        if(result > 0) {
            return new ResponseUtil(1, "删除数据库连接信息成功！", null);
        }
        return new ResponseUtil(0, "删除数据库连接信息失败！", null);
    }

    @RequestMapping(value = "/listDatebaseByPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listDatebaseByPage(@RequestBody Map map) {
        int pageIndex = 0, pageSize = 10;
        if(map.get("pageIndex") != null && !"".equals(map.get("pageIndex"))) {
            pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        }
        if(map.get("pageSize") != null && !"".equals(map.get("pageSize"))) {
            pageSize = Integer.parseInt(map.get("pageSize")+"");
        }
        PageInfo<Datebase> datebaseList = datebaseService.listDatebaseByPage(pageIndex, pageSize);
        return new ResponseUtil(1, "OK！", datebaseList);
    }

    @RequestMapping(value = "/listDatebaseByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listDatebaseByParamAndPage(@RequestBody Map map) {
        int pageIndex = 0, pageSize = 10;
        if(map.get("pageIndex") != null && !"".equals(map.get("pageIndex"))) {
            pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        }
        if(map.get("pageSize") != null && !"".equals(map.get("pageSize"))) {
            pageSize = Integer.parseInt(map.get("pageSize")+"");
        }
        Datebase datebase =  ObjectUtil.map2obj((Map<String, Object>)map.get("datebase"),Datebase.class);
        PageInfo<Datebase> datebaseList = datebaseService.listDatebaseByParamAndPage(datebase, pageIndex, pageSize);
        return new ResponseUtil(1, "OK！", datebaseList);
    }
}
