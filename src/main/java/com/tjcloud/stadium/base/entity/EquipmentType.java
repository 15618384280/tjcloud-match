package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆-器材分类表(repair_equipment_type)
 * @author auto bin.yin 2017.09.11
 */
public class EquipmentType extends AbstractEntity {
	private static final long serialVersionUID = 1505119100284L;

	private String name; //器材名称
	private String features; //功能
	private String description; //说明
	private String imageUrl; //图片Url

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeatures() {
		return this.features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}