package com.tjcloud.uac.api.vo;

import com.tjcloud.uac.base.entity.User;

import java.io.Serializable;

public class UserListVO extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7078772122233534970L;
	private String tenantName ;
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
}

