package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 抽奖机会(lottery_chance)
 * @author auto bin.yin 2018.07.26
 */
public class LotteryChance extends AbstractEntity {
	private static final long serialVersionUID = 1532590515882L;

	private String lotteryId; //抽奖活动ID
	private String userId; //用户ID
	private String openid; //微信用户ID
	private Integer chance; //剩余机会

	public String getLotteryId() {
		return this.lotteryId;
	}
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOpenid() {
		return this.openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getChance() {
		return this.chance;
	}
	public void setChance(Integer chance) {
		this.chance = chance;
	}
}