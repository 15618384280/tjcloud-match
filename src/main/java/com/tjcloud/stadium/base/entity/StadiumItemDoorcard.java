package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 管理员刷卡开关闸机(stadium_item_doorcard)
 * @author auto bin.yin 2018.05.21
 */
public class StadiumItemDoorcard extends AbstractEntity {
	private static final long serialVersionUID = 1526912564984L;

	private String doorId; //所属商户,关键字段
	private String name; //姓名
	private String employeeNo; //员工号
	private String insideNo; //卡片ID
	private String phone; //电话

	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInsideNo() {
		return this.insideNo;
	}
	public void setInsideNo(String insideNo) {
		this.insideNo = insideNo;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	
}