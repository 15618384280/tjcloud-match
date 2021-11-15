package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 代金券适用场地类型表(voucher_place)
 * @author auto bin.yin 2018.11.28
 */
public class VoucherPlace extends AbstractEntity {
	private static final long serialVersionUID = 1543390416245L;

	private String tenantId; //租户ID
	private String stadiumId; //代金券的店铺id
	private String voucherId; //优惠券ID
	private String placeType; //代金券适用场地类型
	private Boolean disabled; //代金券状态(0.有效,1.失效)

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
	public String getVoucherId() {
		return this.voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	public String getPlaceType() {
		return this.placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}
	public Boolean getDisabled() {
		return this.disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
}