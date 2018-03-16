package com.heqing.controller;

import com.github.pagehelper.PageInfo;
import com.heqing.entity.orm.Table;
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
    public ResponseUtil getTableByName(@RequestBody Table tableRequest) {
        if(tableRequest.getDbName() == null) {
            return new ResponseUtil(0, "数据库id不能为null！", null);
        }
        if(tableRequest.getTableName() == null) {
            return new ResponseUtil(0, "数据库表名不能为null！", null);
        }
        Table table = tableService.getTableByName(Integer.parseInt(tableRequest.getDbName()), tableRequest.getTableName());
        if(table != null) {
            return new ResponseUtil(1, "OK！", table);
        }
        return new ResponseUtil(0, "无法找到"+tableRequest.getDbName()+"对应的表", null);
    }

    @RequestMapping(value = "/listTable", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listTable(@RequestBody Table tableRequest) {
        if(tableRequest.getDbName() == null) {
            return new ResponseUtil(0, "数据库id不能为null！", null);
        }

        List<Table> tableList = tableService.listTable(Integer.parseInt(tableRequest.getDbName()));
        if (tableList != null && tableList.size() > 0) {
            return new ResponseUtil(1, "OK！", tableList);
        }
        return new ResponseUtil(0, "获取数据库表信息失败！", null);
    }

    @RequestMapping(value = "/listTableByParamAndPage", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listTableByParamAndPage(@RequestBody Map map) {
        if(map.get("dbId") == null) {
            return new ResponseUtil(0, "数据库id不能为null！", null);
        }
        int pageIndex = 0, pageSize = 10;
        if(map.get("pageIndex") != null && !"".equals(map.get("pageIndex"))) {
            pageIndex = Integer.parseInt(map.get("pageIndex")+"");
        }
        if(map.get("pageSize") != null && !"".equals(map.get("pageSize"))) {
            pageSize = Integer.parseInt(map.get("pageSize")+"");
        }
        String dbName = "";
        if(map.get("dbName") != null) {
            dbName = map.get("dbName")+"";
        }

        PageInfo<Table> tableList = tableService.listTableByParamAndPage((Integer) map.get("dbId"), dbName, pageIndex, pageSize);
        if (tableList != null && tableList.getList().size() > 0) {
            return new ResponseUtil(1, "OK！", tableList);
        }
        return new ResponseUtil(0, "获取数据库表信息失败！", null);
    }
}
