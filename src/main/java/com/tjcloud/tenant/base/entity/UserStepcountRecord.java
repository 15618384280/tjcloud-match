package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 用户步数计数明细(user_stepcount_record)
 * @author auto bin.yin 2019.04.11
 */
public class UserStepcountRecord extends AbstractEntity {
	private static final long serialVersionUID = 1554969619636L;

	private String userId; //用户id
	private String reportDate; //运动日期
	private Integer stepcount; //运动步数
	private Long reportTime; //上报时间
	private Integer reportChannel; //上报渠道
	private Boolean valid; //是否有效

	public String getReportTimeText() {
		if(this.reportTime != null) {
			return DateUtils.toString(this.reportTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
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
	public Long getReportTime() {
		return this.reportTime;
	}
	public void setReportTime(Long reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getReportChannel() {
		return this.reportChannel;
	}
	public void setReportChannel(Integer reportChannel) {
		this.reportChannel = reportChannel;
	}
}