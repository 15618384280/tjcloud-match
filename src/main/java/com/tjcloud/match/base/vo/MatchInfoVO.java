package com.tjcloud.match.base.vo;

import com.tjcloud.core.Constants;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.match.base.entity.MatchInfo;

public class MatchInfoVO extends MatchInfo{
	
	private static final long serialVersionUID = -8988613236777674890L;
	
	private String startTimeStr; 								//赛事开始时间
	private String endTimeStr; 									//赛事结束时间
	private String upStartTimeStr; 								//赛事报名开始时间
	private String upEndTimeStr; 								//赛事报名结束时间
	private String stateStr; 									//状态（0-保存,1-报名中,2-比赛中,3-已结束）
	
	
	public String getStartTimeStr() {
		return startTimeStr;
	}
	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
		super.setStartTime(DateUtils.toLong(startTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getEndTimeStr() {
		return endTimeStr;
	}
	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
		super.setEndTime(DateUtils.toLong(endTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getUpStartTimeStr() {
		return upStartTimeStr;
	}
	public void setUpStartTimeStr(String upStartTimeStr) {
		this.upStartTimeStr = upStartTimeStr;
		super.setUpStartTime(DateUtils.toLong(upStartTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	
	public String getUpEndTimeStr() {
		return upEndTimeStr;
	}
	public void setUpEndTimeStr(String upEndTimeStr) {
		this.upEndTimeStr = upEndTimeStr;
		super.setUpEndTime(DateUtils.toLong(upEndTimeStr, Constants.YYYY_MM_DD_HH_MM_SS));
	}
	public String getStateStr() {
		return stateStr;
	}
	public void setStateStr(String stateStr) {
		this.stateStr = stateStr;
	}
	
	
}
