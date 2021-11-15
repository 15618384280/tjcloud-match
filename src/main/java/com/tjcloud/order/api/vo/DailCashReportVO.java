package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * 现金日报
 * @author lihongzhou
 */
public class DailCashReportVO implements Serializable{

	private static final long serialVersionUID = -2146464781892219747L;

	private Integer orderPayType;
	private String totalAmount;
	
	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
}
