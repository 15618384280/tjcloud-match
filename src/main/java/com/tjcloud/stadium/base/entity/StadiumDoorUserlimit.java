package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目(stadium_door_userlimit)
 * @author auto bin.yin 2018.04.19
 */
public class StadiumDoorUserlimit extends AbstractEntity {
	private static final long serialVersionUID = 1524127819521L;

	private String doorId; //所属主板ID
	private String tenantUserId; //管理员ID
	private String stadiumId; //所属场馆,关键字段

	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getTenantUserId() {
		return this.tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	
}