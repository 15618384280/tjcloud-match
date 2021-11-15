package com.tjcloud.uac.base.entity;

import java.util.List;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 角色菜单功能关联表(uac_role_operation)
 * @author auto bin.yin 2016.11.14
 */
public class RoleOperation extends AbstractEntity {
	private static final long serialVersionUID = 1479112372869L;

	private String roleId; //角色ID
	private String operationId; //功能ID
	private String beginTime; //生效时间
	private String endTime; //失效时间
	
	private List<String> operationIds;

	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getOperationId() {
		return this.operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public List<String> getOperationIds() {
		return operationIds;
	}
	public void setOperationIds(List<String> operationIds) {
		this.operationIds = operationIds;
	}
}