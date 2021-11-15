package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目(stadium_item_door)
 * @author auto bin.yin 2017.11.30
 */
public class StadiumItemDoor extends AbstractEntity {
	private static final long serialVersionUID = 1512028585974L;

	private String tenantId; //所属商户,关键字段
	private String stadiumId; //所属场馆,关键字段
	private String stadiumName; //场馆名
	private String stadiumItemId; //子场馆ID
	private String stadiumItemName; //子场馆名称
	private String serialIp; //设备IP地址
	private String serialNo; //设备的序列号
	private String serialId; //设备的自定义标识符，请在WEB界面设置。
	private String userName; //设备的用户名。
	private String password; //设备的密码。
	private String port; 	 //设备的端口。
	private Integer asystole; //闸机心跳停止多少分钟开始报警
	private Integer type; 	  //0-闸机刷卡，1-用于读卡

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getSerialIp() {
		return this.serialIp;
	}
	public void setSerialIp(String serialIp) {
		this.serialIp = serialIp;
	}
	public String getSerialNo() {
		return this.serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSerialId() {
		return this.serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public Integer getAsystole() {
		return this.asystole;
	}
	public void setAsystole(Integer asystole) {
		this.asystole = asystole;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	
}