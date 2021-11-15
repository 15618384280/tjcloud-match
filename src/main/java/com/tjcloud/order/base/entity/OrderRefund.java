package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 退订表(order_refund)
 * @author auto bin.yin 2016.07.25
 */
@LogRequired
public class OrderRefund extends AbstractEntity {
	private static final long serialVersionUID = 1469426629456L;

	private String orderId; 					//订单Id
	private String refundNo; 					//退单订单号
	private Long refundAmount; 					//退款金额
	private Integer paymentType;				//退款方式：1-运动豆、2-场馆卡、3-次卡、4-支付宝、5-微信支付、6-红包支付、7-现金支付
	private Integer refundStatus; 				//1-退款中,2-退款成功,3-退款失败
	private Long refundTime; 					//退款日期
	private Integer reasonType; 				//退款原因类型，1-个人原因，2-其他原因
	private String remark; 						//退款备注

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public Long getRefundAmount() {
		return this.refundAmount;
	}
	public void setRefundAmount(Long refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	
	public Integer getRefundStatus() {
		return this.refundStatus;
	}
	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}

	public Long getRefundTime() {
		return this.refundTime;
	}
	public void setRefundTime(Long refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getReasonType() {
		return this.reasonType;
	}
	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}