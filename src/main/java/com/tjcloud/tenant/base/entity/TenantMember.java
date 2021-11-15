package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 租户会员(tenant_member)
 * @author auto bin.yin 2016.08.08
 */
@LogRequired
public class TenantMember extends AbstractEntity {
	private static final long serialVersionUID = 1470639261177L;

	private String userId; 										//用户Id
	private String tenantId; 									//租户Id
	private String userName; 									//会员姓名
	private String phone; 										//手机号
	private String idCard; 										//身份证

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
}