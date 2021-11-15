package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 公告须知表(bulletin_board)
 * @author auto bin.yin 2016.12.12
 */
public class BulletinBoard extends AbstractEntity {
	private static final long serialVersionUID = 1481527808498L;

	private String tenantId; 									//租户Id
	private String stadiumId; 									//场馆ID
	private Integer type; 										//类型（1-公告内容,2-用户须知）
	private String title; 										//免责申明
	private String content; 									//概要
	private Integer invalid; 									//失效
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getInvalid() {
		return invalid;
	}
	public void setInvalid(Integer invalid) {
		this.invalid = invalid;
	}

}