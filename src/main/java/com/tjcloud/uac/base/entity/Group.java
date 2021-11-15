package com.tjcloud.uac.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 组织部门表(uac_group)
 * @author auto bin.yin 2016.10.21
 */
public class Group extends AbstractEntity {
	private static final long serialVersionUID = 1477049081917L;

	private String type; //类型(folder/item)
	private String icon; //图标
	private String name; //名称
	private String orderNo;  //序号
	private String areaId;   //区域
	private String tenantId; //租户ID
	private String parentId; //产品ID

	public Boolean isFolder() {
		return Constants.TreeType.FOLDER.equals(type);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAreaId() {
		return this.areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getParentId() {
		return this.parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}