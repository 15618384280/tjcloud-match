package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 入驻申请与菜单关联表(tenant_apply_role)
 * @author auto bin.yin 2016.06.27
 */
@LogRequired
public class TenantApplyRole extends AbstractEntity {
	private static final long serialVersionUID = 1466993968233L;

	private String applyId; //申请Id
	private String objectId; //菜单/操作Id
	private Integer type; //菜单类型1-menuId 2-operation

	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	
	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}