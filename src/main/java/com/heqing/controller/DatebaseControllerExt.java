package com.heqing.controller;

import com.heqing.entity.orm.Datebase;
import com.heqing.service.impl.DatebaseServiceImplExt;
import com.heqing.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 数据库连接信息对外接口层
 *
 * @author heqing
 * @email  975656343@qq.com
 * @date   2018-02-02 09:28:39
 */
@RestController
@RequestMapping("/datebase/v1")
public class DatebaseControllerExt {

    @Autowired
    DatebaseServiceImplExt datebaseServiceExt;

    @RequestMapping(value = "/checkConnect", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public ResponseUtil checkConnect(@RequestBody Datebase datebase) {
        ResponseUtil response = new ResponseUtil();
        if(datebase.getDriver() == null && "".equals(datebase.getDriver())) {
            response.setCode(-1);
            response.setMsg("数据库方言不能为null或空字符串！");
            return response;
        }
        if(datebase.getUrl() == null && "".equals(datebase.getUrl())) {
            response.setCode(-1);
            response.setMsg("数据库连接地址不能为null或空字符串！");
            return response;
        }
        if(datebase.getPort() == null && "".equals(datebase.getPort())) {
            response.setCode(-1);
            response.setMsg("数据库连接地址端口号不能为null或空字符串！");
            return response;
        }
        if(datebase.getDbName() == null && "".equals(datebase.getDbName())) {
            response.setCode(-1);
            response.setMsg("数据库名不能为null或空字符串！");
            return response;
        }
        if(datebase.getUsername() == null && "".equals(datebase.getUsername())) {
            response.setCode(-1);
            response.setMsg("用户登陆名不能为null或空字符串！");
            return response;
        }
        if(datebase.getPassword() == null && "".equals(datebase.getPassword())) {
            response.setCode(-1);
            response.setMsg("用户登录密码不能为null或空字符串！");
            return response;
        }

        Boolean conn = datebaseServiceExt.connect(datebase);
        if (conn != null) {
            response.setCode(0);
            response.setMsg("数据库连接成功！");
        } else {
            response.setCode(-1);
            response.setMsg("数据库连接失败！");
        }
        return response;
    }
}
