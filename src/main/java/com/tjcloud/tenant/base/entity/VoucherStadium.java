package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 代金券适用场馆表(voucher_stadium)
 * @author auto bin.yin 2018.11.28
 */
public class VoucherStadium extends AbstractEntity {
	private static final long serialVersionUID = 1543390416318L;

	private String tenantId; //租户ID
	private String stadiumId; //代金券的店铺id
	private String stadiumName; //场馆名
	private String activityId; //活动ID
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getActivityId() {
		return this.activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
}