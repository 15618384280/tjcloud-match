package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 闸机开门指令数据(stadium_item_dooropen)
 * @author auto bin.yin 2019.03.17
 */
public class StadiumItemDooropen extends AbstractEntity {
	private static final long serialVersionUID = 1552826407028L;

	private String tenantId; //所属商户,关键字段
	private String stadiumId; //所属场馆,关键字段
	private String stadiumName; //场馆名
	private String stadiumItemId; //子场馆ID
	private String stadiumItemName; //子场馆名称
	private String doorId; //门禁ID
	private String commandValue; //指令
	private String sendMessage; //开门成功推送消息文本对象
	private String userId; //用户ID
	private String orderId; //订单ID
	private String orderNo; //订单号
	private Integer openCount; //开门次数
	private Long payTime; 			//付款时间
	

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
	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getCommandValue() {
		return this.commandValue;
	}
	public void setCommandValue(String commandValue) {
		this.commandValue = commandValue;
	}
	public String getSendMessage() {
		return this.sendMessage;
	}
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOpenCount() {
		return openCount;
	}
	public void setOpenCount(Integer openCount) {
		this.openCount = openCount;
	}
	public Long getPayTime() {
		return payTime;
	}
	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}
	
}