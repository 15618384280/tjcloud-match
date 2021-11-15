package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员之家类型表(member_house_category)
 * @author cuike 2018.12.03
 */
public class MemberHouseCategory extends AbstractEntity {
	private static final long serialVersionUID = 1543390415932L;

	private String tenantId; //租户ID
	private String name; //分类名称
	private Integer orderNo; //排序
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
}
