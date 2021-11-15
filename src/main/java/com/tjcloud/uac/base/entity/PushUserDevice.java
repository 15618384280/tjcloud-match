package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 用户设备维护表(push_user_device)
 * @author auto bin.yin 2016.12.07
 */
@LogRequired
public class PushUserDevice extends AbstractEntity {
	private static final long serialVersionUID = 1481079810444L;

	private String token; //token
	private String userId; //用户id
	private String deviceId; //设备号
	private Integer type; //类型 0-安卓 1-ios

	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return this.deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}