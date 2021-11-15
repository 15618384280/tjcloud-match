package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡工本费(order_card_fee)
 * @author auto bin.yin 2018.03.06
 */
public class OrderCardFee extends AbstractEntity {
	private static final long serialVersionUID = 1520336784046L;

	private String orderId; //订单id
	private Integer paymentStatus; //订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
	private Long amount; //订单金额
	private String tenantId; //租户id
	private String stadiumId; //场馆id
	private String stadiumName; //场馆名
	private String memberCardId; //卡片id
	private String cardNo; //卡号
	private Integer feeType; //1-充值、2-消费、3-工本费、4-补卡手续费、5-封卡手续费、6-续卡费、7-、

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getMemberCardId() {
		return this.memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Integer getFeeType() {
		return this.feeType;
	}
	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
}