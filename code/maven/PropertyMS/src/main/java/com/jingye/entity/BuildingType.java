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
 * @date   2018-04-11 12:14:49
 */
public class BuildingType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * id id
	 */
	@JSONField(name="id")
	private Integer id;

    /**
	 * btNote 备注
	 */
	@JSONField(name="bt_note")
	private String btNote;

    /**
	 * btName 大楼类型
	 */
	@JSONField(name="bt_name")
	private String btName;

    /**
	 * btRoomNumber 住宅户数
	 */
	@JSONField(name="bt_room_number")
	private Integer btRoomNumber;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	    return id;
	}

	public void setBtNote(String btNote) {
		this.btNote = btNote;
	}

	public String getBtNote() {
	    return btNote;
	}

	public void setBtName(String btName) {
		this.btName = btName;
	}

	public String getBtName() {
	    return btName;
	}

	public void setBtRoomNumber(Integer btRoomNumber) {
		this.btRoomNumber = btRoomNumber;
	}

	public Integer getBtRoomNumber() {
	    return btRoomNumber;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
