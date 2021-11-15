package com.tjcloud.uac.base.entity;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.uac.api.vo.RechargeCardVO;

/**
 * 充值卡表(uac_recharge_card)
 * @author auto bin.yin 2016.08.16
 */
@LogRequired
public class RechargeCard extends AbstractEntity {
	private static final long serialVersionUID = 1471333865128L;

	private String cardNo; //卡号
	private Long startTime; //有效开始时间
	private Long endTime; //有效结束时间
	private Integer perAmount; //金额,单位分
	private String password; //卡密
	private String rechargeCardGroupId; //充值卡组ID
	private String userId; //用户ID
	private String orderId; //交易ID
	private boolean available; //有效性（true有效false无效）
	
	public RechargeCard(RechargeCardVO rechargeCardVO) {
		BeanUtils.copyProperties(rechargeCardVO, this);
		this.setStartTime(DateUtils.toLong(rechargeCardVO.getStartTime()));
		this.setEndTime(DateUtils.toLong(rechargeCardVO.getEndTime()));
	}
	public RechargeCard() {
	}
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Integer getPerAmount() {
		return this.perAmount;
	}
	public void setPerAmount(Integer perAmount) {
		this.perAmount = perAmount;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRechargeCardGroupId() {
		return this.rechargeCardGroupId;
	}
	public void setRechargeCardGroupId(String rechargeCardGroupId) {
		this.rechargeCardGroupId = rechargeCardGroupId;
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

	public boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}