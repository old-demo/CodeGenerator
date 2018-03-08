package com.heqing.controller;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.Datebase;
import com.heqing.service.DatebaseService;

import com.heqing.util.ObjectUtil;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public ResponseUtil saveDatebase(@RequestBody Datebase datebase) {
        ResponseUtil response = new ResponseUtil();
        int result = datebaseService.saveDatebase(datebase);
        if(result == 1) {
            response.setCode(0);
            response.setMsg("创建数据库连接信息成功！");
        } else {
            response.setCode(-1);
            response.setMsg("创建数据库连接信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/modifyDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil modifyDatebaseByKey(@RequestBody Datebase datebase) {
        ResponseUtil response = new ResponseUtil();
        if(datebase.getId() == null) {
            response.setCode(-1);
            response.setMsg("id不能为null");
            return response;
        }
        int result = datebaseService.modifyDatebaseByKey(datebase);
        if(result == 1) {
            response.setCode(0);
            response.setMsg("修改数据库连接信息成功！");
        } else {
            response.setCode(-1);
            response.setMsg("修改数据库连接信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/removeDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil removeDatebaseByKey(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if(map.get("id") == null) {
            response.setCode(-1);
            response.setMsg("id不能为null");
            return response;
        }
        int result = datebaseService.removeDatebaseByKey((Integer)map.get("id"));
        if(result > 0) {
            response.setCode(0);
            response.setMsg("删除数据库连接信息成功！");
        } else {
            response.setCode(-1);
            response.setMsg("删除数据库连接信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/getDatebaseByKey", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getDatebaseByKey(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if(map.get("id") == null) {
            response.setCode(-1);
            response.setMsg("id不能为null");
            return response;
        }
        Datebase datebase = datebaseService.getDatebaseByKey((Integer)map.get("id"));
        response.setCode(0);
        response.setData(datebase);
        return response;
    }

    @RequestMapping(value = "/removeDatebaseByParam", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil removeBatchDatebaseByParam(@RequestBody Datebase datebase) {

        ResponseUtil response = new ResponseUtil();
        int result = datebaseService.removeBatchDatebaseByParam(datebase);
        if(result > 0) {
            response.setCode(0);
            response.setMsg("删除数据库连接信息成功！");
        } else {
            response.setCode(-1);
            response.setMsg("删除数据库连接信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/listDatebaseByPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listDatebaseByPage(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if((map.get("pageIndex")==null) || (map.get("pageSize")==null)) {
            response.setCode(-1);
            response.setMsg("页码或每页数量不能为null");
            return response;
        }

        int pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        int pageSize = Integer.parseInt(map.get("pageSize")+"");
        PageInfo<Datebase> datebaseList = datebaseService.listDatebaseByPage(pageIndex, pageSize);
        response.setCode(0);
        Map<String, Object> responseMap = new HashMap<>(16);
        responseMap.put("page", datebaseList);
        response.setData(responseMap);
        return response;
    }

    @RequestMapping(value = "/listDatebaseByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listDatebaseByParamAndPage(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if((map.get("pageIndex")==null) || (map.get("pageSize")==null)) {
            response.setCode(-1);
            response.setMsg("页码或每页数量不能为null");
            return response;
        }
        if(map.get("datebase") == null) {
            response.setCode(-1);
            response.setMsg("查询条件不能为null");
            return response;
        }
        Datebase datebase =  ObjectUtil.map2obj((Map<String, Object>)map.get("datebase"),Datebase.class);
        int pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        int pageSize = Integer.parseInt(map.get("pageSize")+"");
        PageInfo<Datebase> datebaseList = datebaseService.listDatebaseByParamAndPage(datebase, pageIndex, pageSize);
        response.setCode(0);
        Map<String, Object> responseMap = new HashMap<>(16);
        responseMap.put("page", datebaseList);
        response.setData(responseMap);
        return response;
    }
}
