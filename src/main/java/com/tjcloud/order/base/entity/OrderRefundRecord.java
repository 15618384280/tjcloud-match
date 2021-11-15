package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 退款记录(order_refund_record)
 * @author auto bin.yin 2017.11.16
 */
public class OrderRefundRecord extends AbstractEntity {
	private static final long serialVersionUID = 1510812126627L;

	private String orderId; //订单id
	private String orderNo; //订单号
	private Long amount;	//退款金额
	private Integer payType;	//付款类型 1-运动豆 4-支付宝 5-微信
	private Boolean isSuccess; //是否成功
	
	public Integer getPayType() {
		return payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
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
	public Boolean getIsSuccess() {
		return this.isSuccess;
	}
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}