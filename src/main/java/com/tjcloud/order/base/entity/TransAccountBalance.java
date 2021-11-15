package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 运动豆消费记录表(trans_account_balance)
 * @author auto bin.yin 2017.07.12
 */
public class TransAccountBalance extends AbstractEntity {
	private static final long serialVersionUID = 1499845252449L;

	private String userId; //用户id
	private String orderId; //订单id
	private String transactionId; //交易id
	private Integer payAmount; //交易金额
	private Integer balance; //运动豆余额
	private Integer transType; //交易方式 1-收入 2-消费
	private Long paymentTime; //交易时间

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
	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Integer getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getBalance() {
		return this.balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getTransType() {
		return this.transType;
	}
	public void setTransType(Integer transType) {
		this.transType = transType;
	}
	public Long getPaymentTime() {
		return this.paymentTime;
	}
	public void setPaymentTime(Long paymentTime) {
		this.paymentTime = paymentTime;
	}
}