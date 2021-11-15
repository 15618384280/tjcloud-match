package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class OrderCodePayVO implements Serializable{

	private static final long serialVersionUID = 655483917497024086L;

	private String orderId;
	private String orderNo;
	private String userName;
	private Integer amount;
	private Integer payType;
	private Integer paymentStatus;
    private String stadiumId;
	private String stadiumName;
	private String payTime;
	private String payTypeText;
	private String paymentStatusText;
	
	private Integer aliCount;
	private Integer aliSum;
	private Integer wxCount;
	private Integer wxSum;
	private Integer totalSum;
	private Integer totalCount;
	
	public Integer getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(Integer totalSum) {
		this.totalSum = totalSum;
	}
	public Integer getAliCount() {
		return aliCount;
	}
	public void setAliCount(Integer aliCount) {
		this.aliCount = aliCount;
	}
	public Integer getAliSum() {
		return aliSum;
	}
	public void setAliSum(Integer aliSum) {
		this.aliSum = aliSum;
	}
	public Integer getWxCount() {
		return wxCount;
	}
	public void setWxCount(Integer wxCount) {
		this.wxCount = wxCount;
	}
	public Integer getWxSum() {
		return wxSum;
	}
	public void setWxSum(Integer wxSum) {
		this.wxSum = wxSum;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	public String getPayTime() {
		return payTime;
	}
	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	public String getPayTypeText() {
		return payTypeText;
	}
	public void setPayTypeText(String payTypeText) {
		this.payTypeText = payTypeText;
	}
	public String getPaymentStatusText() {
		return paymentStatusText;
	}
	public void setPaymentStatusText(String paymentStatusText) {
		this.paymentStatusText = paymentStatusText;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
