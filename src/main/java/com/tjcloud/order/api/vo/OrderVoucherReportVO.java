package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class OrderVoucherReportVO implements Serializable{

	private static final long serialVersionUID = -3790463891718811063L;
	
    private String orderNo;
    private String phone;
    private String stadiumName;
    private String voucherName;
    private String orderAmount;
    private String platformDisAmount;
    private String actualAmount;
    private String createdTimeText;
    
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getVoucherName() {
		return voucherName;
	}
	public void setVoucherName(String voucherName) {
		this.voucherName = voucherName;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getPlatformDisAmount() {
		return platformDisAmount;
	}
	public void setPlatformDisAmount(String platformDisAmount) {
		this.platformDisAmount = platformDisAmount;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getCreatedTimeText() {
		return createdTimeText;
	}
	public void setCreatedTimeText(String createdTimeText) {
		this.createdTimeText = createdTimeText;
	}
}
