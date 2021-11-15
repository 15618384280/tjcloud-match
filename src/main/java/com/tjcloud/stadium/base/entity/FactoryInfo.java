package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 二维码报修-厂家信息表(repair_factory_info)
 * @author auto bin.yin 2017.09.11
 */
public class FactoryInfo extends AbstractEntity {
	private static final long serialVersionUID = 1505119100240L;

	private String name; //厂家名称
	private String phone; //厂家联系电话

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}