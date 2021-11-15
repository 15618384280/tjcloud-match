package com.tjcloud.order.api.vo;

import java.io.Serializable;
import java.util.List;

public class UserOrderInfoVO implements Serializable{

	private static final long serialVersionUID = -5252224857983051326L;

	private String orderId;
	private String orderNo;
	private Integer orderType;
	private String userId;
	private String userName;
	private String phone;
	private String orderAmount;
	private String actualAmount;
	private String refundTotalAmount;
	private Integer orderStatus;
	private String orderStatusTxt;
	private Integer paymentType;
	private String paymentTypeTxt;
	private String createdTimeTxt;
	private Integer channel;
	private String channelText;
	
	private String stadiumItemName;		//项目名
	private String sportType;			//类型
	private String address;				//地址
	//订单明细
	private String orderDetailId;
	private String resourceDate;
	private String fieldName;
	private String beginTime;
	private String endTime;
	private String amount;
	private Integer paymentStatus;
	private String paymentStatusTxt;
	private Integer ticketNum;
	private String stadiumTicketName;
	private Integer invoiceStatus;
	
	List<UserOrderInfoVO> orderDetails;
	
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getChannelText() {
		return channelText;
	}
	public void setChannelText(String channelText) {
		this.channelText = channelText;
	}
	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public String getPaymentStatusTxt() {
		return paymentStatusTxt;
	}
	public void setPaymentStatusTxt(String paymentStatusTxt) {
		this.paymentStatusTxt = paymentStatusTxt;
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
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(String actualAmount) {
		this.actualAmount = actualAmount;
	}
	public String getRefundTotalAmount() {
		return refundTotalAmount;
	}
	public void setRefundTotalAmount(String refundTotalAmount) {
		this.refundTotalAmount = refundTotalAmount;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderStatusTxt() {
		return orderStatusTxt;
	}
	public void setOrderStatusTxt(String orderStatusTxt) {
		this.orderStatusTxt = orderStatusTxt;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentTypeTxt() {
		return paymentTypeTxt;
	}
	public void setPaymentTypeTxt(String paymentTypeTxt) {
		this.paymentTypeTxt = paymentTypeTxt;
	}
	public String getCreatedTimeTxt() {
		return createdTimeTxt;
	}
	public void setCreatedTimeTxt(String createdTimeTxt) {
		this.createdTimeTxt = createdTimeTxt;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public String getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Integer getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}
	public String getStadiumTicketName() {
		return stadiumTicketName;
	}
	public void setStadiumTicketName(String stadiumTicketName) {
		this.stadiumTicketName = stadiumTicketName;
	}
	public List<UserOrderInfoVO> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<UserOrderInfoVO> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
