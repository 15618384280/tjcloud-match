package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 角色菜单功能关联表(uac_role_menu_operation)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class RoleMenuOperation extends AbstractEntity {
	private static final long serialVersionUID = 1462848093214L;

	private String roleId; //角色ID
	private String menuId; //菜单ID
	private String operationId; //功能ID

	public String getRoleId() {
		return this.roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return this.menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getOperationId() {
		return this.operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
}