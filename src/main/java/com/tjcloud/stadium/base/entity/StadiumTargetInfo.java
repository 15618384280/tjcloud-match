package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆目标设定表(stadium_target_info)
 * @author auto bin.yin 2018.02.22
 */
public class StadiumTargetInfo extends AbstractEntity {
	private static final long serialVersionUID = 1519279013058L;

	private String tenantId; //商户id
	private String stadiumId; //场馆id
	private Integer year; //年
	private Integer month; //月
	private String collectDate; //年月（201801）
	private Long collectTime; //目标x年x月1日时间
	private Long targetAmount; //目标值（单位：分）
	private Long orderNum; //订单量
	
	public Long getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
	public String getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(String collectDate) {
		this.collectDate = collectDate;
	}
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public Integer getYear() {
		return this.year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getMonth() {
		return this.month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Long getTargetAmount() {
		return this.targetAmount;
	}
	public void setTargetAmount(Long targetAmount) {
		this.targetAmount = targetAmount;
	}
}