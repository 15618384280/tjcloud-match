package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 签到记录表(user_checkin_record)
 * @author auto bin.yin 2019.02.18
 */
public class UserCheckinRecord extends AbstractEntity {
	private static final long serialVersionUID = 1550474908571L;

	private String userId; //用户id
	private Long checkinTime; //签到时间
	private String checkinDate; //签到日期
	private Long integral; //积分

	public String getCheckinTimeText() {
		if(this.checkinTime != null) {
			return DateUtils.toString(this.checkinTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getCheckinTime() {
		return this.checkinTime;
	}
	public void setCheckinTime(Long checkinTime) {
		this.checkinTime = checkinTime;
	}
	public String getCheckinDate() {
		return this.checkinDate;
	}
	public void setCheckinDate(String checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
}