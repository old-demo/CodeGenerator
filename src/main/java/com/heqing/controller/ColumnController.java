package com.heqing.controller;

import com.heqing.entity.orm.ColumnEntity;
import com.heqing.service.ColumnService;
import com.heqing.service.DatebaseServiceExt;
import com.heqing.util.ResponseUtil;
import org.apache.ibatis.session.SqlSession;
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
@RequestMapping("/column/v1")
public class ColumnController {

    @Autowired
    DatebaseServiceExt datebaseServiceExt;

    @Autowired
    ColumnService columnService;

    @RequestMapping(value = "/listColumnByTable", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil listColumnByTable(@RequestBody Map map) {
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

        SqlSession sqlSession = datebaseServiceExt.getSqlSession((Integer) map.get("dbId"));
        if(sqlSession != null) {
            List<ColumnEntity> columnList = columnService.listColumnByTable(sqlSession, (String) map.get("tableName"));
            if (columnList != null) {
                response.setCode(0);
                response.setMsg("ok");
                response.setData(columnList);
            } else {
                response.setCode(-1);
                response.setMsg("获取数据库表中列的信息失败！");
            }
            sqlSession.clearCache();
            sqlSession.close();
        } else {
            response.setCode(-1);
            response.setMsg("获取数据库表中列的信息失败！");
        }
        return response;
    }
}
