package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 角色租户数据权限表(uac_user_stadium_item)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class UserStadiumItem extends AbstractEntity {
	private static final long serialVersionUID = 1462848094605L;

	private String tenantUserId;        //用户ID
	private String stadiumId;     //场馆ID
	private String stadiumItemId; //场地ID

	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getTenantUserId() {
		return tenantUserId;
	}

	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
}