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
public class BuildingInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
	 * bdAdminId 大楼管理员id
	 */
	@JSONField(name="bd_admin_id")
	private Integer bdAdminId;

    /**
	 * bdId 大楼编号
	 */
	@JSONField(name="bd_id")
	private String bdId;

    /**
	 * bdKindId 大楼类型
	 */
	@JSONField(name="bd_kind_id")
	private Integer bdKindId;

    /**
	 * bdHead 朝向
	 */
	@JSONField(name="bd_head")
	private String bdHead;

    /**
	 * id id
	 */
	@JSONField(name="id")
	private Integer id;

    /**
	 * bdArea 占地面积
	 */
	@JSONField(name="bd_area")
	private String bdArea;

    /**
	 * bdNote 备注
	 */
	@JSONField(name="bd_note")
	private String bdNote;

	public void setBdAdminId(Integer bdAdminId) {
		this.bdAdminId = bdAdminId;
	}

	public Integer getBdAdminId() {
	    return bdAdminId;
	}

	public void setBdId(String bdId) {
		this.bdId = bdId;
	}

	public String getBdId() {
	    return bdId;
	}

	public void setBdKindId(Integer bdKindId) {
		this.bdKindId = bdKindId;
	}

	public Integer getBdKindId() {
	    return bdKindId;
	}

	public void setBdHead(String bdHead) {
		this.bdHead = bdHead;
	}

	public String getBdHead() {
	    return bdHead;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	    return id;
	}

	public void setBdArea(String bdArea) {
		this.bdArea = bdArea;
	}

	public String getBdArea() {
	    return bdArea;
	}

	public void setBdNote(String bdNote) {
		this.bdNote = bdNote;
	}

	public String getBdNote() {
	    return bdNote;
	}

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
