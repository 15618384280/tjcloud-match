package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class OrderResourceVO implements Serializable{

	private static final long serialVersionUID = 1478714505571737816L;

	private String orderId;
	private String orderFieldId;
	private String userId;
	private String userName;
	private String phone;
	private String fieldId;
	private String resourceDate;
	private String beginTime;
	private String endTime;
	private Integer orderType;
	private Integer orderStatus;
	private Integer channel;
	private Integer orderAttr;
	private Boolean profitSharing;
	
	public Integer getOrderAttr() {
		return orderAttr;
	}
	public void setOrderAttr(Integer orderAttr) {
		this.orderAttr = orderAttr;
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderFieldId() {
		return orderFieldId;
	}
	public void setOrderFieldId(String orderFieldId) {
		this.orderFieldId = orderFieldId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Boolean getProfitSharing() {
		return profitSharing;
	}

	public void setProfitSharing(Boolean profitSharing) {
		this.profitSharing = profitSharing;
	}
}
