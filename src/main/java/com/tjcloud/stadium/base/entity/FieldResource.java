package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场地资源表(field_resource)
 * @author auto bin.yin 2016.06.03
 */
@LogRequired
public class FieldResource extends AbstractEntity {
	private static final long serialVersionUID = 1464942279024L;

	private String fieldId; //场地Id
	private String resource; //场地资源,比特串1占用0可用
	private String resourceDate; //资源日期

	public String getFieldId() {
		return this.fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getResource() {
		return this.resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}
}