package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 充值卡表(tenant_rechargeable_card)
 * @author auto bin.yin 2017.04.26
 */
@LogRequired
public class TenantRechargeableCard extends AbstractEntity {
	private static final long serialVersionUID = 1493191121997L;

	private String userId; //用户id
	private String rechargeableCardGroupId; //
	private String beginTime; //有效开始日期
	private String endTime; //有效结束日期
	private String cardNo; //卡号
	private Integer amount; //运动卡金额(单位为分)
	private String password; //卡密
	private String transactionId; //交易表id

	public TenantRechargeableCard() {
	}
	
	public TenantRechargeableCard(TenantRechargeableCardGroup tenantRechargeableCardGroup) {
		this.setRechargeableCardGroupId(tenantRechargeableCardGroup.getId());
		this.setAmount(tenantRechargeableCardGroup.getAmount());
		this.setBeginTime(tenantRechargeableCardGroup.getBeginTime());
		this.setEndTime(tenantRechargeableCardGroup.getEndTime());
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRechargeableCardGroupId() {
		return this.rechargeableCardGroupId;
	}
	public void setRechargeableCardGroupId(String rechargeableCardGroupId) {
		this.rechargeableCardGroupId = rechargeableCardGroupId;
	}

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getTransactionId() {
		return this.transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}