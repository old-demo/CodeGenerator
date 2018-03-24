package com.heqing.util;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 结果返回工具类
 *
 * @author heqing
 * @date 2018/01/03
 */
public class ResponseUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private String msg;

    private Object data;

    public ResponseUtil() {}

    public ResponseUtil(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
