package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 健身场所类型(ps_sports_place_type)
 * @author auto bin.yin 2018.02.27
 */
public class SportsPlaceType extends AbstractEntity {
	private static final long serialVersionUID = 1519719772443L;

	private String tenantId; //租户ID
	private String name; //名称

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}