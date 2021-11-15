package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 器材厂商(ps_material_factory)
 * @author auto bin.yin 2018.02.27
 */
public class MaterialFactory extends AbstractEntity {
	private static final long serialVersionUID = 1519719771436L;

	private String tenantId; //租户ID
	private String name; //名称
	private String tel; //电话

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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}