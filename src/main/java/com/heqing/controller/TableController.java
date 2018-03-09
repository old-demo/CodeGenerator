package com.heqing.controller;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.TableEntity;
import com.heqing.service.TableService;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 数据库表信息对外接口层
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:28:39
 */
@RestController
@RequestMapping("/table/v1")
public class TableController {

    @Autowired
    TableService tableService;

    @RequestMapping(value = "/getTableByName", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil getTableByName(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if(map.get("dbId") == null) {
            response.setCode(-1);
            response.setMsg("数据库id不能为null");
            return response;
        }
        if(map.get("tableName") == null) {
            response.setCode(-1);
            response.setMsg("数据库表名不能为null");
            return response;
        }

        TableEntity table = tableService.getTableByName((Integer) map.get("dbId"), (String) map.get("tableName"));
        if (table != null) {
            response.setCode(0);
            response.setData(table);
        } else {
            response.setCode(-1);
            response.setMsg("获取数据库表信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/listTable", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listTable(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if(map.get("dbId") == null) {
            response.setCode(-1);
            response.setMsg("数据库id不能为null");
            return response;
        }

        List<TableEntity> tableList = tableService.listTable((Integer) map.get("dbId"));
        if (tableList != null && tableList.size() > 0) {
            response.setCode(0);
            response.setMsg("OK");
            response.setData(tableList);
        } else {
            response.setCode(-1);
            response.setMsg("获取数据库表信息失败！");
        }
        return response;
    }

    @RequestMapping(value = "/listTableByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listTableByParamAndPage(@RequestBody Map map) {
        ResponseUtil response = new ResponseUtil();
        if(map.get("dbId") == null) {
            response.setCode(-1);
            response.setMsg("数据库id不能为null");
            return response;
        }
        if((map.get("pageIndex")==null) || (map.get("pageSize")==null)) {
            response.setCode(-1);
            response.setMsg("页码或每页数量不能为null");
            return response;
        }
        int pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        int pageSize = Integer.parseInt(map.get("pageSize")+"");
        String dbName = "";
        if(map.get("dbName") != null) {
            dbName = map.get("dbName")+"";
        }

        PageInfo<TableEntity> tableList = tableService.listTableByParamAndPage((Integer) map.get("dbId"), dbName, pageIndex, pageSize);
        if (tableList != null && tableList.getList().size() > 0) {
            response.setCode(0);
            response.setMsg("OK");
            response.setData(tableList);
        } else {
            response.setCode(-1);
            response.setMsg("获取数据库表信息失败！");
        }
        return response;
    }
}
