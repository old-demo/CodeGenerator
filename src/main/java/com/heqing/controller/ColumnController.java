package com.heqing.controller;

import com.heqing.controller.request.ColumnRequest;
import com.heqing.entity.orm.Column;
import com.heqing.service.ColumnService;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据库表信息对外接口层
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:28:39
 */
@RestController
@RequestMapping("/column/v1")
public class ColumnController {

    @Autowired
    ColumnService columnService;

    @RequestMapping(value = "/listColumnByTable", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listColumnByTable(@RequestBody ColumnRequest columnRequest) {
        if(columnRequest.getDbId() == 0) {
            return new ResponseUtil(0, "数据库id不能为null！", null);
        }
        if(columnRequest.getTableName() == null) {
            return new ResponseUtil(0, "数据库表名不能为null！", null);
        }

        List<Column> columnList = columnService.listColumnByTable(columnRequest.getDbId(), columnRequest.getTableName());
        if (columnList != null) {
            return new ResponseUtil(1, "OK！", columnList);
        }
        return new ResponseUtil(0, "获取数据库表中列的信息失败！", null);
    }
}
