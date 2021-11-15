package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 二维码收款明细(order_code_pay)
 * @author auto bin.yin 2017.12.12
 */
public class OrderCodePay extends AbstractEntity {
	private static final long serialVersionUID = 1513059220146L;

	private String orderId;
	private String tenantId; //商户id
	private String stadiumId; //场馆
	private String stadiumName; //场馆名
	private Integer payType; //收款方式4-支付宝，5-微信
	private Long payAmount; //金额
	private Integer paymentStatus; //支付状态1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成

	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
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
	public Integer getPayType() {
		return this.payType;
	}
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	public Long getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}