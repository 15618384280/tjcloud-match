package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.OrderInvoice;

public class OrderInvoiceVO extends OrderInvoice{

	private static final long serialVersionUID = -63345058307344834L;

	private String userId;
	private String orderNo;
	private String userPhone;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}
