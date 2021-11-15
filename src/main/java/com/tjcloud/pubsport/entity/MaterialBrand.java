package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 器材品牌(ps_material_brand)
 * @author auto bin.yin 2018.02.27
 */
public class MaterialBrand extends AbstractEntity {
	private static final long serialVersionUID = 1519719771237L;

	private String tenantId; //租户ID
	private String factoryId; //厂商ID
	private String factoryName; //厂商名称
	private String name; //名称

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}