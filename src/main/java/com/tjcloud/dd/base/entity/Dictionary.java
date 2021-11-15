package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 数据字典表(dictionary)
 * @author auto bin.yin 2016.05.12
 */
public class Dictionary extends AbstractEntity {
	private static final long serialVersionUID = 1463017950353L;

	private String key; //分类键值
	private String value; //值
	private String name; //名称

	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}