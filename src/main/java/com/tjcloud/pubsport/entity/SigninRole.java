package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (ps_signin_role)
 * @author auto bin.yin 2018.03.27
 */
public class SigninRole extends AbstractEntity {
	private static final long serialVersionUID = 1522119358564L;

	private String tenantId; //
	private String roleId; //

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}