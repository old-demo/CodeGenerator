package com.jingye.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 实体类
 * 
 * @author huangjingye
 * @email  754300150@qq.com
 * @date   2018-04-11 12:14:50
 */
public class RoomType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * rtName 房型
	 */
	@JSONField(name="rt_name")
	private String rtName;

    /**
	 * rtNote 备注
	 */
	@JSONField(name="rt_note")
	private String rtNote;

    /**
	 * rtId 房型id
	 */
	@JSONField(name="rt_id")
	private Integer rtId;

	public void setRtName(String rtName) {
		this.rtName = rtName;
	}

	public String getRtName() {
	    return rtName;
	}

	public void setRtNote(String rtNote) {
		this.rtNote = rtNote;
	}

	public String getRtNote() {
	    return rtNote;
	}

	public void setRtId(Integer rtId) {
		this.rtId = rtId;
	}

	public Integer getRtId() {
	    return rtId;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
