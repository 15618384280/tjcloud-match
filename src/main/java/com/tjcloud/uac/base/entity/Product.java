package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 产品表(uac_product)
 * @author auto bin.yin 2016.10.21
 */
public class Product extends AbstractEntity {
	private static final long serialVersionUID = 1477049082112L;

	private String code; //代号
	private String name; //名称
	private Long onlineTime; // 上线日期

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getOnlineTime() {
		return onlineTime;
	}
	public void setOnlineTime(Long onlineTime) {
		this.onlineTime = onlineTime;
	}
}