package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 指定中奖人(lottery_award_assign)
 * @author auto bin.yin 2018.07.26
 */
public class LotteryAwardAssign extends AbstractEntity {
	private static final long serialVersionUID = 1532590515817L;

	private String type; //类型
	private String authId; //认证ID
	private String appid; //应用ID
	private String lotteryId; //抽奖活动ID
	private String sessionId; //会话用户ID
	private String openid; //标识
	private String nickname; //昵称
	private String prizeId; //奖品ID

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthId() {
		return this.authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAppid() {
		return this.appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getLotteryId() {
		return this.lotteryId;
	}
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}
	public String getSessionId() {
		return this.sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getOpenid() {
		return this.openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return this.nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPrizeId() {
		return this.prizeId;
	}
	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}
}