package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 学校开放非法越界告警信息处理表
(face_warn_deal)
 * @author auto bin.yin 2019.08.26
 */
public class FaceWarnDeal extends AbstractEntity {
	private static final long serialVersionUID = 1566790431113L;

	private String warnId; //摄像头ID
	private Long dealTime; //处理时间
	private String dealDescription; //处理描述
	private String dealUserId; //处理人ID
	private String dealUserName; //处理人姓名

	public String getWarnId() {
		return this.warnId;
	}
	public void setWarnId(String warnId) {
		this.warnId = warnId;
	}
	public Long getDealTime() {
		return this.dealTime;
	}
	public void setDealTime(Long dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealDescription() {
		return this.dealDescription;
	}
	public void setDealDescription(String dealDescription) {
		this.dealDescription = dealDescription;
	}
	public String getDealUserId() {
		return this.dealUserId;
	}
	public void setDealUserId(String dealUserId) {
		this.dealUserId = dealUserId;
	}
	public String getDealUserName() {
		return this.dealUserName;
	}
	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}
}