package com.tjcloud.order.api.vo;

import java.io.Serializable;

public class MemberCardTransSummaryVO implements Serializable{

	private static final long serialVersionUID = 1050905727366359432L;

	private String memberCardId;
	private Long rechargeAmount;
	private Long consumeAmount;
	private Long lastRechargeTime;
	private Long lastConsumeTime;
	
	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	public Long getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(Long rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public Long getConsumeAmount() {
		return consumeAmount;
	}
	public void setConsumeAmount(Long consumeAmount) {
		this.consumeAmount = consumeAmount;
	}
	public Long getLastRechargeTime() {
		return lastRechargeTime;
	}
	public void setLastRechargeTime(Long lastRechargeTime) {
		this.lastRechargeTime = lastRechargeTime;
	}
	public Long getLastConsumeTime() {
		return lastConsumeTime;
	}
	public void setLastConsumeTime(Long lastConsumeTime) {
		this.lastConsumeTime = lastConsumeTime;
	}
	
}