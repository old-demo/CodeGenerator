package com.heqing.controller;

import com.heqing.controller.request.DatebaseRequest;
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
    public ResponseUtil checkConnect(@RequestBody DatebaseRequest datebaseRequest) {
        Datebase datebase = datebaseRequest.getDatebase();
        if(datebase == null) {
            return new ResponseUtil(0, "数据库信息不能为null！", null);
        }
        if(datebase.getDriver() == null && "".equals(datebase.getDriver())) {
            return new ResponseUtil(0, "数据库方言不能为null或空字符串！", null);
        }
        if(datebase.getUrl() == null && "".equals(datebase.getUrl())) {
            return new ResponseUtil(0, "数据库连接地址不能为null或空字符串！", null);
        }
        if(datebase.getPort() == null && "".equals(datebase.getPort())) {
            return new ResponseUtil(0, "数据库连接地址端口号不能为null或空字符串！", null);
        }
        if(datebase.getDbName() == null && "".equals(datebase.getDbName())) {
            return new ResponseUtil(0, "数据库名不能为null或空字符串！", null);
        }
        if(datebase.getUsername() == null && "".equals(datebase.getUsername())) {
            return new ResponseUtil(0, "用户登陆名不能为null或空字符串！", null);
        }
        if(datebase.getPassword() == null && "".equals(datebase.getPassword())) {
            return new ResponseUtil(0, "用户登录密码不能为null或空字符串！", null);
        }

        Boolean conn = datebaseServiceExt.connect(datebase);
        if (conn != null) {
            return new ResponseUtil(1, "数据库连接成功！", null);
        }
        return new ResponseUtil(0, "数据库连接失败！", null);
    }
}
