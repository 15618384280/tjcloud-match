package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 用户步数计数(user_stepcount)
 * @author auto bin.yin 2019.04.11
 */
public class UserStepcount extends AbstractEntity {
	private static final long serialVersionUID = 1554969619483L;

	private String userId; //用户id
	private String reportDate; //运动日期
	private Integer stepcount; //运动步数
	private Long lastReportTime; //最后一次上报时间
	private Integer lastReportChannel; //最后一次上报渠道
	private String uniqueKey; //userId+reportDate

	public String getLastReportTimeText() {
		if(this.lastReportTime != null) {
			return DateUtils.toString(this.lastReportTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReportDate() {
		return this.reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public Integer getStepcount() {
		return this.stepcount;
	}
	public void setStepcount(Integer stepcount) {
		this.stepcount = stepcount;
	}
	public Long getLastReportTime() {
		return this.lastReportTime;
	}
	public void setLastReportTime(Long lastReportTime) {
		this.lastReportTime = lastReportTime;
	}
	public Integer getLastReportChannel() {
		return this.lastReportChannel;
	}
	public void setLastReportChannel(Integer lastReportChannel) {
		this.lastReportChannel = lastReportChannel;
	}
	public String getUniqueKey() {
		return this.uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
}