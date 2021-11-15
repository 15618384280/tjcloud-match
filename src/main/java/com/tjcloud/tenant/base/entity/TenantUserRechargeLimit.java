package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 充值卡表(tenant_user_recharge_limit)
 * @author auto bin.yin 2017.04.27
 */
public class TenantUserRechargeLimit extends AbstractEntity {
	private static final long serialVersionUID = 1493272110109L;

	private String userId; //用户id
	private String event; //

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEvent() {
		return this.event;
	}
	public void setEvent(String event) {
		this.event = event;
	}

}