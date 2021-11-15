package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 视频捕捉用户表(uac_player)
 * @author auto bin.yin 2019.03.08
 */
public class UacPlayer extends AbstractEntity {
	private static final long serialVersionUID = 1552012224714L;

	private String id; //用户id
	private String tenantId; //姓名
	private String token; //第三方登录token
	private String phone; //手机号
	private String playerId; //运动员id
	private String playerData; //第三方注册返回的json数据

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerData() {
		return playerData;
	}

	public void setPlayerData(String playerData) {
		this.playerData = playerData;
	}
}