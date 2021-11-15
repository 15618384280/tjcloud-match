package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 用户角色表(uac_user_role)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class UserRole extends AbstractEntity {
	private static final long serialVersionUID = 1462848094254L;

	private String tenantUserId; //用户ID
	private String roleId; //角色ID

	private String userId;

	public UserRole(String userId, String tenantUserId, String roleId) {
		this.setUserId(userId);
		this.setTenantUserId(tenantUserId);
		this.setRoleId(roleId);
	}

	public UserRole() {

	}

	public String getTenantUserId() {
		return this.tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}