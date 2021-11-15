package com.tjcloud.uac.api.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.uac.base.entity.RechargeCard;

/**
 * 
 * @author Administrator
 *
 */
public class RechargeCardVO implements Serializable {
	private static final long serialVersionUID = 1471333865128L;
	private String id;//票券主键id
	private String cardNo; //卡号
	private String startTime; //有效开始时间
	private String endTime; //有效结束时间
	private Integer perAmount; //金额,单位分
	private String password; //卡密
	private String rechargeCardGroupId; //充值卡组ID
	private String userId; //用户ID
	private String orderId; //交易ID
	private boolean disabled; //删除标记
	private boolean available; //有效性（true有效false无效）

	public RechargeCardVO(RechargeCard rechargeCard) {
		BeanUtils.copyProperties(rechargeCard, this);
		this.setStartTime(DateUtils.toString(rechargeCard.getStartTime()));
		this.setEndTime(DateUtils.toString(rechargeCard.getEndTime()));
	}
	
	public RechargeCardVO() {
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStartTime() {
		return this.startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
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

	public boolean isDisabled() {
		return this.disabled;
	}
	public void setDisabled(boolean b) {
		this.disabled = b;
	}

	public boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
}