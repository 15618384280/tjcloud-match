package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡类型限制设置(member_card_limittime)
 * @author auto bin.yin 2018.03.15
 */
public class MemberCardLimittime extends AbstractEntity {
	private static final long serialVersionUID = 1521099788087L;

	private String categoryId; 									//会员卡类型ID
	private Integer type; 										//1-每天限制,2-每周限制,3-每月限制，4-周几限制，5-每年限制，6-时间区间限制
	private Long startTime; 									//时间区间限制开始时间
	private Long endTime; 										//时间区间限制结束时间
	private Integer weekDays; 									//限制周几可以使用
	private Integer times; 										//限制次数
	private Integer minutes; 									//限制分钟

	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Long getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Integer getTimes() {
		return this.times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public Integer getMinutes() {
		return this.minutes;
	}
	public void setMinutes(Integer minutes) {
		this.minutes = minutes;
	}
	public Integer getWeekDays() {
		return weekDays;
	}
	public void setWeekDays(Integer weekDays) {
		this.weekDays = weekDays;
	}
}