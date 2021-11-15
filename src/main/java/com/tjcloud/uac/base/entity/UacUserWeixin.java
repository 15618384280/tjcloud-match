package com.tjcloud.uac.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (uac_user_weixin)
 * @author auto bin.yin 2017.07.21
 */
public class UacUserWeixin extends AbstractEntity {
	private static final long serialVersionUID = 1500608428415L;

	private String openid; //
	private Integer user_id; //
	private Boolean synchroAccount; //同步账号(0.未同步,1.已同步)

	public String getOpenid() {
		return this.openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getUser_id() {
		return this.user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Boolean getSynchroAccount() {
		return this.synchroAccount;
	}
	public void setSynchroAccount(Boolean synchroAccount) {
		this.synchroAccount = synchroAccount;
	}
}