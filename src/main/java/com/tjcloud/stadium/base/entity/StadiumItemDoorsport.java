package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 员工卡刷卡记录表(stadium_item_doorsport)
 * @author auto bin.yin 2019.03.13
 */
public class StadiumItemDoorsport extends AbstractEntity {
	private static final long serialVersionUID = 1552480481989L;

	private String tenantId; //
	private String doorId; //所属商户,关键字段
	private String stadiumId; //所属场馆,关键字段
	private String stadiumName; //场馆名
	private String stadiumItemId; //子场馆ID
	private String stadiumItemName; //子场馆名称
	private String name; //姓名
	private String employeeNo; //员工号
	private String insideNo; //卡片ID
	private String phone; //电话
	private Long entranceBeginTime; //入场时间
	private Long entranceEndTime; //出场时间
	private Integer playingMinute; //运动了多少分钟
	private Boolean entrance; //状态：0-运动中，1-运动结束

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
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
	public Long getEntranceBeginTime() {
		return this.entranceBeginTime;
	}
	public void setEntranceBeginTime(Long entranceBeginTime) {
		this.entranceBeginTime = entranceBeginTime;
	}
	public Long getEntranceEndTime() {
		return this.entranceEndTime;
	}
	public void setEntranceEndTime(Long entranceEndTime) {
		this.entranceEndTime = entranceEndTime;
	}
	public Integer getPlayingMinute() {
		return this.playingMinute;
	}
	public void setPlayingMinute(Integer playingMinute) {
		this.playingMinute = playingMinute;
	}
	public Boolean getEntrance() {
		return this.entrance;
	}
	public void setEntrance(Boolean entrance) {
		this.entrance = entrance;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	
}