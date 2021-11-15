package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 运动豆充值订单明细表(order_yundou_recharge)
 * @author auto bin.yin 2016.08.17
 */
@LogRequired
public class OrderYundouRecharge extends AbstractEntity {
	private static final long serialVersionUID = 1471418486613L;

	private String orderId; //订单Id
	private String orderRefundId; //退订订单Id
	private Integer paymentStatus; //订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
	private Long amount; //金额
	private Long orderDate; //订单日期
	private String userId; //用户ID
	private Integer operate;	//0-用户充值 1-管理员充值 2-管理员扣款

	public Integer getOperate() {
		return operate;
	}
	public void setOperate(Integer operate) {
		this.operate = operate;
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderRefundId() {
		return this.orderRefundId;
	}
	public void setOrderRefundId(String orderRefundId) {
		this.orderRefundId = orderRefundId;
	}

	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getOrderDate() {
		return this.orderDate;
	}
	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}