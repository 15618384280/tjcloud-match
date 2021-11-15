package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆公告(stadium_notice)
 * @author auto bin.yin 2019.03.13
 */
public class StadiumNotice extends AbstractEntity {
	private static final long serialVersionUID = 1552462475118L;

	private String stadiumId; //场馆id
	private String noticeTitle; //公告标题
	private String noticeText; //公告内容
	private Long beginTime; //开始时间
	private Long overTime; //结束时间
	private Integer online; //是否生效
	private Boolean isTop; //是否置顶
	private String tenantUserId; //创建人
	private String tenantUser; //创建人

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getNoticeTitle() {
		return this.noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeText() {
		return this.noticeText;
	}
	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}
	public Long getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}
	public Long getOverTime() {
		return this.overTime;
	}
	public void setOverTime(Long overTime) {
		this.overTime = overTime;
	}
	public Integer getOnline() {
		return this.online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public Boolean getIsTop() {
		return this.isTop;
	}
	public void setIsTop(Boolean isTop) {
		this.isTop = isTop;
	}
	public String getTenantUserId() {
		return this.tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	public String getTenantUser() {
		return this.tenantUser;
	}
	public void setTenantUser(String tenantUser) {
		this.tenantUser = tenantUser;
	}
}