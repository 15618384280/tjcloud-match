package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡支付记录表(trans_member_card)
 * @author auto bin.yin 2016.08.27
 */
public class TransMemberCard extends AbstractEntity {
	private static final long serialVersionUID = 1472269195335L;

	private String userId; //用户Id
	private String orderId; //订单ID
	private String transactionId; //交易Id
	private String tenantId; //租户Id
	private String memberCardId; //会员卡Id
	private String cardNo; //会员卡卡号
	private Long payAmount; //交易金额
	private Integer transType; //1-收入，2-支出
	private Long paymentTime; //申请支付日期
	private Integer balance;	// 余额
	private Integer type; //卡类型(1-充值卡,2-次卡,3-主从卡 4-时间卡)
	private Integer oneCostAmount;//每次消费金额


	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
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

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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

	public Long getPayAmount() {
		return this.payAmount;
	}
	public void setPayAmount(Long payAmount) {
		this.payAmount = payAmount;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getOneCostAmount() {
		return oneCostAmount;
	}

	public void setOneCostAmount(Integer oneCostAmount) {
		this.oneCostAmount = oneCostAmount;
	}
}