package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目(stadium_item_readhead)
 * @author auto bin.yin 2018.05.14
 */
public class StadiumItemReadhead extends AbstractEntity {
	private static final long serialVersionUID = 1526289898070L;

	private String doorId; //所属商户,关键字段
	private String devicenumber; //读头编号
	private Boolean reader; //0-进,1-出

	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getDevicenumber() {
		return this.devicenumber;
	}
	public void setDevicenumber(String devicenumber) {
		this.devicenumber = devicenumber;
	}
	public Boolean getReader() {
		return this.reader;
	}
	public void setReader(Boolean reader) {
		this.reader = reader;
	}
	
	
}