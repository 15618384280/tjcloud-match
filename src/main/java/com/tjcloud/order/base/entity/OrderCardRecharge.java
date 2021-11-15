package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡充值订单明细表(order_card_recharge)
 * @author auto bin.yin 2016.09.16
 */
@LogRequired
public class OrderCardRecharge extends AbstractEntity {
	private static final long serialVersionUID = 1473998106803L;

	private String orderId; 				//订单Id
	private String orderRefundId; 			//退订订单Id
	private Integer paymentStatus; 			//订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
	private Long amount; 					//金额
	private Long orderDate; 				//订单日期
	private String tenantId; 				//租户ID
	private String stadiumId;				//场馆id
	private String memberId; 				//会员ID
	private String userId; 					//用户ID
	private String memberCardId; 			//会员卡ID
	private String cardNo; 					//会员卡卡号
	private Integer cardType;				//1-充值卡,2-次卡,4-时间卡
	private Long rechargeValue; 			//充值的值
	private String operateUserId; 			//操作员(执行充值的操作员)
	private String detailedType;			//充值明细类型(0表示办卡 ，1表示充值，2表示续卡)

	private String  cardRenewalTime;			//续卡之前的时间
	private String cardAfterrenewing;			//续卡之后的时间
	
	private Long giftAmount;//赠送金额
	
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
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

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getMemberId() {
		return this.memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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

	public Integer getCardType() {
		return cardType;
	}
	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}
	public Long getRechargeValue() {
		return rechargeValue;
	}
	public void setRechargeValue(Long rechargeValue) {
		this.rechargeValue = rechargeValue;
	}
	public String getOperateUserId() {
		return this.operateUserId;
	}
	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}

	public String getDetailedType() {
		return detailedType;
	}

	public void setDetailedType(String detailedType) {
		this.detailedType = detailedType;
	}

	public String getCardRenewalTime() {
		return cardRenewalTime;
	}

	public void setCardRenewalTime(String cardRenewalTime) {
		this.cardRenewalTime = cardRenewalTime;
	}

	public String getCardAfterrenewing() {
		return cardAfterrenewing;
	}

	public void setCardAfterrenewing(String cardAfterrenewing) {
		this.cardAfterrenewing = cardAfterrenewing;
	}
	public Long getGiftAmount() {
		return giftAmount;
	}
	public void setGiftAmount(Long giftAmount) {
		this.giftAmount = giftAmount;
	}
	
}